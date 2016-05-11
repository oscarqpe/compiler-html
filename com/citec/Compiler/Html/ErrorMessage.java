package com.citec.Compiler.Html;
import java.util.HashMap;
import java.util.Map;



public class ErrorMessage {
	static public enum ERROR{NO_TAGS,VAL_DIF,NO_LIST,NO_STYLE}
	
	static public Map<Integer, String> map;// = new HashMap<Integer, String>();
	static public void InitErrorMessage() {
		// TODO Auto-generated constructor stub
		map = new HashMap<Integer, String>();
		map.put(ERROR.NO_TAGS.ordinal(), "No se respeta el orden de los Tags");
		map.put(ERROR.VAL_DIF.ordinal(), "El contenido no es el mismo");
		map.put(ERROR.NO_LIST.ordinal(), "No se encuentra las listas");
		map.put(ERROR.NO_STYLE.ordinal(), "Los estilos no coinciden con los planteados");
	}
}
