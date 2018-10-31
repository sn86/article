package com.jpa.article.controller;

public class  ArticleException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
 
	public String getErrorMessage() {
		return errorMessage;
	}
	public ArticleException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public ArticleException() {
		super();
	} 

}
