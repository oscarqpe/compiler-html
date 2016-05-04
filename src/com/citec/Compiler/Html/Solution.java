package com.citec.Compiler.Html;

import java.util.List;

public class Solution {
	private int user_id;
	private int page_id;
	private int answer_id;
	private int similitud;
	
	private List<Recommendation> recomedaciones;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPage_id() {
		return page_id;
	}
	public void setPage_id(int page_id) {
		this.page_id = page_id;
	}
	public int getSimilitud() {
		return similitud;
	}
	public void setSimilitud(int similitud) {
		this.similitud = similitud;
	}
	public List<Recommendation> getRecomedaciones() {
		return recomedaciones;
	}
	public void setRecomedaciones(List<Recommendation> recomedaciones) {
		this.recomedaciones = recomedaciones;
	}
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}

}
