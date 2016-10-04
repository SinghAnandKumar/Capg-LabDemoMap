package com.labdemo.beans;

public class TechnicalAssociate extends PermanentEmployee {

	public TechnicalAssociate(EmployeeKey key, String fname, String lname, long salary, String grade, int day, int month,
			int year) {
		super(key, fname, lname, salary, grade, day, month, year);
		// TODO Auto-generated constructor stub
	}

	public TechnicalAssociate(EmployeeKey key, String fname, String lname, long salary, String grade, int month, int year) {
		super(key, fname, lname, salary, grade, month, year);
		// TODO Auto-generated constructor stub
	}

}
