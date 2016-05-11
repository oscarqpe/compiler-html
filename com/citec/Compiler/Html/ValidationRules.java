package com.citec.Compiler.Html;

import java.util.List;

public class ValidationRules {
	private int pageId;
	private Boolean valSol;
	private List<String> listTag;
	private List<String> listContenido;
	private List<String> listTagContenido;
	private List<EstiloEntity> listEstilos;
	
	public ValidationRules() {
		// TODO Auto-generated constructor stub
	}
	
	public int getPageId() {
		return pageId;
	}


	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	
	
	public List<String> getListTag() {
		return listTag;
	}
	public void setListTag(List<String> listTag) {
		this.listTag = listTag;
	}
	public List<String> getListContenido() {
		return listContenido;
	}
	public void setListContenido(List<String> listContenido) {
		this.listContenido = listContenido;
	}
	public List<String> getListTagContenido() {
		return listTagContenido;
	}
	public void setListTagContenido(List<String> listTagContenido) {
		this.listTagContenido = listTagContenido;
	}
	public List<EstiloEntity> getListEstilos() {
		return listEstilos;
	}
	public void setListEstilos(List<EstiloEntity> listEstilos) {
		this.listEstilos = listEstilos;
	}
	public Boolean getValSol() {
		return valSol;
	}

	public void setValSol(Boolean valSol) {
		this.valSol = valSol;
	}

	
}
