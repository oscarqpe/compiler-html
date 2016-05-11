package com.citec.Compiler.Html;

import java.util.HashMap;
import java.util.Map;

import com.citec.Compiler.Html.ErrorMessage.ERROR;

public class ExpresionRules {
	static public Map<String, String> map;// = new HashMap<Integer, String>();
	static public void InitRules() {
		// TODO Auto-generated constructor stub
		map = new HashMap<String, String>();
		map.put("title","title");
		map.put("h1", "h1");
		map.put("h2", "h2");
		map.put("h3", "h3");
		map.put("h4", "h4");
		map.put("h5", "h5");
		map.put("h6", "h6");
		map.put("p", "p");
		map.put("li", "li");
		
		
	}
}
