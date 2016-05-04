package com.citec.Compiler.Html;
import java.util.ArrayList;
import java.util.List;


public class Exceptions {
	static public List< ErrorCompiler> ListExceptions = new ArrayList<ErrorCompiler>();
	//static public int count=0;	
	
	static public void addError(int numLine, int message){	
		ListExceptions.add(new ErrorCompiler(message+"", ErrorMessage.map.get(message), numLine));
		//count++;
	}
	
}
