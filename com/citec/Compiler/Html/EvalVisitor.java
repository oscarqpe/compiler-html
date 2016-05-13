package com.citec.Compiler.Html;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.EarlyExitException;
import org.antlr.v4.runtime.tree.ParseTree;

import com.citec.Compiler.Html.HTMLParser.DtdExprContext;
import com.citec.Compiler.Html.HTMLParser.HtmlAttContext;
import com.citec.Compiler.Html.HTMLParser.HtmlAttEqualsContext;
import com.citec.Compiler.Html.HTMLParser.HtmlAttNameContext;
import com.citec.Compiler.Html.HTMLParser.HtmlAttValueContext;
import com.citec.Compiler.Html.HTMLParser.HtmlCharDataHtmlTextContext;
import com.citec.Compiler.Html.HTMLParser.HtmlCharDataSeaWsContext;
import com.citec.Compiler.Html.HTMLParser.HtmlCommentCommentConditionalContext;
import com.citec.Compiler.Html.HTMLParser.HtmlCommentCommentContext;
import com.citec.Compiler.Html.HTMLParser.HtmlContentExprContext;
import com.citec.Compiler.Html.HTMLParser.HtmlDocumentExprContext;
import com.citec.Compiler.Html.HTMLParser.HtmlElementsExprContext;
import com.citec.Compiler.Html.HTMLParser.HtmlMiscCommentContext;
import com.citec.Compiler.Html.HTMLParser.HtmlMiscSeaWsContext;
import com.citec.Compiler.Html.HTMLParser.HtmlTagNameExprContext;
import com.citec.Compiler.Html.HTMLParser.HtmlTagOpenAttCloseContext;
import com.citec.Compiler.Html.HTMLParser.HtmlTagOpenAttContSlashCloseContext;
import com.citec.Compiler.Html.HTMLParser.HtmlTagOpenAttSlashContext;
import com.citec.Compiler.Html.HTMLParser.HtmlTagScriptContext;
import com.citec.Compiler.Html.HTMLParser.HtmlTagScriptLetContext;
import com.citec.Compiler.Html.HTMLParser.HtmlTagStyleContext;
import com.citec.Compiler.Html.HTMLParser.ScriptOpenContext;
import com.citec.Compiler.Html.HTMLParser.ScriptletExprContext;
import com.citec.Compiler.Html.HTMLParser.StyleOpenContext;
import com.citec.Compiler.Html.HTMLParser.XhtmlCDataContext;
import com.citec.Compiler.Html.HTMLParser.XmlDeclarationContext;

public class EvalVisitor extends HTMLParserBaseVisitor<String> {
	CodeEntity entity;
	SolutionEntity entitySol;
	
	static int a;
	static int i_global;
	static int i_global_tag;
	static int i_global_style;
	static int EVALUAR_TAGS;
	static int EVALUAR_CONTENIDO;
	static int EVALUAR_STYLE;
	static Boolean EVALUAR;
	
	
	List<String> listExpre= new ArrayList<String>();
	

	public EvalVisitor(CodeEntity entity){
		this.entity = entity;
	}
	
	public EvalVisitor(CodeEntity entity, SolutionEntity entitySol, Boolean evaluar){
		this.entity = entity;
		this.entitySol= entitySol;
		
		a=0;
		i_global=0;
		i_global_tag=0;
		i_global_style=0;
		EVALUAR_TAGS=0;
		EVALUAR_CONTENIDO =0;
		EVALUAR_STYLE =0;
		EVALUAR = evaluar;	
	}
	
	
	@Override
	public String visitHtmlTagScriptLet(HtmlTagScriptLetContext ctx) {
		// TODO Auto-generated method stub
		//visit(ctx.)
		//System.out.println("Test : "+ ctx.);
		return super.visitHtmlTagScriptLet(ctx);
	}

	@Override
	public String visitHtmlTagOpenAttContSlashClose(
			HtmlTagOpenAttContSlashCloseContext ctx) {
		// TODO Auto-generated method stub
		if(EVALUAR==false)return super.visitHtmlTagOpenAttContSlashClose(ctx);
		
		if(entity.getPageId()==entitySol.getEntity().getPageId()){
			
			if(EVALUAR_CONTENIDO==0){
				String tag=ExpresionValidation.listExpreValTag.get(i_global_tag);				
				if(ctx.htmlTagName(0).getText().toLowerCase().equals(tag.toLowerCase())){				
				//	System.out.println("Etiqueta evaluar: " +ctx.htmlTagName(0).getText());
					String s1=removeCharSpecial(ctx.htmlContent().getText()).toLowerCase();
					String s2=removeCharSpecial(ExpresionValidation.listExpreValContent.get(i_global_tag)).toLowerCase();
					
					String s1f = quitaEspacios(s1);
					String s2f = quitaEspacios(s2);
					//System.out.println("S1: "+s1);
					//System.out.println("S2: "+s2);
					if(s2f.equals(s1f)){
						i_global_tag++;						
						if(ExpresionValidation.listExpreValTag.size()==i_global_tag)EVALUAR_CONTENIDO=1;
					}else{
						Exceptions.addError(ctx.htmlContent().start.getLine(),ctx.htmlContent().start.getCharPositionInLine() ,
								ErrorMessage.ERROR.VAL_DIF.ordinal(), s1);
						Exceptions.addRecommendation(1, 1, 4);
					}						
				}
				if(ctx.htmlTagName(0).getText().toLowerCase().equals("script")){
					System.out.println(ctx.htmlContent().getText());
				}
			}
			
			if(EVALUAR_STYLE==0){
				if(!(ctx.htmlAttribute().size()==0)){
					String ss1=ctx.htmlAttribute().get(0).getText().toLowerCase();
					String s1=quitaEspacios(ss1).replaceAll(" ", "");
					Boolean flagEntro=false;				
					List<String> styles=ExpresionValidation.listExpreValStyle.get(i_global_style);
					for (String ss : styles) {
						
						String ss2=quitaEspacios(ss.toLowerCase());
						String s2=ss2.replaceAll(" ", "");
						if(s1.equals(s2)){
							i_global_style++;
							flagEntro=true;
							if(ExpresionValidation.listExpreValStyle.size()==i_global_style)EVALUAR_STYLE=1;
						}
					}
					if(flagEntro==false){
						Exceptions.addError(ctx.htmlAttribute().get(0).getStart().getLine(),
								ctx.htmlAttribute().get(0).getStart().getCharPositionInLine(), 
								ErrorMessage.ERROR.NO_STYLE.ordinal(),ss1);
						Exceptions.addRecommendation(1, 1,6);
						Exceptions.addRecommendation(1, 2,1);
					}
					
				}
			}
			
		}
		return super.visitHtmlTagOpenAttContSlashClose(ctx);
	}

	@Override
	public String visitDtdExpr(DtdExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDtdExpr(ctx);
	}

	@Override
	public String visitHtmlTagStyle(HtmlTagStyleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlTagStyle(ctx);
	}

	@Override
	public String visitHtmlAttValue(HtmlAttValueContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlAttValue(ctx);
	}

	@Override
	public String visitScriptOpen(ScriptOpenContext ctx) {
		// TODO Auto-generated method stub
		return super.visitScriptOpen(ctx);
	}

	@Override
	public String visitHtmlAttName(HtmlAttNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlAttName(ctx);
	}

	@Override
	public String visitHtmlTagNameExpr(HtmlTagNameExprContext ctx) {
		// TODO Auto-generated method stub
		if(EVALUAR==false)return super.visitHtmlTagNameExpr(ctx);
		if(entity.getPageId()==entitySol.getEntity().getPageId()){
			if(EVALUAR_TAGS==0){
				
				if(ctx.getText().toLowerCase().equals(ExpresionValidation.listExpreVal.get(i_global))){
	//				System.out.println("Correcto lab: "+ctx.getText()+ " expresion sol: "+ExpresionValidation.listExpreVal.get(i_global));
					i_global++;
					if(ExpresionValidation.listExpreVal.size()==i_global)EVALUAR_TAGS=1;				
					
				}else{
		//			System.out.println("error lab: "+ctx.getText()+ " expresion sol: "+ExpresionValidation.listExpreVal.get(i_global));
					Exceptions.addError(ctx.start.getLine(),ctx.start.getCharPositionInLine() ,
							ErrorMessage.ERROR.NO_TAGS.ordinal(), ctx.getText());
					
					Exceptions.addRecommendation(1, 1, 4);
					Exceptions.addRecommendation(1, 1, 7);
					i_global++;
					if(ExpresionValidation.listExpreVal.size()==i_global)EVALUAR_TAGS=1;
				}							
			}
		//System.out.println("Tag Name Expr:  "+ctx.getText());
		
		}		
		
		return super.visitHtmlTagNameExpr(ctx);
	}

	@Override
	public String visitHtmlCharDataHtmlText(HtmlCharDataHtmlTextContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlCharDataHtmlText(ctx);
	}

	@Override
	public String visitHtmlElementsExpr(HtmlElementsExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlElementsExpr(ctx);
	}

	@Override
	public String visitHtmlDocumentExpr(HtmlDocumentExprContext ctx) {
		// TODO Auto-generated method stub
		
		
		//System.out.println("VER: "+ctx.getText());
		
		
		
		return super.visitHtmlDocumentExpr(ctx);
	}

	@Override
	public String visitHtmlCharDataSeaWs(HtmlCharDataSeaWsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlCharDataSeaWs(ctx);
	}

	@Override
	public String visitScriptletExpr(ScriptletExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitScriptletExpr(ctx);
	}

	@Override
	public String visitHtmlAttEquals(HtmlAttEqualsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlAttEquals(ctx);
	}

	@Override
	public String visitHtmlMiscSeaWs(HtmlMiscSeaWsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlMiscSeaWs(ctx);
	}

	@Override
	public String visitHtmlTagScript(HtmlTagScriptContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlTagScript(ctx);
	}

	@Override
	public String visitHtmlCommentComment(HtmlCommentCommentContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlCommentComment(ctx);
	}

	@Override
	public String visitHtmlTagOpenAttClose(HtmlTagOpenAttCloseContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlTagOpenAttClose(ctx);
	}

	@Override
	public String visitXmlDeclaration(XmlDeclarationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitXmlDeclaration(ctx);
	}

	@Override
	public String visitXhtmlCData(XhtmlCDataContext ctx) {
		// TODO Auto-generated method stub
		return super.visitXhtmlCData(ctx);
	}

	@Override
	public String visitHtmlCommentCommentConditional(
			HtmlCommentCommentConditionalContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlCommentCommentConditional(ctx);
	}

	@Override
	public String visitHtmlAtt(HtmlAttContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlAtt(ctx);
	}

	@Override
	public String visitHtmlContentExpr(HtmlContentExprContext ctx) {
		// TODO Auto-generated method stub
		if(entity.getPageId()==entitySol.getEntity().getPageId()){
			/*if(EVALUAR_CONTENIDO==0){
				if(true){
					
				}else{
					
				}
				
			}
			
			
			System.out.println("Contenido Tag :" +ctx.getText().toString());
			if(a==3){
				System.out.println("ENTRE y NO SE QUE HACER 333333  "+ctx.getText().toString());
				
				
				//ctx.html
				a--;
			}else
			if(a==2){
				System.out.println("ENTRE y NO SE QUE HACER 2222222  "+ctx.getText().toString());
				a--;
			}else if(a==1){
				System.out.println("ENTRE y NO SE QUE HACER 1111111  "+ctx.getText().toString());
				a--;
			}
			*/
		}
		//return ctx.getText();
		return super.visitHtmlContentExpr(ctx);
	}

	@Override
	public String visitHtmlTagOpenAttSlash(HtmlTagOpenAttSlashContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlTagOpenAttSlash(ctx);
	}

	@Override
	public String visitStyleOpen(StyleOpenContext ctx) {
		// TODO Auto-generated method stub
		return super.visitStyleOpen(ctx);
	}

	@Override
	public String visitHtmlMiscComment(HtmlMiscCommentContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlMiscComment(ctx);
	}
	
	public static String removeCharSpecial(String input) {
	    
	    String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";	    
	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    String output = input;
	    for (int i=0; i<original.length(); i++) {	     
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }
	    return output;
	}
	
	  public static String quitaEspacios(String texto) {
	        java.util.StringTokenizer tokens = new java.util.StringTokenizer(texto);
	        StringBuilder buff = new StringBuilder();
	        while (tokens.hasMoreTokens()) {
	            buff.append(" ").append(tokens.nextToken());
	        }
	        return buff.toString().trim();
	    }

}