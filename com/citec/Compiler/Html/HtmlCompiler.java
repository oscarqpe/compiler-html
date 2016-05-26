package com.citec.Compiler.Html;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Set;
//import javaScriptCompiler.Main.VerboseListener;
//import javaScriptCompiler.Main.VerboseListener;

public class HtmlCompiler {

	/**
	 * @param args
	 */
	//public static List<String> listErrorSyntax;
	public static List<Recommendation> listErrorSyntax;
	
	public static class VerboseListener extends BaseErrorListener {
	    @Override
	    public void syntaxError(Recognizer<?, ?> recognizer,
	                            Object offendingSymbol,
	                            int line, int charPositionInLine,
	                            String msg,
	                            RecognitionException e)
	    {
	    	//System.out.println("LLEGUEE ACA ERRORRR");
	        List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
	        Collections.reverse(stack);
	       // System.out.println("regla pila: "+stack);
	       // System.out.println("linea "+line+":"+charPositionInLine+" como "+
	        //                   ": "+msg);
	        //listErrorSyntax.add("linea "+line+":"+charPositionInLine+" error sintaxis"+": "+msg);
	        Recommendation rec = new  Recommendation();
	        rec.setLineNumber(line);
	        rec.setColumnNumber(charPositionInLine);
	        rec.setDescription(msg);
	        listErrorSyntax.add(rec);
	    }

	}
	
	public List<CodeEntity> listSolucionesE;
	public List<CodeEntity> listSolucionesLabE;
	public List<SolutionEntity> listTree;
	public List<SolutionEntity> listTreeLab;

	public static List<String> listExpreP1;
	public static List<String> listExpreContP1;
	public static List<String> listExpreTagP1;
	public static List<List<String>> listExpreStyleP1;

	public HtmlCompiler() {
		listSolucionesE = new ArrayList<CodeEntity>();
		listSolucionesLabE = new ArrayList<CodeEntity>();
		listTree = new ArrayList<SolutionEntity>();
		listTreeLab = new ArrayList<SolutionEntity>();
		listExpreP1 = new ArrayList<String>();
		listExpreContP1 = new ArrayList<String>();
		listExpreTagP1 = new ArrayList<String>();
		listExpreStyleP1 = new ArrayList<List<String>>();
		listErrorSyntax = new ArrayList<Recommendation>();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(args);
		int datos = 0;
		if (args.length > 0)
			datos = Integer.parseInt(args[0]);
		
		ErrorMessage.InitErrorMessage();
		ExpresionRules.InitRules();
		ConnectionManager.GetConnection();
		Silabus.initSilabus();

		HtmlCompiler obj = new HtmlCompiler();
		String fileSol = "/home/julio/Documentos/solucionesProf.csv";
		String fileSolLab = "/home/julio/Documentos/solucionesLab.csv";

		List<CodeEntity> solutions = ConnectionManager.getSolutions();
		List<CodeEntity> results = ConnectionManager.getSolutionEstudents(datos);
		System.out.println("Results size: " + results.size());
		// Cargar data de soluciones y generar ParseTree
		/*int cont =0;
		for (CodeEntity codeEntity : solutions) {
		System.out.println("CODIGOOOO = " + cont);
		if(!codeEntity.getCode().equals(""))
		System.out.println(codeEntity.getCode());
		cont++;
		}*/
		// obj.listSolucionesE=obj.loadData(fileSol);
		obj.listSolucionesE = solutions;
		// obj.showData(obj.listSolucionesE);

		// CARGA LAS SOLUCIONES Y LOS PARSER DE PROFESOR
		obj.runCompile();

		// CREAMOS LOS AST Y REGLAS DE RUBRICA DEL PROFESOR
		List<ValidationRules> listRules = new ArrayList<ValidationRules>();
		for (int i = 0; i < obj.listTree.size(); i++) {
			Boolean boolSol = obj.listTree.get(i).getSolValVisitor();
			int idPage = obj.listTree.get(i).getEntity().getPageId();
			EvalVisitorProf evaluar = new EvalVisitorProf(idPage, boolSol);
			evaluar.visit(obj.listTree.get(i).getTree());
			ValidationRules rules = evaluar.getValidationRules();
			listRules.add(rules);
		}

		// evaluar.visit(obj.listTree.get(2).getTree());
		// ValidationRules valRul =evaluar.getValidationRules();
		// Cargar data solucion Chicas y generar ParseTree;

		// obj.listSolucionesLabE = obj.loadData(fileSolLab);
		//CARGAMOS LAS SOLUCIOENS DE LAS CHICAS
		obj.listSolucionesLabE = results;
		System.out.println("EVALUAR DATA DE CHICAS");
		obj.runCompileLab();

		// calculamos las soluciones similares

		obj.evalSimilarity(datos);
		System.out.println("YA TEERMINO LEVENSGTEIN");
		// obj.evalSimilarityAST(valRul);
		List<Solution> solutions_ = new ArrayList<Solution>();
		List<Solution> temp_ = new ArrayList<Solution>();
		for (int i = 0; i < listRules.size(); i++) {
			temp_ = obj.evalSimilarityAST(listRules.get(i));
			solutions_.addAll(temp_);
		}
		ConnectionManager.UpdateSimilitudAST(solutions_, datos);
		System.out.println("YA TERMINO.. AST");
	}
	
	public Solution singleSimilarityAST(CodeEntity entity, List<ValidationRules> listrules){
		
		ValidationRules rules=getRuler(entity.getPageId(), listrules);
		
		ANTLRInputStream input = new ANTLRInputStream(entity.getCode());
		HTMLLexer lexer = new HTMLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		HTMLParser parser = new HTMLParser(tokens);
		
		parser.removeErrorListeners(); // remove ConsoleErrorListener
        parser.addErrorListener(new VerboseListener()); // add ours
        ParseTree tree = parser.htmlDocument();
        List<Recommendation> errorsSyn = new ArrayList<Recommendation>();
        for(Recommendation s : listErrorSyntax){
        	Recommendation r = new Recommendation();
        	r.setColumnNumber(s.getColumnNumber());
        	r.setLineNumber(s.getLineNumber());
        	r.setDescription(replaceComillas(s.getDescription()));
        	errorsSyn.add(r);
        }
		SolutionEntity solLab = new SolutionEntity(tree, entity, parser, false, errorsSyn);		
		listErrorSyntax.clear();
		
		Solution sol = new Solution();
		EvalVisitorSimilarity eval = new EvalVisitorSimilarity(
				solLab.getEntity(), rules);
		eval.visit(solLab.getTree());
		int val = eval.getSimilarity();
		if (val != 0) {
			System.out.println("Similitud para Pagina =  "
					+ rules.getPageId() + " Para usuario = "
					+ solLab.getEntity().getUserId()
					+ " distancia = " + val);
		}
		sol.setAnswer_id(solLab.getEntity().getAnswerId());
		sol.setPage_id(solLab.getEntity().getPageId());
		sol.setUser_id(solLab.getEntity().getUserId());
		sol.setSimilitud_ast(val);
		

		
		return null;
	}
	public Solution singleEvalSimilarity(CodeEntity entity){
		ANTLRInputStream input = new ANTLRInputStream(entity.getCode());
		HTMLLexer lexer = new HTMLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		HTMLParser parser = new HTMLParser(tokens);
		LevenshteinDistance ld = new LevenshteinDistance();

		parser.removeErrorListeners(); // remove ConsoleErrorListener
        parser.addErrorListener(new VerboseListener()); // add ours
        ParseTree tree = parser.htmlDocument();
        List<Recommendation> errorsSyn = new ArrayList<Recommendation>();
        for(Recommendation s : listErrorSyntax){
        	Recommendation r = new Recommendation();
        	r.setColumnNumber(s.getColumnNumber());
        	r.setLineNumber(s.getLineNumber());
        	r.setDescription(replaceComillas(s.getDescription()));
        	errorsSyn.add(r);
        }
		SolutionEntity solLab = new SolutionEntity(tree, entity, parser, false, errorsSyn);		
		listErrorSyntax.clear();
		
		SolutionEntity solProf=getSolutionEntity(entity.getPageId());
		
		String str = solProf.getTree().toStringTree(solProf.getParser());
		String str2 = solLab.getTree().toStringTree(solLab.getParser());
		
		str = quitaEspacios(str);
		str2 = quitaEspacios(str2);
		int val = ld.computeLevenshteinDistance(str, str2);
		Solution solution = new Solution();
		solution.setPage_id(solProf.getEntity().getPageId());
		solution.setUser_id(solLab.getEntity().getUserId());
		solution.setAnswer_id(solLab.getEntity().getAnswerId());
		solution.setSimilitud_levenshtein(val);

		List<Recommendation> errors = new ArrayList<Recommendation>();

		EvalVisitor eval = new EvalVisitor(solLab.getEntity(),
				solProf, solProf.getSolValVisitor());
		eval.visit(solLab.getTree());
		int errorID = 0;
		for (ErrorCompiler e : Exceptions.ListExceptions) {
			// System.out.println("Error "+ e.id+" :"+
			// "Linea "+e.numLine+" "+e.message);
			Recommendation rec = new Recommendation();
			rec.setDescription("Error " + e.id + " :" + "Linea "
					+ e.numLine + " " + e.message);
			rec.setLineNumber(e.numLine);
			rec.setColumnNumber(0);
			errors.add(rec);
			errorID = Integer.parseInt(e.id);
			System.out.println("Error " + e.id + " :" + " userId: "
					+ solLab.getEntity().getUserId()
					+ " Pagina ID "
					+ solLab.getEntity().getPageId()
					+ " Similitud:  "
					+ val
					+ "Linea " + e.numLine + " " + e.message);
			
		}
		for (Recommendation r: solLab.getListErrorSyntax()) {
			System.out.println("Syntax ERror");
			Recommendation rec = new Recommendation();
			rec.setDescription("Syntax Error " + (errorID + 1) + " :" + "Linea "
					+ r.getLineNumber() + " " + r.getDescription());
			rec.setLineNumber(r.getLineNumber());
			rec.setColumnNumber(r.getColumnNumber());
			errors.add(rec);
			errorID++;
		}
		List<String> recommendations = new ArrayList<String>();
		for(String r : Exceptions.ListRecomendations){
			//System.out.println(r);
			recommendations.add(r);
		}

		solution.setErrors(errors);
		solution.setRecommendations(recommendations);
		Exceptions.ListExceptions.clear();
		Exceptions.ListRecomendations.clear();
		
		// ACA YA SE TIENE LA SOLUTION NO SE QUE HACER :V
		
		
		
		

		
		return null;
	}
	
	public SolutionEntity getSolutionEntity(int id){
		for (SolutionEntity solucion : listTree) {
			if(solucion.getEntity().getPageId()==id){
				return solucion;
			}
		}
		return null;		
	}
	
	public ValidationRules  getRuler(int id,List<ValidationRules> listrules ){
		for (ValidationRules validationRules : listrules) {
			if (validationRules.getPageId()==id){
				return validationRules;
			}
		}
		return null;
	}
	

	public List<Solution> evalSimilarityAST(ValidationRules rules) {
		List<Solution> solutions = new ArrayList<Solution>();
		// for (SolutionEntity solucion : listTree) {
		for (SolutionEntity solucionLab : listTreeLab) {
			if (rules.getPageId() == solucionLab.getEntity().getPageId()) {
				Solution sol = new Solution();
				EvalVisitorSimilarity eval = new EvalVisitorSimilarity(
						solucionLab.getEntity(), rules);
				eval.visit(solucionLab.getTree());
				int val = eval.getSimilarity();
				if (val != 0) {
					System.out.println("Similitud para Pagina =  "
							+ rules.getPageId() + " Para usuario = "
							+ solucionLab.getEntity().getUserId()
							+ " distancia = " + val);
				}
				sol.setAnswer_id(solucionLab.getEntity().getAnswerId());
				sol.setPage_id(solucionLab.getEntity().getPageId());
				sol.setUser_id(solucionLab.getEntity().getUserId());
				sol.setSimilitud_ast(val);
				solutions.add(sol);
				/*
				 * f(val!=0){ System.out.println(""+ val); }
				 */
			}
			
		}
		// }
		return solutions;
	}

	public void evalSimilarity(int datos) throws SQLException {
		List<Solution> solutions = new ArrayList<Solution>();
		LevenshteinDistance ld = new LevenshteinDistance();
		for (SolutionEntity solucion : listTree) {
			for (SolutionEntity solucionLab : listTreeLab) {
				if (solucion.getEntity().getPageId() == solucionLab.getEntity()
						.getPageId()) {
					String str = solucion.getTree()
							.toStringTree(solucionLab.getParser());
					String str2 = solucionLab
							.getTree().toStringTree(solucionLab.getParser());
					str = quitaEspacios(str);
					str2 = quitaEspacios(str2);
					int val = ld.computeLevenshteinDistance(str, str2);

					listExpreContP1.clear();
					listExpreP1.clear();
					listExpreTagP1.clear();

					if (solucionLab.getEntity().getPageId() == 3) {
						initExpresionesP1();
					}
					if (solucionLab.getEntity().getPageId() == 6) {
						initExpresionesP2();
					}
					if (solucionLab.getEntity().getPageId() == 10) {
						initExpresionesP3();
					}

					Solution solution = new Solution();
					solution.setPage_id(solucion.getEntity().getPageId());
					solution.setUser_id(solucionLab.getEntity().getUserId());
					solution.setAnswer_id(solucionLab.getEntity().getAnswerId());
					solution.setSimilitud_levenshtein(val);

					List<Recommendation> errors = new ArrayList<Recommendation>();

					EvalVisitor eval = new EvalVisitor(solucionLab.getEntity(),
							solucion, solucion.getSolValVisitor());
					eval.visit(solucionLab.getTree());
					int errorID = 0;
					for (ErrorCompiler e : Exceptions.ListExceptions) {
						// System.out.println("Error "+ e.id+" :"+
						// "Linea "+e.numLine+" "+e.message);
						Recommendation rec = new Recommendation();
						rec.setDescription("Error " + e.id + " :" + "Linea "
								+ e.numLine + " " + e.message);
						rec.setLineNumber(e.numLine);
						rec.setColumnNumber(0);
						errors.add(rec);
						errorID = Integer.parseInt(e.id);
						System.out.println("Error " + e.id + " :" + " userId: "
								+ solucionLab.getEntity().getUserId()
								+ " Pagina ID "
								+ solucionLab.getEntity().getPageId()
								+ " Similitud:  "
								+ val
								+ "Linea " + e.numLine + " " + e.message);
						
					}
					for (Recommendation r: solucionLab.getListErrorSyntax()) {
						System.out.println("Syntax ERror");
						Recommendation rec = new Recommendation();
						rec.setDescription("Syntax Error " + (errorID + 1) + " :" + "Linea "
								+ r.getLineNumber() + " " + r.getDescription());
						rec.setLineNumber(r.getLineNumber());
						rec.setColumnNumber(r.getColumnNumber());
						errors.add(rec);
						errorID++;
					}
					List<String> recommendations = new ArrayList<String>();
					for(String r : Exceptions.ListRecomendations){
						//System.out.println(r);
						recommendations.add(r);
					}

					solution.setErrors(errors);
					solution.setRecommendations(recommendations);
					Exceptions.ListExceptions.clear();
					Exceptions.ListRecomendations.clear();
					solutions.add(solution);
				}
			}
		}

		ConnectionManager.PruebaQuery(solutions, datos);

	}

	public void runCompileLab() {
		for (int i = 0; i < listSolucionesLabE.size(); i++) {
			CodeEntity entity = listSolucionesLabE.get(i);
			//System.out.println("Pagina: "+ entity.getPageId() + " usuario id: "+entity.getUserId());
			ANTLRInputStream input = new ANTLRInputStream(entity.getCode());
			HTMLLexer lexer = new HTMLLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			HTMLParser parser = new HTMLParser(tokens);
			 
													
			//System.out.println("LLEGUE ACA");
			parser.removeErrorListeners(); // remove ConsoleErrorListener
	        parser.addErrorListener(new VerboseListener()); // add ours
	        ParseTree tree = parser.htmlDocument();
	        List<Recommendation> errorsSyn = new ArrayList<Recommendation>();
	        for(Recommendation s : listErrorSyntax){
	        	//System.out.println("UserId: "+entity.getUserId()+" PageId: " +entity.getPageId()+"ERROR :"+s);
	        	Recommendation r = new Recommendation();
	        	r.setColumnNumber(s.getColumnNumber());
	        	r.setLineNumber(s.getLineNumber());
	        	r.setDescription(replaceComillas(s.getDescription()));
	        	errorsSyn.add(r);
	        }
	        //System.out.println("List ERror syn ............." + listErrorSyntax.size());
	        
	        // errorsSyn = listErrorSyntax;
			SolutionEntity sol = new SolutionEntity(tree, entity, parser, false, errorsSyn);
			//sol.setListErrorSyntax(listErrorSyntax);
			listTreeLab.add(sol);
			
			listErrorSyntax.clear();
			// EvalVisitor eval = new EvalVisitor(entity);
			// eval.visit(tree);
			// System.out.println(tree.toStringTree(parser)); // print tree as
			// text <label id="code.tour.main.7"/>

		}
	}

	public void runCompileLabVisitor() {
		for (int i = 0; i < listSolucionesLabE.size(); i++) {
			// for (int i=0 ; i<735; i++){
			CodeEntity entity = listSolucionesLabE.get(i);
			ANTLRInputStream input = new ANTLRInputStream(entity.getCode());
			HTMLLexer lexer = new HTMLLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			HTMLParser parser = new HTMLParser(tokens);
			ParseTree tree = parser.htmlDocument(); // parse; start at prog
													// <label
													// id="code.tour.main.6"/>
			listTreeLab.add(new SolutionEntity(tree, entity, parser, false));
			listExpreContP1.clear();
			listExpreP1.clear();
			listExpreTagP1.clear();

			if (entity.getPageId() == 3) {
				initExpresionesP1();
			}
			if (entity.getPageId() == 6) {
				initExpresionesP2();
			}
			if (entity.getPageId() == 10) {
				initExpresionesP3();
			}

			int pageId = entity.getPageId();
			SolutionEntity entitySol = findEntity(pageId);
			EvalVisitor eval = new EvalVisitor(entity, entitySol,
					entitySol.getSolValVisitor());
			eval.visit(tree);
			for (ErrorCompiler e : Exceptions.ListExceptions) {
				System.out.println("Error " + e.id + " :" + "Linea "
						+ e.numLine + " " + e.message);
			}
			// System.out.println("TERMINE");

		}
	}

	public SolutionEntity findEntity(int pageId) {
		for (int i = 0; i < listTree.size(); i++) {
			if (pageId == listTree.get(i).getEntity().getPageId()) {
				return listTree.get(i);
			}
		}
		return null;
	}

	public void showData(List<CodeEntity> l) {
		for (int i = 0; i < l.size(); i++) {
			CodeEntity entity = l.get(i);
			System.out.println("ID Sol: " + entity.getAnswerId() + "Page id: "
					+ entity.getPageId() + " Unit id: " + entity.getUserId()
					+ " code: " + entity.getCode());
		}

	}

	public void runCompile() {
		for (int i = 0; i < listSolucionesE.size(); i++) {
			CodeEntity entity = listSolucionesE.get(i);
			ANTLRInputStream input = new ANTLRInputStream(entity.getCode());
			HTMLLexer lexer = new HTMLLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			HTMLParser parser = new HTMLParser(tokens);
			ParseTree tree = parser.htmlDocument(); // parse; start at prog
													// <label
													// id="code.tour.main.6"/>
			if (entity.getPageId() == 3 || entity.getPageId() == 6
					|| entity.getPageId() == 10) {
				listTree.add(new SolutionEntity(tree, entity, parser, true));
			} else {
				listTree.add(new SolutionEntity(tree, entity, parser, false));
			}

			System.out.println(tree.toStringTree(parser)); // print tree as text
															// <label
															// id="code.tour.main.7"/>

		}
	}

	public void runTest() {

	}

	public List<CodeEntity> loadData(String file) {

		String csvFile = file;
		List<CodeEntity> listSol = new ArrayList<CodeEntity>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String codigo = "";

		int pageIdTemp = 0;
		int unitUserIdTemp = 0;
		int answerIdTemp = 0;

		int i = 0;
		try {

			br = new BufferedReader(new FileReader(csvFile));

			while ((line = br.readLine()) != null) {

				String[] code = line.split(cvsSplitBy);
				// System.out.println("ENTREEE");
				if (code.length == 3 || i == 0) {
					i = 1;
				} else {

					if (code.length == 4) {
						// System.out.println("ENTREEE");
						int answerId = Integer.parseInt(code[0]);
						int pageId = Integer.parseInt(code[1]);
						int unitUserId = Integer.parseInt(code[2]);

						if (!(codigo == "")) {
							String temp1 = eraserChar(0, codigo);
							String temp2 = eraserChar(temp1.length() - 1, temp1);
							String sTemp = temp2.replace("\"\"", "\"");
							listSol.add(new CodeEntity(pageIdTemp,
									unitUserIdTemp, sTemp, answerIdTemp));
							pageIdTemp = pageId;
							unitUserIdTemp = unitUserId;

						}

						pageIdTemp = pageId;
						unitUserIdTemp = unitUserId;
						answerIdTemp = answerId;
						codigo = "";
						codigo += code[3];

					} else {
						codigo = codigo + "\n" + code[0];
					}
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return listSol;

	}

	public String eraserChar(int i, String s) {
		String a = s.substring(0, i);
		String b = s.substring(i + 1, s.length());
		return a + b;
	}

	public static void initExpresionesP1() {

		listExpreP1.add("html");
		listExpreP1.add("head");
		listExpreP1.add("head");
		listExpreP1.add("body");
		listExpreP1.add("h1");
		listExpreP1.add("h1");
		listExpreP1.add("p");
		listExpreP1.add("p");
		listExpreP1.add("body");
		listExpreP1.add("html");

		listExpreContP1.add("laboratoria");
		listExpreContP1
				.add("En Laboratoria aprendemos a crear páginas web para empezar una carrera en el sector digital");

		listExpreTagP1.add("h1");
		listExpreTagP1.add("p");

		ExpresionValidation.initListExpre(listExpreP1);
		ExpresionValidation.initListExpreContent(listExpreContP1);
		ExpresionValidation.initListExpreTag(listExpreTagP1);
	}

	public static void initExpresionesP2() {

		listExpreP1.add("html");
		listExpreP1.add("head");
		listExpreP1.add("title");
		listExpreP1.add("title");
		listExpreP1.add("head");
		listExpreP1.add("body");
		listExpreP1.add("h1");
		listExpreP1.add("h1");
		listExpreP1.add("p");
		listExpreP1.add("p");
		listExpreP1.add("h4");
		listExpreP1.add("h4");
		listExpreP1.add("ol");
		listExpreP1.add("li");
		listExpreP1.add("li");
		listExpreP1.add("li");
		listExpreP1.add("li");
		listExpreP1.add("li");
		listExpreP1.add("li");
		listExpreP1.add("ol");
		listExpreP1.add("body");
		listExpreP1.add("html");

		listExpreContP1.add("Laboratoria Curso Básico");
		listExpreContP1.add("laboratoria");
		listExpreContP1
				.add("En Laboratoria aprendemos varios lenguajes para crear páginas web. A continuación presentamos una lista de los lenguajes que aprendemos.");

		listExpreTagP1.add("title");
		listExpreTagP1.add("h1");
		listExpreTagP1.add("p");

		ExpresionValidation.initListExpre(listExpreP1);
		ExpresionValidation.initListExpreContent(listExpreContP1);
		ExpresionValidation.initListExpreTag(listExpreTagP1);
	}

	public static void initExpresionesP3() {

		listExpreP1.add("html");
		listExpreP1.add("head");
		listExpreP1.add("title");
		listExpreP1.add("title");
		listExpreP1.add("head");
		listExpreP1.add("body");
		listExpreP1.add("h1");
		listExpreP1.add("h1");
		listExpreP1.add("p");
		listExpreP1.add("p");
		listExpreP1.add("h4");
		listExpreP1.add("h4");
		listExpreP1.add("ol");
		listExpreP1.add("li");
		listExpreP1.add("li");
		listExpreP1.add("li");
		listExpreP1.add("li");
		listExpreP1.add("li");
		listExpreP1.add("li");
		listExpreP1.add("ol");
		listExpreP1.add("body");
		listExpreP1.add("html");

		listExpreContP1.add("Laboratoria Curso Básico");
		listExpreContP1.add("laboratoria");
		listExpreContP1
				.add("En Laboratoria aprendemos varios lenguajes para crear páginas web. A continuación presentamos una lista de los lenguajes que aprendemos.");

		listExpreTagP1.add("title");
		listExpreTagP1.add("h1");
		listExpreTagP1.add("p");

		List<String> lstyle = new ArrayList<String>();
		lstyle.add("style=\"color:blue;font-size:22px;\"");
		lstyle.add("style=\"color:blue;font-size:22px\"");

		listExpreStyleP1.add(lstyle);

		ExpresionValidation.initListExpre(listExpreP1);
		ExpresionValidation.initListExpreContent(listExpreContP1);
		ExpresionValidation.initListExpreTag(listExpreTagP1);
		ExpresionValidation.initListExpreStyle(listExpreStyleP1);
	}
	public static String quitaEspacios(String texto) {
        java.util.StringTokenizer tokens = new java.util.StringTokenizer(texto);
        StringBuilder buff = new StringBuilder();
        while (tokens.hasMoreTokens()) {
            buff.append(" ").append(tokens.nextToken());
        }
        return buff.toString().trim();
}
	public static String replaceComillas(String texto) {
		texto = texto.replaceAll("\'", "");
		texto = texto.replaceAll("\"", "");
		
        return texto;
}
}
/*
 * public void runCompileLab(){ //for (int i=0 ; i<listSolucionesLabE.size();
 * i++){ for (int i=0 ; i<735; i++){ CodeEntity entity =
 * listSolucionesLabE.get(i); ANTLRInputStream input = new
 * ANTLRInputStream(entity.getCode()); HTMLLexer lexer = new HTMLLexer(input);
 * CommonTokenStream tokens = new CommonTokenStream(lexer); HTMLParser parser =
 * new HTMLParser(tokens); ParseTree tree = parser.htmlDocument(); // parse;
 * start at prog <label id="code.tour.main.6"/> listTreeLab.add(new
 * SolutionEntity(tree, entity,parser)); listExpreContP1.clear();
 * listExpreP1.clear(); listExpreTagP1.clear();
 * 
 * if(entity.getPageId()==3){ initExpresionesP1(); }if(entity.getPageId()==6){
 * initExpresionesP2(); }if(entity.getPageId()==10){ initExpresionesP3(); }
 * 
 * if(entity.getPageId()==3 || entity.getPageId()==6 || entity.getPageId()==10){
 * if(entity.getUserId()==240){ int pageId=entity.getPageId(); SolutionEntity
 * entitySol=findEntity(pageId);
 * 
 * EvalVisitor eval = new EvalVisitor(entity,entitySol); eval.visit(tree); for
 * (ErrorCompiler e : Exceptions.ListExceptions) { System.out.println("Error "+
 * e.id+" :"+ "Linea "+e.numLine+" "+e.message); }
 * System.out.println("TERMINE");
 * 
 * 
 * } }
 * 
 * 
 * //System.out.println(tree.toStringTree(parser)); // print tree as text <label
 * id="code.tour.main.7"/>
 * 
 * }
 * 
 * }
 */

/*
 * String s1="\"font-size:22px;color:blue;\"";
 * 
 * String s3=s1.replaceAll("\"", ""); System.out.println(s3); String
 * s2="\"color:blue;font-size:22px\""; String s4=s2.replaceAll("\"", "");
 * 
 * 
 * String[] ls1=s3.split(";"); for (String string : ls1) {
 * System.out.println(string); } System.out.println("-------------------");
 * String[] ls2=s4.split(";"); for (String string : ls2) {
 * System.out.println(string); }
 * 
 * 
 * 
 * Boolean flag=false; for(int i=0; i<ls1.length; i++){ for(int j=0;
 * j<ls2.length; j++){ if(ls1[i].equals(ls2[j])){ flag=true; } }
 * if(flag==false){ System.out.println("No se encontro : "+ ls1[i]); }
 * flag=false; }
 */
