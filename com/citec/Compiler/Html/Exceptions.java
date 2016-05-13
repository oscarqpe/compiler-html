package com.citec.Compiler.Html;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Exceptions {
	static public List< ErrorCompiler> ListExceptions = new ArrayList<ErrorCompiler>();
	static public Set< String> ListRecomendations = new HashSet<String>();
	//static public int count=0;	
	
	static public void addError(int numLine,int numColumn, int message, String errorValue){	
		ListExceptions.add(new ErrorCompiler(message+"", ErrorMessage.map.get(message)+" "+errorValue, numLine,numColumn));
		//count++;
	}
	static public void addRecommendation(int unidad, int modulo, int leccion){
		String uname=Silabus.unidades.get(unidad-1).getName();
		List<Modulo> modulos = Silabus.unidades.get(unidad-1).getListModulos();
		String mname= modulos.get(modulo-1).getName();
		Leccion lec=modulos.get(modulo-1).getListLeccions().get(leccion-1);
		String lname = lec.getName();
		
		
		ListRecomendations.add("Unidad: "+uname + " Modulo: " + mname+" Leccion: " + lname );
	
	}
	
}
