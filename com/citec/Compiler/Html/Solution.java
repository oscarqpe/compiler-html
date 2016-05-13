package com.citec.Compiler.Html;

import java.util.List;

public class Solution {
	private int user_id;
	private int page_id;
	private int answer_id;
	private int similitud_levenshtein;
	private int similitud_ast;
	
	private List<Recommendation> errors;
	
	private List<String> recommendations;
	
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
	
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public int getSimilitud_levenshtein() {
		return similitud_levenshtein;
	}
	public void setSimilitud_levenshtein(int similitud_levenshtein) {
		this.similitud_levenshtein = similitud_levenshtein;
	}
	public int getSimilitud_ast() {
		return similitud_ast;
	}
	public void setSimilitud_ast(int similitud_ast) {
		this.similitud_ast = similitud_ast;
	}
	public List<Recommendation> getErrors() {
		return errors;
	}
	public void setErrors(List<Recommendation> errors) {
		this.errors = errors;
	}
	public List<String> getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(List<String> recommendations) {
		this.recommendations = recommendations;
	}
	

}
