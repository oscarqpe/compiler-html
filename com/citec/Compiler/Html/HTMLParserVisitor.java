// Generated from HTMLParser.g4 by ANTLR 4.0
package com.citec.Compiler.Html;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface HTMLParserVisitor<T> extends ParseTreeVisitor<T> {
	T visitHtmlTagScriptLet(HTMLParser.HtmlTagScriptLetContext ctx);

	T visitHtmlTagOpenAttContSlashClose(HTMLParser.HtmlTagOpenAttContSlashCloseContext ctx);

	T visitDtdExpr(HTMLParser.DtdExprContext ctx);

	T visitHtmlTagStyle(HTMLParser.HtmlTagStyleContext ctx);

	T visitHtmlAttValue(HTMLParser.HtmlAttValueContext ctx);

	T visitScriptOpen(HTMLParser.ScriptOpenContext ctx);

	T visitHtmlAttName(HTMLParser.HtmlAttNameContext ctx);

	T visitHtmlTagNameExpr(HTMLParser.HtmlTagNameExprContext ctx);

	T visitHtmlCharDataHtmlText(HTMLParser.HtmlCharDataHtmlTextContext ctx);

	T visitHtmlElementsExpr(HTMLParser.HtmlElementsExprContext ctx);

	T visitHtmlDocumentExpr(HTMLParser.HtmlDocumentExprContext ctx);

	T visitHtmlCharDataSeaWs(HTMLParser.HtmlCharDataSeaWsContext ctx);

	T visitScriptletExpr(HTMLParser.ScriptletExprContext ctx);

	T visitHtmlAttEquals(HTMLParser.HtmlAttEqualsContext ctx);

	T visitHtmlMiscSeaWs(HTMLParser.HtmlMiscSeaWsContext ctx);

	T visitHtmlTagScript(HTMLParser.HtmlTagScriptContext ctx);

	T visitHtmlCommentComment(HTMLParser.HtmlCommentCommentContext ctx);

	T visitHtmlTagOpenAttClose(HTMLParser.HtmlTagOpenAttCloseContext ctx);

	T visitXmlDeclaration(HTMLParser.XmlDeclarationContext ctx);

	T visitXhtmlCData(HTMLParser.XhtmlCDataContext ctx);

	T visitHtmlCommentCommentConditional(HTMLParser.HtmlCommentCommentConditionalContext ctx);

	T visitHtmlAtt(HTMLParser.HtmlAttContext ctx);

	T visitHtmlContentExpr(HTMLParser.HtmlContentExprContext ctx);

	T visitHtmlTagOpenAttSlash(HTMLParser.HtmlTagOpenAttSlashContext ctx);

	T visitStyleOpen(HTMLParser.StyleOpenContext ctx);

	T visitHtmlMiscComment(HTMLParser.HtmlMiscCommentContext ctx);
}