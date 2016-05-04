package com.citec.Compiler.Html;

import java.util.ArrayList;
import java.util.List;

public class ExpresionValidation {
	static public List<String> listExpreVal = new ArrayList<String>();
	static public List<String> listExpreValContent = new ArrayList<String>();
	static public List<String> listExpreValTag = new ArrayList<String>();
	static public List<String> listExpreValStyle = new ArrayList<String>();
	
	public static void initListExpre(List<String> l){
		listExpreVal=l;
	}
	
	public static void initListExpreContent(List<String> l){
		listExpreValContent= l;
	}
	
	public static void initListExpreTag(List<String> l){
		listExpreValTag= l;
	}
	
	public static void initListExpreStyle(List<String> l){
		listExpreValStyle = l;
	}

}
