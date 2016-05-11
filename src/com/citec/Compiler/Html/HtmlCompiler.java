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
import java.util.List;
public class HtmlCompiler {

	/**
	 * @param args
	 */
	public List<CodeEntity> listSolucionesE;	
	public List<CodeEntity> listSolucionesLabE;
	public List<SolutionEntity> listTree;
	public List<SolutionEntity> listTreeLab;
	
	public static List<String> listExpreP1;
	public static List<String> listExpreContP1;
	public static List<String> listExpreTagP1;
	public static List<String> listExpreStyleP1;
	
	public HtmlCompiler(){
		listSolucionesE = new ArrayList<CodeEntity>();
		listSolucionesLabE = new ArrayList<CodeEntity>();
		listTree = new ArrayList<SolutionEntity>();
		listTreeLab = new ArrayList<SolutionEntity>();
		listExpreP1 = new ArrayList<String>();
		listExpreContP1 = new ArrayList<String>();
		listExpreTagP1 = new ArrayList<String>();
		listExpreStyleP1 = new ArrayList<String>();
	}

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		ErrorMessage.InitErrorMessage();
		ConnectionManager.GetConnection();
		
		
		HtmlCompiler obj = new HtmlCompiler();
		String fileSol = "/home/oscar/proyectos/citec/temp/solucionesProf.csv";
		String fileSolLab = "/home/oscar/proyectos/citec/temp/solucionesLab.csv";
		
		//Cargar data de soluciones y generar ParseTree
		
		obj.listSolucionesE=obj.loadData(fileSol);		
		obj.showData(obj.listSolucionesE);
		obj.runCompile();
		
		//Cargar data solucion Chicas y generar ParseTree;		
		System.out.println("CARGAR SOLUCIONES CHICAS");
		
		obj.listSolucionesLabE = obj.loadData(fileSolLab);				
		System.out.println("Carga de Codigos Laboratoria Terminada");
		//obj.showData(obj.listSolucionesLabE);		
		obj.runCompileLab();
		
		// calculamos las soluciones similares
		
		obj.evalSimilarity();
		
	/*	for (ErrorCompiler e : Exceptions.ListExceptions) {
			System.out.println("Error "+ e.id+" :"+ "Linea "+e.numLine+" "+e.message);
		}
		*/
			

	}
	
	public void evalSimilarity() throws SQLException{
		List<Solution> solutions = new ArrayList<Solution>();
		LevenshteinDistance ld = new LevenshteinDistance();
		for (SolutionEntity solucion : listTree) {
			for (SolutionEntity solucionLab : listTreeLab) {
				if(solucion.getEntity().getPageId()==solucionLab.getEntity().getPageId()){
					int val = ld.computeLevenshteinDistance(solucion.getTree().toStringTree(solucionLab.getParser()),
							solucionLab.getTree().toStringTree(solucionLab.getParser()));
					
					listExpreContP1.clear();
					listExpreP1.clear();
					listExpreTagP1.clear();

					if(solucionLab.getEntity().getPageId()==3){
						initExpresionesP1();
					}if(solucionLab.getEntity().getPageId()==6){
						initExpresionesP2();
					}if(solucionLab.getEntity().getPageId()==10){
						initExpresionesP3();
					}			
						
					Solution solution = new Solution();
					solution.setPage_id(solucion.getEntity().getPageId());
					solution.setUser_id(solucionLab.getEntity().getUserId());
					solution.setAnswer_id(solucionLab.getEntity().getAnswerId());
					solution.setSimilitud(val);
					
					List<Recommendation> recomendaciones = new ArrayList<Recommendation>();
					
					EvalVisitor eval = new EvalVisitor(solucionLab.getEntity(),solucion,solucion.getSolValVisitor());
					eval.visit(solucionLab.getTree());
					
					for (ErrorCompiler e : Exceptions.ListExceptions) {
						System.out.println("Error "+ e.id+" :"+ "Linea "+e.numLine+" "+e.message);
						Recommendation rec = new Recommendation();
						rec.setDescription("Error "+ e.id+" :"+ "Linea "+e.numLine+" "+e.message);
						recomendaciones.add(rec);
					}
					
					solution.setRecomedaciones(recomendaciones);
					Exceptions.ListExceptions.clear();
					//ConnectionManager.PruebaQuery(solucion.getEntity().getPageId(), solucionLab.getEntity().getUserId(), val);
					//System.out.println("Similitud para Pagina =  "+solucion.getEntity().getPageId() +
					//		" Para usuario = "+ solucionLab.getEntity().getUserId()+" distancia = " + val);
					solutions.add(solution);
				}
			}
		}
		
		ConnectionManager.PruebaQuery(solutions);
		

	}
	
	public void runCompileLab(){
		for (int i=0 ; i<listSolucionesLabE.size(); i++){        	
			CodeEntity entity = listSolucionesLabE.get(i);
			ANTLRInputStream input = new ANTLRInputStream(entity.getCode());
			HTMLLexer lexer = new HTMLLexer(input); 
			CommonTokenStream tokens = new CommonTokenStream(lexer); 
			HTMLParser parser = new HTMLParser(tokens); 
			ParseTree tree = parser.htmlDocument(); // parse; start at prog <label id="code.tour.main.6"/>
			listTreeLab.add(new SolutionEntity(tree, entity,parser,false));
		//	EvalVisitor eval = new EvalVisitor(entity);
		//	eval.visit(tree);	        
			//System.out.println(tree.toStringTree(parser)); // print tree as text <label id="code.tour.main.7"/>

		}
	}
	
	
	
	public void runCompileLabVisitor(){
		for (int i=0 ; i<listSolucionesLabE.size(); i++){
		//for (int i=0 ; i<735; i++){
			CodeEntity entity = listSolucionesLabE.get(i);
			ANTLRInputStream input = new ANTLRInputStream(entity.getCode());
			HTMLLexer lexer = new HTMLLexer(input); 
			CommonTokenStream tokens = new CommonTokenStream(lexer); 
			HTMLParser parser = new HTMLParser(tokens); 
			ParseTree tree = parser.htmlDocument(); // parse; start at prog <label id="code.tour.main.6"/>
			listTreeLab.add(new SolutionEntity(tree, entity,parser,false));
			listExpreContP1.clear();
			listExpreP1.clear();
			listExpreTagP1.clear();

			if(entity.getPageId()==3){
				initExpresionesP1();
			}if(entity.getPageId()==6){
				initExpresionesP2();
			}if(entity.getPageId()==10){
				initExpresionesP3();
			}			
			
			int pageId=entity.getPageId();
			SolutionEntity entitySol=findEntity(pageId);
			EvalVisitor eval = new EvalVisitor(entity,entitySol,entitySol.getSolValVisitor());
			eval.visit(tree);
			for (ErrorCompiler e : Exceptions.ListExceptions) {
				System.out.println("Error "+ e.id+" :"+ "Linea "+e.numLine+" "+e.message);
			}
			//System.out.println("TERMINE");	
			
			
		}
	}
	
	public SolutionEntity findEntity(int pageId){
		for(int i=0; i<listTree.size(); i++){
			if(pageId==listTree.get(i).getEntity().getPageId()){
				return listTree.get(i);
			}
		}
		return null;
	}
	
	
	public void showData(List<CodeEntity> l){
		for(int i=0; i<l.size(); i++){
			CodeEntity entity = l.get(i);
			System.out.println("ID Sol: "+entity.getAnswerId()+"Page id: "+entity.getPageId()+" Unit id: "+ entity.getUserId()+" code: "+entity.getCode());
		}

	}
	
	
	
	public void runCompile(){
		for (int i=0 ; i<listSolucionesE.size(); i++){        	
			CodeEntity entity = listSolucionesE.get(i);
			ANTLRInputStream input = new ANTLRInputStream(entity.getCode());
			HTMLLexer lexer = new HTMLLexer(input); 
			CommonTokenStream tokens = new CommonTokenStream(lexer); 
			HTMLParser parser = new HTMLParser(tokens); 
			ParseTree tree = parser.htmlDocument(); // parse; start at prog <label id="code.tour.main.6"/>
			if(entity.getPageId()==3 || entity.getPageId()==6 || entity.getPageId()==10){
			listTree.add(new SolutionEntity(tree, entity,parser,true));
			}
			else{
			listTree.add(new SolutionEntity(tree, entity,parser,false));	
			}
				        
			System.out.println(tree.toStringTree(parser)); // print tree as text <label id="code.tour.main.7"/>

		}
	}


	public void runTest(){

	}

	public List<CodeEntity> loadData(String file){		

		String csvFile = file;
		List<CodeEntity> listSol = new ArrayList<CodeEntity>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String codigo="";
		
		int pageIdTemp=0;
		int unitUserIdTemp=0;
		int answerIdTemp=0;

		int i=0;
		try {

			br = new BufferedReader(new FileReader(csvFile));
			
			while ((line = br.readLine()) != null) {
				
				String[] code = line.split(cvsSplitBy);
				//System.out.println("ENTREEE");
				if(code.length==3 || i==0){
					i=1;
				}else{
					
					if(code.length==4){
						//System.out.println("ENTREEE");
						int answerId = Integer.parseInt(code[0]);
						int pageId=Integer.parseInt(code[1]);
						int unitUserId=Integer.parseInt(code[2]);
						

						if(!(codigo=="")){
							String temp1=eraserChar(0, codigo);
							String temp2=eraserChar(temp1.length()-1, temp1);								
							String sTemp = temp2.replace("\"\"","\"");
							listSol.add(new CodeEntity(pageIdTemp,unitUserIdTemp,sTemp,answerIdTemp));							
							pageIdTemp = pageId;
							unitUserIdTemp = unitUserId;
				
						}
						
							pageIdTemp = pageId;
							unitUserIdTemp = unitUserId;
							answerIdTemp = answerId;
							codigo="";							
							codigo+=code[3];
						
					}else{
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

	public String eraserChar(int i, String s){
		String a =s.substring(0,i);
		String b =s.substring(i+1,s.length());
		return a+b;
	}
	
	public static void initExpresionesP1(){
		
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
		listExpreContP1.add("En Laboratoria aprendemos a crear páginas web para empezar una carrera en el sector digital");
		
		listExpreTagP1.add("h1");
		listExpreTagP1.add("p");

		ExpresionValidation.initListExpre(listExpreP1);
		ExpresionValidation.initListExpreContent(listExpreContP1);
		ExpresionValidation.initListExpreTag(listExpreTagP1);
	}
	
	public static void initExpresionesP2(){
		
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
		listExpreContP1.add("En Laboratoria aprendemos varios lenguajes para crear páginas web. A continuación presentamos una lista de los lenguajes que aprendemos.");
		
		listExpreTagP1.add("title");
		listExpreTagP1.add("h1");
		listExpreTagP1.add("p");
		
		

		
		ExpresionValidation.initListExpre(listExpreP1);
		ExpresionValidation.initListExpreContent(listExpreContP1);
		ExpresionValidation.initListExpreTag(listExpreTagP1);
	}
	
public static void initExpresionesP3(){
		
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
		listExpreContP1.add("En Laboratoria aprendemos varios lenguajes para crear páginas web. A continuación presentamos una lista de los lenguajes que aprendemos.");
		
		listExpreTagP1.add("title");
		listExpreTagP1.add("h1");
		listExpreTagP1.add("p");
		
		listExpreStyleP1.add("style=\"color:blue;font-size:22px;\"");
		
		ExpresionValidation.initListExpre(listExpreP1);
		ExpresionValidation.initListExpreContent(listExpreContP1);
		ExpresionValidation.initListExpreTag(listExpreTagP1);
		ExpresionValidation.initListExpreStyle(listExpreStyleP1);
	}
	
}
/*
public void runCompileLab(){
	//for (int i=0 ; i<listSolucionesLabE.size(); i++){
	for (int i=0 ; i<735; i++){
		CodeEntity entity = listSolucionesLabE.get(i);
		ANTLRInputStream input = new ANTLRInputStream(entity.getCode());
		HTMLLexer lexer = new HTMLLexer(input); 
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		HTMLParser parser = new HTMLParser(tokens); 
		ParseTree tree = parser.htmlDocument(); // parse; start at prog <label id="code.tour.main.6"/>
		listTreeLab.add(new SolutionEntity(tree, entity,parser));
		listExpreContP1.clear();
		listExpreP1.clear();
		listExpreTagP1.clear();

		if(entity.getPageId()==3){
			initExpresionesP1();
		}if(entity.getPageId()==6){
			initExpresionesP2();
		}if(entity.getPageId()==10){
			initExpresionesP3();
		}
		
		if(entity.getPageId()==3 || entity.getPageId()==6 || entity.getPageId()==10){
			if(entity.getUserId()==240){
				int pageId=entity.getPageId();
				SolutionEntity entitySol=findEntity(pageId);
				
				EvalVisitor eval = new EvalVisitor(entity,entitySol);
				eval.visit(tree);
				for (ErrorCompiler e : Exceptions.ListExceptions) {
					System.out.println("Error "+ e.id+" :"+ "Linea "+e.numLine+" "+e.message);
				}
				System.out.println("TERMINE");
				
				
				}
		}
		
		
		//System.out.println(tree.toStringTree(parser)); // print tree as text <label id="code.tour.main.7"/>

	}
}*/