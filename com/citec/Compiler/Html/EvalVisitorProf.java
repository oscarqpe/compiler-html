package com.citec.Compiler.Html;

import java.util.ArrayList;
import java.util.List;

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

public class EvalVisitorProf extends HTMLParserBaseVisitor<String> {

	List<String> listTag;
	List<String> listContenido;
	List<String> listTagContenido;
	List<EstiloEntity> listEstilos;
	int pageId;
	Boolean valSol;
	
	
	public EvalVisitorProf(int pageId,Boolean valSol) {
		// TODO Auto-generated constructor stub
		this.pageId = pageId;
		this.valSol = valSol;
		
		listTag = new ArrayList<String>();
		listContenido = new ArrayList<String>();
		listTagContenido = new ArrayList<String>();
		listEstilos = new ArrayList<EstiloEntity>();
	}
	
	public ValidationRules getValidationRules(){
		ValidationRules val=new ValidationRules();
		val.setListContenido(listContenido);
		val.setListEstilos(listEstilos);
		val.setListTag(listTag);
		val.setListTagContenido(listTagContenido);
		val.setPageId(pageId);
		val.setValSol(valSol);
		return val;
	}
	
	
	@Override
	public String visitHtmlTagScriptLet(HtmlTagScriptLetContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlTagScriptLet(ctx);
	}

	@Override
	public String visitHtmlTagOpenAttContSlashClose(
			HtmlTagOpenAttContSlashCloseContext ctx) {
		
		// TODO Auto-generated method stub
		if(!validateTags(ctx.htmlTagName().get(0).getText().toLowerCase()).equals("")){
			
			listTagContenido.add(ctx.htmlTagName().get(0).getText());
			listContenido.add(ctx.htmlContent().getText());
		
			//if(ctx.htmlAttribute())
			if(ctx.htmlAttribute().size()!=0){
				String s1=visit(ctx.htmlAttribute(0));				
				String [] ls1= s1.split("===");
				listEstilos.add(new EstiloEntity(ls1[0], ls1[1]));
				
				/*			System.out.println("TAG: "+ ctx.htmlTagName().get(0).getText()+" " +ctx.htmlContent().getText()+
					"List Atrib : " +ctx.htmlAttribute().get(0).getText());*/
			}
			else{
			//System.out.println("TAG: "+ ctx.htmlTagName().get(0).getText()+" " +ctx.htmlContent().getText());
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
		listTag.add(ctx.getText());
		//System.out.println("NOMBRE TAG = " + ctx.getText());
		return super.visitHtmlTagNameExpr(ctx);
	}

	@Override
	public String visitHtmlCharDataHtmlText(HtmlCharDataHtmlTextContext ctx) {
		// TODO Auto-generated method stub
		//System.out.println(ctx.);
		//System.out.println("CHAR DATA: " + ctx.getText());
		//listContenido.add(ctx.getText());
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
		return ctx.htmlAttributeName().getText()+"===" +ctx.htmlAttributeValue().getText();
//		System.out.println("ESTE : "+ ctx.getText() +" OTRO: "+ ctx.htmlAttributeName().getText() +" VALUE : " +ctx.htmlAttributeValue().getText() );
	//	return super.visitHtmlAttEquals(ctx);
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
		
		
	//	System.out.println("Contenido: "+ ctx.getText());
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
	
	public static String validateTags(String ruler){
		//System.out.println("ENTRO "+ ruler);
		if(ExpresionRules.map.containsKey(ruler)){
			//System.out.println("ENTRO REGLA"+ ruler);
			return ExpresionRules.map.get(ruler);
		}
		
		return "";
	}
	
}