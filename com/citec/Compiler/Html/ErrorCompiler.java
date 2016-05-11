package com.citec.Compiler.Html;

public class ErrorCompiler {
	String id;
	String message;
	int numLine;
	ErrorCompiler(String id,String message,int numLine) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.message = message;
		this.numLine = numLine;
	}
}
