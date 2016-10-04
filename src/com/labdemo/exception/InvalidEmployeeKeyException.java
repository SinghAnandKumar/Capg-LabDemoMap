package com.labdemo.exception;

public class InvalidEmployeeKeyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = "Invalid Employee Key ";
	
	
	public InvalidEmployeeKeyException(String message) {
		this.message = message;
	}
	public InvalidEmployeeKeyException() {
		// TODO Auto-generated constructor stub
	}
	
}
