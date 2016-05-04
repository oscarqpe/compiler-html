// Generated from HTMLParser.g4 by ANTLR 4.0
package com.citec.Compiler.Html;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HTMLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TAG_WHITESPACE=17, TAG_NAME=16, STYLE_BODY=20, CDATA=4, SEA_WS=7, TAG_CLOSE=12, 
		SCRIPT_BODY=18, TAG_SLASH=14, STYLE_OPEN=9, DTD=5, STYLE_SHORT_BODY=21, 
		TAG_EQUALS=15, ATTRIBUTE=23, TAG_SLASH_CLOSE=13, HTML_COMMENT=1, HTML_TEXT=11, 
		SCRIPT_OPEN=8, HTML_CONDITIONAL_COMMENT=2, SCRIPTLET=6, ATTVALUE_VALUE=22, 
		SCRIPT_SHORT_BODY=19, XML_DECLARATION=3, TAG_OPEN=10;
	public static final String[] tokenNames = {
		"<INVALID>", "HTML_COMMENT", "HTML_CONDITIONAL_COMMENT", "XML_DECLARATION", 
		"CDATA", "DTD", "SCRIPTLET", "SEA_WS", "SCRIPT_OPEN", "STYLE_OPEN", "'<'", 
		"HTML_TEXT", "'>'", "'/>'", "'/'", "'='", "TAG_NAME", "TAG_WHITESPACE", 
		"SCRIPT_BODY", "SCRIPT_SHORT_BODY", "STYLE_BODY", "STYLE_SHORT_BODY", 
		"ATTVALUE_VALUE", "ATTRIBUTE"
	};
	public static final int
		RULE_htmlDocument = 0, RULE_htmlElements = 1, RULE_htmlElement = 2, RULE_htmlContent = 3, 
		RULE_htmlAttribute = 4, RULE_htmlAttributeName = 5, RULE_htmlAttributeValue = 6, 
		RULE_htmlTagName = 7, RULE_htmlChardata = 8, RULE_htmlMisc = 9, RULE_htmlComment = 10, 
		RULE_xhtmlCDATA = 11, RULE_dtd = 12, RULE_xml = 13, RULE_scriptlet = 14, 
		RULE_script = 15, RULE_style = 16;
	public static final String[] ruleNames = {
		"htmlDocument", "htmlElements", "htmlElement", "htmlContent", "htmlAttribute", 
		"htmlAttributeName", "htmlAttributeValue", "htmlTagName", "htmlChardata", 
		"htmlMisc", "htmlComment", "xhtmlCDATA", "dtd", "xml", "scriptlet", "script", 
		"style"
	};

	@Override
	public String getGrammarFileName() { return "HTMLParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public HTMLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class HtmlDocumentContext extends ParserRuleContext {
		public HtmlDocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlDocument; }
	 
		public HtmlDocumentContext() { }
		public void copyFrom(HtmlDocumentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HtmlDocumentExprContext extends HtmlDocumentContext {
		public List<HtmlElementsContext> htmlElements() {
			return getRuleContexts(HtmlElementsContext.class);
		}
		public List<TerminalNode> SEA_WS() { return getTokens(HTMLParser.SEA_WS); }
		public HtmlElementsContext htmlElements(int i) {
			return getRuleContext(HtmlElementsContext.class,i);
		}
		public TerminalNode SEA_WS(int i) {
			return getToken(HTMLParser.SEA_WS, i);
		}
		public ScriptletContext scriptlet(int i) {
			return getRuleContext(ScriptletContext.class,i);
		}
		public XmlContext xml() {
			return getRuleContext(XmlContext.class,0);
		}
		public DtdContext dtd() {
			return getRuleContext(DtdContext.class,0);
		}
		public List<ScriptletContext> scriptlet() {
			return getRuleContexts(ScriptletContext.class);
		}
		public HtmlDocumentExprContext(HtmlDocumentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlDocumentExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlDocumentContext htmlDocument() throws RecognitionException {
		HtmlDocumentContext _localctx = new HtmlDocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_htmlDocument);
		int _la;
		try {
			int _alt;
			_localctx = new HtmlDocumentExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(36);
					switch (_input.LA(1)) {
					case SCRIPTLET:
						{
						setState(34); scriptlet();
						}
						break;
					case SEA_WS:
						{
						setState(35); match(SEA_WS);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(42);
			_la = _input.LA(1);
			if (_la==XML_DECLARATION) {
				{
				setState(41); xml();
				}
			}

			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(46);
					switch (_input.LA(1)) {
					case SCRIPTLET:
						{
						setState(44); scriptlet();
						}
						break;
					case SEA_WS:
						{
						setState(45); match(SEA_WS);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(52);
			_la = _input.LA(1);
			if (_la==DTD) {
				{
				setState(51); dtd();
				}
			}

			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(56);
					switch (_input.LA(1)) {
					case SCRIPTLET:
						{
						setState(54); scriptlet();
						}
						break;
					case SEA_WS:
						{
						setState(55); match(SEA_WS);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HTML_COMMENT) | (1L << HTML_CONDITIONAL_COMMENT) | (1L << SCRIPTLET) | (1L << SEA_WS) | (1L << SCRIPT_OPEN) | (1L << STYLE_OPEN) | (1L << TAG_OPEN))) != 0)) {
				{
				{
				setState(61); htmlElements();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlElementsContext extends ParserRuleContext {
		public HtmlElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElements; }
	 
		public HtmlElementsContext() { }
		public void copyFrom(HtmlElementsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HtmlElementsExprContext extends HtmlElementsContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public HtmlMiscContext htmlMisc(int i) {
			return getRuleContext(HtmlMiscContext.class,i);
		}
		public List<HtmlMiscContext> htmlMisc() {
			return getRuleContexts(HtmlMiscContext.class);
		}
		public HtmlElementsExprContext(HtmlElementsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlElementsExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementsContext htmlElements() throws RecognitionException {
		HtmlElementsContext _localctx = new HtmlElementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_htmlElements);
		int _la;
		try {
			int _alt;
			_localctx = new HtmlElementsExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HTML_COMMENT) | (1L << HTML_CONDITIONAL_COMMENT) | (1L << SEA_WS))) != 0)) {
				{
				{
				setState(67); htmlMisc();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73); htmlElement();
			setState(77);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(74); htmlMisc();
					}
					} 
				}
				setState(79);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlElementContext extends ParserRuleContext {
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
	 
		public HtmlElementContext() { }
		public void copyFrom(HtmlElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HtmlTagOpenAttContSlashCloseContext extends HtmlElementContext {
		public HtmlAttributeContext htmlAttribute(int i) {
			return getRuleContext(HtmlAttributeContext.class,i);
		}
		public List<HtmlAttributeContext> htmlAttribute() {
			return getRuleContexts(HtmlAttributeContext.class);
		}
		public List<TerminalNode> TAG_CLOSE() { return getTokens(HTMLParser.TAG_CLOSE); }
		public TerminalNode TAG_CLOSE(int i) {
			return getToken(HTMLParser.TAG_CLOSE, i);
		}
		public List<HtmlTagNameContext> htmlTagName() {
			return getRuleContexts(HtmlTagNameContext.class);
		}
		public TerminalNode TAG_OPEN(int i) {
			return getToken(HTMLParser.TAG_OPEN, i);
		}
		public TerminalNode TAG_SLASH() { return getToken(HTMLParser.TAG_SLASH, 0); }
		public HtmlTagNameContext htmlTagName(int i) {
			return getRuleContext(HtmlTagNameContext.class,i);
		}
		public HtmlContentContext htmlContent() {
			return getRuleContext(HtmlContentContext.class,0);
		}
		public List<TerminalNode> TAG_OPEN() { return getTokens(HTMLParser.TAG_OPEN); }
		public HtmlTagOpenAttContSlashCloseContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlTagOpenAttContSlashClose(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HtmlTagScriptLetContext extends HtmlElementContext {
		public ScriptletContext scriptlet() {
			return getRuleContext(ScriptletContext.class,0);
		}
		public HtmlTagScriptLetContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlTagScriptLet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HtmlTagStyleContext extends HtmlElementContext {
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public HtmlTagStyleContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlTagStyle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HtmlTagOpenAttSlashContext extends HtmlElementContext {
		public HtmlAttributeContext htmlAttribute(int i) {
			return getRuleContext(HtmlAttributeContext.class,i);
		}
		public List<HtmlAttributeContext> htmlAttribute() {
			return getRuleContexts(HtmlAttributeContext.class);
		}
		public TerminalNode TAG_SLASH_CLOSE() { return getToken(HTMLParser.TAG_SLASH_CLOSE, 0); }
		public HtmlTagNameContext htmlTagName() {
			return getRuleContext(HtmlTagNameContext.class,0);
		}
		public TerminalNode TAG_OPEN() { return getToken(HTMLParser.TAG_OPEN, 0); }
		public HtmlTagOpenAttSlashContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlTagOpenAttSlash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HtmlTagScriptContext extends HtmlElementContext {
		public ScriptContext script() {
			return getRuleContext(ScriptContext.class,0);
		}
		public HtmlTagScriptContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlTagScript(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HtmlTagOpenAttCloseContext extends HtmlElementContext {
		public HtmlAttributeContext htmlAttribute(int i) {
			return getRuleContext(HtmlAttributeContext.class,i);
		}
		public List<HtmlAttributeContext> htmlAttribute() {
			return getRuleContexts(HtmlAttributeContext.class);
		}
		public TerminalNode TAG_CLOSE() { return getToken(HTMLParser.TAG_CLOSE, 0); }
		public HtmlTagNameContext htmlTagName() {
			return getRuleContext(HtmlTagNameContext.class,0);
		}
		public TerminalNode TAG_OPEN() { return getToken(HTMLParser.TAG_OPEN, 0); }
		public HtmlTagOpenAttCloseContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlTagOpenAttClose(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_htmlElement);
		int _la;
		try {
			setState(118);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new HtmlTagOpenAttContSlashCloseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(80); match(TAG_OPEN);
				setState(81); htmlTagName();
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_NAME) {
					{
					{
					setState(82); htmlAttribute();
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(88); match(TAG_CLOSE);
				setState(89); htmlContent();
				setState(90); match(TAG_OPEN);
				setState(91); match(TAG_SLASH);
				setState(92); htmlTagName();
				setState(93); match(TAG_CLOSE);
				}
				break;

			case 2:
				_localctx = new HtmlTagOpenAttSlashContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(95); match(TAG_OPEN);
				setState(96); htmlTagName();
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_NAME) {
					{
					{
					setState(97); htmlAttribute();
					}
					}
					setState(102);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(103); match(TAG_SLASH_CLOSE);
				}
				break;

			case 3:
				_localctx = new HtmlTagOpenAttCloseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(105); match(TAG_OPEN);
				setState(106); htmlTagName();
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_NAME) {
					{
					{
					setState(107); htmlAttribute();
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(113); match(TAG_CLOSE);
				}
				break;

			case 4:
				_localctx = new HtmlTagScriptLetContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(115); scriptlet();
				}
				break;

			case 5:
				_localctx = new HtmlTagScriptContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(116); script();
				}
				break;

			case 6:
				_localctx = new HtmlTagStyleContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(117); style();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlContentContext extends ParserRuleContext {
		public HtmlContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlContent; }
	 
		public HtmlContentContext() { }
		public void copyFrom(HtmlContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HtmlContentExprContext extends HtmlContentContext {
		public List<HtmlElementContext> htmlElement() {
			return getRuleContexts(HtmlElementContext.class);
		}
		public List<HtmlCommentContext> htmlComment() {
			return getRuleContexts(HtmlCommentContext.class);
		}
		public List<XhtmlCDATAContext> xhtmlCDATA() {
			return getRuleContexts(XhtmlCDATAContext.class);
		}
		public List<HtmlChardataContext> htmlChardata() {
			return getRuleContexts(HtmlChardataContext.class);
		}
		public HtmlElementContext htmlElement(int i) {
			return getRuleContext(HtmlElementContext.class,i);
		}
		public HtmlCommentContext htmlComment(int i) {
			return getRuleContext(HtmlCommentContext.class,i);
		}
		public HtmlChardataContext htmlChardata(int i) {
			return getRuleContext(HtmlChardataContext.class,i);
		}
		public XhtmlCDATAContext xhtmlCDATA(int i) {
			return getRuleContext(XhtmlCDATAContext.class,i);
		}
		public HtmlContentExprContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlContentExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlContentContext htmlContent() throws RecognitionException {
		HtmlContentContext _localctx = new HtmlContentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_htmlContent);
		int _la;
		try {
			int _alt;
			_localctx = new HtmlContentExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if (_la==SEA_WS || _la==HTML_TEXT) {
				{
				setState(120); htmlChardata();
				}
			}

			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(126);
					switch (_input.LA(1)) {
					case SCRIPTLET:
					case SCRIPT_OPEN:
					case STYLE_OPEN:
					case TAG_OPEN:
						{
						setState(123); htmlElement();
						}
						break;
					case CDATA:
						{
						setState(124); xhtmlCDATA();
						}
						break;
					case HTML_COMMENT:
					case HTML_CONDITIONAL_COMMENT:
						{
						setState(125); htmlComment();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(129);
					_la = _input.LA(1);
					if (_la==SEA_WS || _la==HTML_TEXT) {
						{
						setState(128); htmlChardata();
						}
					}

					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlAttributeContext extends ParserRuleContext {
		public HtmlAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlAttribute; }
	 
		public HtmlAttributeContext() { }
		public void copyFrom(HtmlAttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HtmlAttContext extends HtmlAttributeContext {
		public HtmlAttributeNameContext htmlAttributeName() {
			return getRuleContext(HtmlAttributeNameContext.class,0);
		}
		public HtmlAttContext(HtmlAttributeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlAtt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HtmlAttEqualsContext extends HtmlAttributeContext {
		public HtmlAttributeValueContext htmlAttributeValue() {
			return getRuleContext(HtmlAttributeValueContext.class,0);
		}
		public TerminalNode TAG_EQUALS() { return getToken(HTMLParser.TAG_EQUALS, 0); }
		public HtmlAttributeNameContext htmlAttributeName() {
			return getRuleContext(HtmlAttributeNameContext.class,0);
		}
		public HtmlAttEqualsContext(HtmlAttributeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlAttEquals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlAttributeContext htmlAttribute() throws RecognitionException {
		HtmlAttributeContext _localctx = new HtmlAttributeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_htmlAttribute);
		try {
			setState(141);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new HtmlAttEqualsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(136); htmlAttributeName();
				setState(137); match(TAG_EQUALS);
				setState(138); htmlAttributeValue();
				}
				break;

			case 2:
				_localctx = new HtmlAttContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(140); htmlAttributeName();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlAttributeNameContext extends ParserRuleContext {
		public HtmlAttributeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlAttributeName; }
	 
		public HtmlAttributeNameContext() { }
		public void copyFrom(HtmlAttributeNameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HtmlAttNameContext extends HtmlAttributeNameContext {
		public TerminalNode TAG_NAME() { return getToken(HTMLParser.TAG_NAME, 0); }
		public HtmlAttNameContext(HtmlAttributeNameContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlAttName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlAttributeNameContext htmlAttributeName() throws RecognitionException {
		HtmlAttributeNameContext _localctx = new HtmlAttributeNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_htmlAttributeName);
		try {
			_localctx = new HtmlAttNameContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(143); match(TAG_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlAttributeValueContext extends ParserRuleContext {
		public HtmlAttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlAttributeValue; }
	 
		public HtmlAttributeValueContext() { }
		public void copyFrom(HtmlAttributeValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HtmlAttValueContext extends HtmlAttributeValueContext {
		public TerminalNode ATTVALUE_VALUE() { return getToken(HTMLParser.ATTVALUE_VALUE, 0); }
		public HtmlAttValueContext(HtmlAttributeValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlAttValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlAttributeValueContext htmlAttributeValue() throws RecognitionException {
		HtmlAttributeValueContext _localctx = new HtmlAttributeValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_htmlAttributeValue);
		try {
			_localctx = new HtmlAttValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(145); match(ATTVALUE_VALUE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlTagNameContext extends ParserRuleContext {
		public HtmlTagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlTagName; }
	 
		public HtmlTagNameContext() { }
		public void copyFrom(HtmlTagNameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HtmlTagNameExprContext extends HtmlTagNameContext {
		public TerminalNode TAG_NAME() { return getToken(HTMLParser.TAG_NAME, 0); }
		public HtmlTagNameExprContext(HtmlTagNameContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlTagNameExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlTagNameContext htmlTagName() throws RecognitionException {
		HtmlTagNameContext _localctx = new HtmlTagNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_htmlTagName);
		try {
			_localctx = new HtmlTagNameExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(147); match(TAG_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlChardataContext extends ParserRuleContext {
		public HtmlChardataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlChardata; }
	 
		public HtmlChardataContext() { }
		public void copyFrom(HtmlChardataContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HtmlCharDataSeaWsContext extends HtmlChardataContext {
		public TerminalNode SEA_WS() { return getToken(HTMLParser.SEA_WS, 0); }
		public HtmlCharDataSeaWsContext(HtmlChardataContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlCharDataSeaWs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HtmlCharDataHtmlTextContext extends HtmlChardataContext {
		public TerminalNode HTML_TEXT() { return getToken(HTMLParser.HTML_TEXT, 0); }
		public HtmlCharDataHtmlTextContext(HtmlChardataContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlCharDataHtmlText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlChardataContext htmlChardata() throws RecognitionException {
		HtmlChardataContext _localctx = new HtmlChardataContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_htmlChardata);
		try {
			setState(151);
			switch (_input.LA(1)) {
			case HTML_TEXT:
				_localctx = new HtmlCharDataHtmlTextContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(149); match(HTML_TEXT);
				}
				break;
			case SEA_WS:
				_localctx = new HtmlCharDataSeaWsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(150); match(SEA_WS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlMiscContext extends ParserRuleContext {
		public HtmlMiscContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlMisc; }
	 
		public HtmlMiscContext() { }
		public void copyFrom(HtmlMiscContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HtmlMiscSeaWsContext extends HtmlMiscContext {
		public TerminalNode SEA_WS() { return getToken(HTMLParser.SEA_WS, 0); }
		public HtmlMiscSeaWsContext(HtmlMiscContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlMiscSeaWs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HtmlMiscCommentContext extends HtmlMiscContext {
		public HtmlCommentContext htmlComment() {
			return getRuleContext(HtmlCommentContext.class,0);
		}
		public HtmlMiscCommentContext(HtmlMiscContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlMiscComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlMiscContext htmlMisc() throws RecognitionException {
		HtmlMiscContext _localctx = new HtmlMiscContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_htmlMisc);
		try {
			setState(155);
			switch (_input.LA(1)) {
			case HTML_COMMENT:
			case HTML_CONDITIONAL_COMMENT:
				_localctx = new HtmlMiscCommentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(153); htmlComment();
				}
				break;
			case SEA_WS:
				_localctx = new HtmlMiscSeaWsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(154); match(SEA_WS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlCommentContext extends ParserRuleContext {
		public HtmlCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlComment; }
	 
		public HtmlCommentContext() { }
		public void copyFrom(HtmlCommentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HtmlCommentCommentConditionalContext extends HtmlCommentContext {
		public TerminalNode HTML_CONDITIONAL_COMMENT() { return getToken(HTMLParser.HTML_CONDITIONAL_COMMENT, 0); }
		public HtmlCommentCommentConditionalContext(HtmlCommentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlCommentCommentConditional(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HtmlCommentCommentContext extends HtmlCommentContext {
		public TerminalNode HTML_COMMENT() { return getToken(HTMLParser.HTML_COMMENT, 0); }
		public HtmlCommentCommentContext(HtmlCommentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtmlCommentComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlCommentContext htmlComment() throws RecognitionException {
		HtmlCommentContext _localctx = new HtmlCommentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_htmlComment);
		try {
			setState(159);
			switch (_input.LA(1)) {
			case HTML_COMMENT:
				_localctx = new HtmlCommentCommentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(157); match(HTML_COMMENT);
				}
				break;
			case HTML_CONDITIONAL_COMMENT:
				_localctx = new HtmlCommentCommentConditionalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(158); match(HTML_CONDITIONAL_COMMENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XhtmlCDATAContext extends ParserRuleContext {
		public XhtmlCDATAContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xhtmlCDATA; }
	 
		public XhtmlCDATAContext() { }
		public void copyFrom(XhtmlCDATAContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class XhtmlCDataContext extends XhtmlCDATAContext {
		public TerminalNode CDATA() { return getToken(HTMLParser.CDATA, 0); }
		public XhtmlCDataContext(XhtmlCDATAContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitXhtmlCData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XhtmlCDATAContext xhtmlCDATA() throws RecognitionException {
		XhtmlCDATAContext _localctx = new XhtmlCDATAContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_xhtmlCDATA);
		try {
			_localctx = new XhtmlCDataContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(161); match(CDATA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DtdContext extends ParserRuleContext {
		public DtdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dtd; }
	 
		public DtdContext() { }
		public void copyFrom(DtdContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DtdExprContext extends DtdContext {
		public TerminalNode DTD() { return getToken(HTMLParser.DTD, 0); }
		public DtdExprContext(DtdContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitDtdExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DtdContext dtd() throws RecognitionException {
		DtdContext _localctx = new DtdContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dtd);
		try {
			_localctx = new DtdExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(163); match(DTD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XmlContext extends ParserRuleContext {
		public XmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xml; }
	 
		public XmlContext() { }
		public void copyFrom(XmlContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class XmlDeclarationContext extends XmlContext {
		public TerminalNode XML_DECLARATION() { return getToken(HTMLParser.XML_DECLARATION, 0); }
		public XmlDeclarationContext(XmlContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitXmlDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XmlContext xml() throws RecognitionException {
		XmlContext _localctx = new XmlContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_xml);
		try {
			_localctx = new XmlDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(165); match(XML_DECLARATION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScriptletContext extends ParserRuleContext {
		public ScriptletContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptlet; }
	 
		public ScriptletContext() { }
		public void copyFrom(ScriptletContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ScriptletExprContext extends ScriptletContext {
		public TerminalNode SCRIPTLET() { return getToken(HTMLParser.SCRIPTLET, 0); }
		public ScriptletExprContext(ScriptletContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitScriptletExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptletContext scriptlet() throws RecognitionException {
		ScriptletContext _localctx = new ScriptletContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_scriptlet);
		try {
			_localctx = new ScriptletExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(167); match(SCRIPTLET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScriptContext extends ParserRuleContext {
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
	 
		public ScriptContext() { }
		public void copyFrom(ScriptContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ScriptOpenContext extends ScriptContext {
		public TerminalNode SCRIPT_OPEN() { return getToken(HTMLParser.SCRIPT_OPEN, 0); }
		public TerminalNode SCRIPT_BODY() { return getToken(HTMLParser.SCRIPT_BODY, 0); }
		public TerminalNode SCRIPT_SHORT_BODY() { return getToken(HTMLParser.SCRIPT_SHORT_BODY, 0); }
		public ScriptOpenContext(ScriptContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitScriptOpen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_script);
		int _la;
		try {
			_localctx = new ScriptOpenContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(169); match(SCRIPT_OPEN);
			setState(170);
			_la = _input.LA(1);
			if ( !(_la==SCRIPT_BODY || _la==SCRIPT_SHORT_BODY) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StyleContext extends ParserRuleContext {
		public StyleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_style; }
	 
		public StyleContext() { }
		public void copyFrom(StyleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StyleOpenContext extends StyleContext {
		public TerminalNode STYLE_BODY() { return getToken(HTMLParser.STYLE_BODY, 0); }
		public TerminalNode STYLE_OPEN() { return getToken(HTMLParser.STYLE_OPEN, 0); }
		public TerminalNode STYLE_SHORT_BODY() { return getToken(HTMLParser.STYLE_SHORT_BODY, 0); }
		public StyleOpenContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitStyleOpen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleContext style() throws RecognitionException {
		StyleContext _localctx = new StyleContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_style);
		int _la;
		try {
			_localctx = new StyleOpenContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(172); match(STYLE_OPEN);
			setState(173);
			_la = _input.LA(1);
			if ( !(_la==STYLE_BODY || _la==STYLE_SHORT_BODY) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3\31\u00b2\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\5\2-\n\2"+
		"\3\2\3\2\7\2\61\n\2\f\2\16\2\64\13\2\3\2\5\2\67\n\2\3\2\3\2\7\2;\n\2\f"+
		"\2\16\2>\13\2\3\2\7\2A\n\2\f\2\16\2D\13\2\3\3\7\3G\n\3\f\3\16\3J\13\3"+
		"\3\3\3\3\7\3N\n\3\f\3\16\3Q\13\3\3\4\3\4\3\4\7\4V\n\4\f\4\16\4Y\13\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4e\n\4\f\4\16\4h\13\4\3\4\3\4"+
		"\3\4\3\4\3\4\7\4o\n\4\f\4\16\4r\13\4\3\4\3\4\3\4\3\4\3\4\5\4y\n\4\3\5"+
		"\5\5|\n\5\3\5\3\5\3\5\5\5\u0081\n\5\3\5\5\5\u0084\n\5\7\5\u0086\n\5\f"+
		"\5\16\5\u0089\13\5\3\6\3\6\3\6\3\6\3\6\5\6\u0090\n\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\5\n\u009a\n\n\3\13\3\13\5\13\u009e\n\13\3\f\3\f\5\f\u00a2"+
		"\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\4\3\24\25\3"+
		"\26\27\u00bc\2(\3\2\2\2\4H\3\2\2\2\6x\3\2\2\2\b{\3\2\2\2\n\u008f\3\2\2"+
		"\2\f\u0091\3\2\2\2\16\u0093\3\2\2\2\20\u0095\3\2\2\2\22\u0099\3\2\2\2"+
		"\24\u009d\3\2\2\2\26\u00a1\3\2\2\2\30\u00a3\3\2\2\2\32\u00a5\3\2\2\2\34"+
		"\u00a7\3\2\2\2\36\u00a9\3\2\2\2 \u00ab\3\2\2\2\"\u00ae\3\2\2\2$\'\5\36"+
		"\20\2%\'\7\t\2\2&$\3\2\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2),"+
		"\3\2\2\2*(\3\2\2\2+-\5\34\17\2,+\3\2\2\2,-\3\2\2\2-\62\3\2\2\2.\61\5\36"+
		"\20\2/\61\7\t\2\2\60.\3\2\2\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2"+
		"\62\63\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\65\67\5\32\16\2\66\65\3\2\2"+
		"\2\66\67\3\2\2\2\67<\3\2\2\28;\5\36\20\29;\7\t\2\2:8\3\2\2\2:9\3\2\2\2"+
		";>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=B\3\2\2\2><\3\2\2\2?A\5\4\3\2@?\3\2\2\2"+
		"AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\3\3\2\2\2DB\3\2\2\2EG\5\24\13\2FE\3\2"+
		"\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KO\5\6\4\2LN\5\24"+
		"\13\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\5\3\2\2\2QO\3\2\2\2RS\7"+
		"\f\2\2SW\5\20\t\2TV\5\n\6\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ"+
		"\3\2\2\2YW\3\2\2\2Z[\7\16\2\2[\\\5\b\5\2\\]\7\f\2\2]^\7\20\2\2^_\5\20"+
		"\t\2_`\7\16\2\2`y\3\2\2\2ab\7\f\2\2bf\5\20\t\2ce\5\n\6\2dc\3\2\2\2eh\3"+
		"\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2\2\2ij\7\17\2\2jy\3\2\2\2kl"+
		"\7\f\2\2lp\5\20\t\2mo\5\n\6\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2"+
		"qs\3\2\2\2rp\3\2\2\2st\7\16\2\2ty\3\2\2\2uy\5\36\20\2vy\5 \21\2wy\5\""+
		"\22\2xR\3\2\2\2xa\3\2\2\2xk\3\2\2\2xu\3\2\2\2xv\3\2\2\2xw\3\2\2\2y\7\3"+
		"\2\2\2z|\5\22\n\2{z\3\2\2\2{|\3\2\2\2|\u0087\3\2\2\2}\u0081\5\6\4\2~\u0081"+
		"\5\30\r\2\177\u0081\5\26\f\2\u0080}\3\2\2\2\u0080~\3\2\2\2\u0080\177\3"+
		"\2\2\2\u0081\u0083\3\2\2\2\u0082\u0084\5\22\n\2\u0083\u0082\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0080\3\2\2\2\u0086\u0089\3\2"+
		"\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\t\3\2\2\2\u0089\u0087"+
		"\3\2\2\2\u008a\u008b\5\f\7\2\u008b\u008c\7\21\2\2\u008c\u008d\5\16\b\2"+
		"\u008d\u0090\3\2\2\2\u008e\u0090\5\f\7\2\u008f\u008a\3\2\2\2\u008f\u008e"+
		"\3\2\2\2\u0090\13\3\2\2\2\u0091\u0092\7\22\2\2\u0092\r\3\2\2\2\u0093\u0094"+
		"\7\30\2\2\u0094\17\3\2\2\2\u0095\u0096\7\22\2\2\u0096\21\3\2\2\2\u0097"+
		"\u009a\7\r\2\2\u0098\u009a\7\t\2\2\u0099\u0097\3\2\2\2\u0099\u0098\3\2"+
		"\2\2\u009a\23\3\2\2\2\u009b\u009e\5\26\f\2\u009c\u009e\7\t\2\2\u009d\u009b"+
		"\3\2\2\2\u009d\u009c\3\2\2\2\u009e\25\3\2\2\2\u009f\u00a2\7\3\2\2\u00a0"+
		"\u00a2\7\4\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\27\3\2\2"+
		"\2\u00a3\u00a4\7\6\2\2\u00a4\31\3\2\2\2\u00a5\u00a6\7\7\2\2\u00a6\33\3"+
		"\2\2\2\u00a7\u00a8\7\5\2\2\u00a8\35\3\2\2\2\u00a9\u00aa\7\b\2\2\u00aa"+
		"\37\3\2\2\2\u00ab\u00ac\7\n\2\2\u00ac\u00ad\t\2\2\2\u00ad!\3\2\2\2\u00ae"+
		"\u00af\7\13\2\2\u00af\u00b0\t\3\2\2\u00b0#\3\2\2\2\31&(,\60\62\66:<BH"+
		"OWfpx{\u0080\u0083\u0087\u008f\u0099\u009d\u00a1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}