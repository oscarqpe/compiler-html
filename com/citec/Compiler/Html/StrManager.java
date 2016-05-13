package com.citec.Compiler.Html;

public class StrManager {
	
	public static String clearSpace(String s){
		return null;
	}
	
	public static String clearCharSp(String input) {
	    
	    String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";	    
	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    String output = input;
	    for (int i=0; i<original.length(); i++) {	     
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }
	    return output;
	}
	
	public static String eraserChar(int i, String s) {
		String a = s.substring(0, i);
		String b = s.substring(i + 1, s.length());
		return a + b;
	}

}
