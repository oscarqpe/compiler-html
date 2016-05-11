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

}
