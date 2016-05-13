package com.citec.Compiler.Html;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

public class SolutionEntity {
	private HTMLParser parser;
	private ParseTree tree;
	private CodeEntity entity;
	private Boolean solValVisitor;
	private List<Recommendation> listErrorSyntax;
	
	
	public SolutionEntity(ParseTree tree, CodeEntity entity, HTMLParser parser,Boolean solValVisitor){
		this.parser = parser;
		this.tree = tree;
		this.entity = entity;
		this.solValVisitor =solValVisitor;
	}
	public SolutionEntity(ParseTree tree, CodeEntity entity, HTMLParser parser,Boolean solValVisitor, List<Recommendation> errorSyntax){
		this.parser = parser;
		this.tree = tree;
		this.entity = entity;
		this.solValVisitor =solValVisitor;
		this.listErrorSyntax = errorSyntax;
	}
	
	public HTMLParser getParser() {
		return parser;
	}

	public void setParser(HTMLParser parser) {
		this.parser = parser;
	}

	
	public ParseTree getTree() {
		return tree;
	}
	public void setTree(ParseTree tree) {
		this.tree = tree;
	}
	public CodeEntity getEntity() {
		return entity;
	}
	public void setEntity(CodeEntity entity) {
		this.entity = entity;
	}
	
	public Boolean getSolValVisitor() {
		return solValVisitor;
	}

	public void setSolValVisitor(Boolean solValVisitor) {
		this.solValVisitor = solValVisitor;
	}

	public List<Recommendation> getListErrorSyntax() {
		return listErrorSyntax;
	}

	public void setListErrorSyntax(List<Recommendation> listErrorSyntax) {
		this.listErrorSyntax = listErrorSyntax;
	}

}
