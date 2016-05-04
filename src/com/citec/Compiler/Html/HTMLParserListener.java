// Generated from HTMLParser.g4 by ANTLR 4.0
package com.citec.Compiler.Html;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface HTMLParserListener extends ParseTreeListener {
	void enterHtmlAttributeValue(HTMLParser.HtmlAttributeValueContext ctx);
	void exitHtmlAttributeValue(HTMLParser.HtmlAttributeValueContext ctx);

	void enterXhtmlCDATA(HTMLParser.XhtmlCDATAContext ctx);
	void exitXhtmlCDATA(HTMLParser.XhtmlCDATAContext ctx);

	void enterHtmlDocument(HTMLParser.HtmlDocumentContext ctx);
	void exitHtmlDocument(HTMLParser.HtmlDocumentContext ctx);

	void enterHtmlTagName(HTMLParser.HtmlTagNameContext ctx);
	void exitHtmlTagName(HTMLParser.HtmlTagNameContext ctx);

	void enterHtmlMisc(HTMLParser.HtmlMiscContext ctx);
	void exitHtmlMisc(HTMLParser.HtmlMiscContext ctx);

	void enterXml(HTMLParser.XmlContext ctx);
	void exitXml(HTMLParser.XmlContext ctx);

	void enterScript(HTMLParser.ScriptContext ctx);
	void exitScript(HTMLParser.ScriptContext ctx);

	void enterScriptlet(HTMLParser.ScriptletContext ctx);
	void exitScriptlet(HTMLParser.ScriptletContext ctx);

	void enterHtmlContent(HTMLParser.HtmlContentContext ctx);
	void exitHtmlContent(HTMLParser.HtmlContentContext ctx);

	void enterHtmlAttributeName(HTMLParser.HtmlAttributeNameContext ctx);
	void exitHtmlAttributeName(HTMLParser.HtmlAttributeNameContext ctx);

	void enterHtmlElements(HTMLParser.HtmlElementsContext ctx);
	void exitHtmlElements(HTMLParser.HtmlElementsContext ctx);

	void enterHtmlElement(HTMLParser.HtmlElementContext ctx);
	void exitHtmlElement(HTMLParser.HtmlElementContext ctx);

	void enterHtmlAttribute(HTMLParser.HtmlAttributeContext ctx);
	void exitHtmlAttribute(HTMLParser.HtmlAttributeContext ctx);

	void enterHtmlComment(HTMLParser.HtmlCommentContext ctx);
	void exitHtmlComment(HTMLParser.HtmlCommentContext ctx);

	void enterStyle(HTMLParser.StyleContext ctx);
	void exitStyle(HTMLParser.StyleContext ctx);

	void enterHtmlChardata(HTMLParser.HtmlChardataContext ctx);
	void exitHtmlChardata(HTMLParser.HtmlChardataContext ctx);

	void enterDtd(HTMLParser.DtdContext ctx);
	void exitDtd(HTMLParser.DtdContext ctx);
}