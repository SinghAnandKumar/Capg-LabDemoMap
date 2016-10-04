package com.labdemo.exception;

public class EmployeeNotPresentEmployee extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = "Error while searching Employee. No Employee with this employee ID ";

	public EmployeeNotPresentEmployee(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/*
	 * @Override public String getMessage() { return message; }
	 * 
	 * @Override public String toString() { return message; }
	 */
}
