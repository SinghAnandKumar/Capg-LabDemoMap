package com.labdemo.beans;

public class Employee {
	static private int totalEmployees = 0;
	private EmployeeKey key = null;
	private String firstName = "NA";
	private String lastName = "NA";
	private long salary = 0;
	private String grade = "NA";
	private JoiningMonth joiningMonth = null;

	{
		totalEmployees++;
	}

	// Constructor for Contract based employee , No initial salary
	Employee(EmployeeKey key, String fname, String lname, String grade, int month, int year) {
		this.key = key;
		firstName = fname;
		lastName = lname;
		this.grade = grade;
		joiningMonth = new JoiningMonth(month, year);
	}
	
	Employee(EmployeeKey key, String fname, String lname, String grade, int day, int month, int year) {
		this.key = key;
		firstName = fname;
		lastName = lname;
		this.grade = grade;
		joiningMonth = new JoiningMonth(day, month, year);
	}

	protected Employee(EmployeeKey key, String fname, String lname, long salary, String grade, int day, int month, int year) {
		this.key = key;
		firstName = fname;
		lastName = lname;
		this.salary = salary;
		this.grade = grade;
		joiningMonth = new JoiningMonth(day, month, year);
	}

	protected Employee(EmployeeKey key, String fname, String lname, long salary, String grade, int month, int year) {
		this.key = key;
		firstName = fname;
		lastName = lname;
		this.salary = salary;
		this.grade = grade;
		joiningMonth = new JoiningMonth(month, year);
	}

	public int getTotalEmployees() {
		return totalEmployees;
	}

	public void setKey(EmployeeKey key) {
		this.key = key;
	}

	public EmployeeKey getKey() {
		return key;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public long getSalary() {
		return salary;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setJoiningMonth(JoiningMonth joiningMonth) {
		this.joiningMonth = joiningMonth;
	}

	public String getJoiningMonth() {
		return joiningMonth.getDate();
	}
	
	public static int getTotalEmployee()
	{
		return totalEmployees;
	}
}
