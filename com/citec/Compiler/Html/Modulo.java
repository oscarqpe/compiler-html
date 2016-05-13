package com.citec.Compiler.Html;

import java.util.List;

public class Modulo {
	private int id;
	private String name;
	private List<Leccion> listLeccions;
	
	public  Modulo(int id, String name, List<Leccion> listLeccions) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.listLeccions = listLeccions;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Leccion> getListLeccions() {
		return listLeccions;
	}

	public void setListLeccions(List<Leccion> listLeccions) {
		this.listLeccions = listLeccions;
	}
	

}
