package com.citec.Compiler.Html;
import java.util.HashMap;
import java.util.Map;



public class ErrorMessage {
	static public enum ERROR{NO_TAGS,VAL_DIF,NO_LIST,NO_STYLE, NO_IMAGE, NO_COMMENT,
							NO_INDENT}
	
	static public Map<Integer, String> map;// = new HashMap<Integer, String>();
	static public void InitErrorMessage() {
		// TODO Auto-generated constructor stub
		map = new HashMap<Integer, String>();
		map.put(ERROR.NO_TAGS.ordinal(), "No esta estructurado con los Tags correspondientes: ");
		map.put(ERROR.VAL_DIF.ordinal(), "El contenido es diferente: ");
		map.put(ERROR.NO_LIST.ordinal(), "No se encuentra las listas: ");
		map.put(ERROR.NO_STYLE.ordinal(),"Los estilos son diferentes: ");
		map.put(ERROR.NO_IMAGE.ordinal(),"No se encuentra la imagen: ");
		map.put(ERROR.NO_COMMENT.ordinal(),"No esta comentado: ");
		map.put(ERROR.NO_INDENT.ordinal(),"No esta indentado: ");
	}
}
