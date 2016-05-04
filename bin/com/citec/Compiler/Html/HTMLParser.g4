/*
 [The "BSD licence"]
 Copyright (c) 2013 Tom Everett
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

parser grammar HTMLParser;

options { tokenVocab=HTMLLexer; }

htmlDocument    
    : (scriptlet | SEA_WS)* xml? (scriptlet | SEA_WS)* dtd? (scriptlet | SEA_WS)* htmlElements*		#HtmlDocumentExpr
    ;

htmlElements
    : htmlMisc* htmlElement htmlMisc*		# htmlElementsExpr
    ;

htmlElement     
    : TAG_OPEN htmlTagName htmlAttribute* TAG_CLOSE htmlContent TAG_OPEN TAG_SLASH htmlTagName TAG_CLOSE	# htmlTagOpenAttContSlashClose
    | TAG_OPEN htmlTagName htmlAttribute* TAG_SLASH_CLOSE		# htmlTagOpenAttSlash
    | TAG_OPEN htmlTagName htmlAttribute* TAG_CLOSE				# htmlTagOpenAttClose
    | scriptlet													# htmlTagScriptLet
    | script													# htmlTagScript
    | style														# htmlTagStyle
    ;

htmlContent     
    : htmlChardata? ((htmlElement | xhtmlCDATA | htmlComment) htmlChardata?)*	# htmlContentExpr
    ;

htmlAttribute   
    : htmlAttributeName TAG_EQUALS htmlAttributeValue							# htmlAttEquals
    | htmlAttributeName															# htmlAtt
    ;

htmlAttributeName
    : TAG_NAME																	# htmlAttName
    ;

htmlAttributeValue
    : ATTVALUE_VALUE															# htmlAttValue
    ;

htmlTagName
    : TAG_NAME																	# htmlTagNameExpr
    ;

htmlChardata    
    : HTML_TEXT 																# htmlCharDataHtmlText
    | SEA_WS																	# htmlCharDataSeaWs
    ;

htmlMisc        
    : htmlComment 																# htmlMiscComment
    | SEA_WS																	# htmlMiscSeaWs
    ;

htmlComment
    : HTML_COMMENT																# htmlCommentComment
    | HTML_CONDITIONAL_COMMENT													# htmlCommentCommentConditional
    ;

xhtmlCDATA
    : CDATA																		# xhtmlCData
    ;

dtd
    : DTD																		# dtdExpr
    ;

xml
    : XML_DECLARATION															# xmlDeclaration
    ;

scriptlet
    : SCRIPTLET																	# scriptletExpr
    ;

script
    : SCRIPT_OPEN ( SCRIPT_BODY | SCRIPT_SHORT_BODY)							# scriptOpen
    ;

style
    : STYLE_OPEN ( STYLE_BODY | STYLE_SHORT_BODY)								# styleOpen
    ;
