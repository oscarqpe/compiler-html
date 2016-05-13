package com.citec.Compiler.Html;

public class ErrorCompiler {
	String id;
	String message;
	int numLine;
	int numColumn;
	ErrorCompiler(String id,String message,int numLine, int numColumn) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.message = message;
		this.numLine = numLine;
		this.numColumn = numColumn;
	}
}
