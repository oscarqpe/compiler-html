package com.citec.Compiler.Html;

public class CodeEntity {
	private int answerId;
	private int userId;
	private int pageId;
	private String code;
	public CodeEntity(int pageId, int userId, String code, int answerId){
		this.answerId = answerId;
		this.userId = userId;
		this.pageId = pageId;
		this.code = code;
	}
	
	public CodeEntity(int pageId, int userId, int answerId){
		this.userId = userId;
		this.pageId = pageId;
		this.answerId = answerId;
	
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

}
