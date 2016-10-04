package com.labdemo.beans;

import java.util.HashMap;

public class Contractor {
	private int totalCBEmployees = 0;
	private String name = "";
	private static int contractorCount = 0;
	HashMap<EmployeeKey,ContractBasedEmployee> CBEmployees = null;

	{
		contractorCount++;
	}

	
	public static int getContractorCount() {
		return contractorCount;
	}

	public int getTotalCBEmployees() {
		return totalCBEmployees;
	}

	public Contractor(String name) {
		this.name = name;
		CBEmployees = new HashMap<EmployeeKey,ContractBasedEmployee>();
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	
	public void addCBEmployee(ContractBasedEmployee CBEmployee)
	{
		CBEmployees.put(CBEmployee.getKey(),CBEmployee);
	}
	
	public HashMap<EmployeeKey,ContractBasedEmployee> getCBEmployees() {
		return CBEmployees;
	}
	
	

	// Inner CBEmployee class
	public class ContractBasedEmployee extends Employee {
		private int ratePerHour = 0;
		private int hours_worked = 0;

		{
			totalCBEmployees++;
		}

		public ContractBasedEmployee(EmployeeKey key, String fname, String lname, String grade, int month, int year) {
			super(key, fname, lname, grade, month, year);
		}

		public ContractBasedEmployee(EmployeeKey key, String fname, String lname, String grade, int month, int year,
				int ratePerHour) {
			super(key, fname, lname, grade, month, year);
			this.ratePerHour = ratePerHour;
		}

		public ContractBasedEmployee(EmployeeKey key, String fname, String lname, String grade, int day, int month, int year,
				int ratePerHour) {
			super(key, fname, lname, grade, day, month, year);
			this.ratePerHour = ratePerHour;
		}

		public String getname() {
			return name;
		}

		public int getRatePerHour() {
			return ratePerHour;
		}

		public void setRatePerHour(int ratePerHour) {
			this.ratePerHour = ratePerHour;
		}

		public int getHours_worked() {
			return hours_worked;
		}

		public void setHours_worked(int hours_worked) {
			this.hours_worked = hours_worked;
			calculateSalary();
		}

		public void calculateSalary() {
			super.setSalary(ratePerHour * hours_worked);
		}

		public long payBill() {
			calculateSalary();
			setHours_worked(0);
			return getSalary();
		}

	}
	// --Inner CBEmployee class
}