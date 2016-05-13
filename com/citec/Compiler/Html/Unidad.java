package com.citec.Compiler.Html;

import java.util.List;

public class Unidad {
	private int id;
	private String name;
	private List<Modulo> listModulos;
	public Unidad(int id, String name, List<Modulo> listModulos) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.listModulos = listModulos;
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
	public List<Modulo> getListModulos() {
		return listModulos;
	}
	public void setListModulos(List<Modulo> listModulos) {
		this.listModulos = listModulos;
	}
	


}
