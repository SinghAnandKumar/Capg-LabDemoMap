package com.labdemo.beans;

public class ProjectManager extends PermanentEmployee{
	
	static int claimCoverage = 1;

	public ProjectManager(EmployeeKey key, String fname, String lname, long salary, String grade, int month, int year) {
		super(key, fname, lname, salary, grade, month, year);
		// TODO Auto-generated constructor stub
	}

	public ProjectManager(EmployeeKey key, String fname, String lname, long salary, String grade, int day, int month,
			int year) {
		super(key, fname, lname, salary, grade, day, month, year);
		// TODO Auto-generated constructor stub
	}
}
