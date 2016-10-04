package com.labdemo.utils;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;

import com.labdemo.beans.Contractor;
import com.labdemo.beans.Contractor.ContractBasedEmployee;
import com.labdemo.exception.EmployeeNotPresentEmployee;
import com.labdemo.beans.Employee;
import com.labdemo.beans.EmployeeKey;
import com.labdemo.beans.PermanentEmployee;

public class Statistics {

	HashMap<EmployeeKey, PermanentEmployee> permEmployees = null;
	HashMap<String, Contractor> contractors = null;
	String employeeNotFoundMessage = "Error while searching Employee. No Employee with this employee ID ";

	public Statistics(HashMap<EmployeeKey, PermanentEmployee> permEmployees, HashMap<String, Contractor> contractors) {
		// TODO Auto-generated constructor stub
		this.permEmployees = permEmployees;
		this.contractors = contractors;
	}

	public int totalPermanentEmployees() {
		return PermanentEmployee.getTotalPermEmployees();
	}

	public int totalContracBasedEmployees() {
		int totalCBEmployee = 0;
		
		Set<Map.Entry<String, Contractor>> contractorSet = contractors.entrySet();
		
		for (Map.Entry<String, Contractor> contractor1 : contractorSet) {
			int count = contractor1.getValue().getTotalCBEmployees();
			totalCBEmployee += count;
		}
		return totalCBEmployee;
	}

	public Employee searchEmployee(EmployeeKey Key) throws EmployeeNotPresentEmployee {
		Set<Map.Entry<EmployeeKey, PermanentEmployee>> empSet = permEmployees.entrySet();

		// Searching in Permanent Employee Set
		for (Map.Entry<EmployeeKey, PermanentEmployee> emp : empSet) {
			if (emp.getValue().getKey().equals(Key))
				return emp.getValue();
		}

		// Searching in Contract based Employee Set
		Set<Map.Entry<String, Contractor>> contractorS = contractors.entrySet();

		for (Map.Entry<String, Contractor> contractor : contractorS) {
			searchContractBasedEmplyee(contractor.getValue(), Key);
		}

		throw (new EmployeeNotPresentEmployee(employeeNotFoundMessage));
	}

	// Search Contractor,s CBEmploee set for particular CBEmployee
	public ContractBasedEmployee searchContractBasedEmplyee(Contractor c, EmployeeKey Key) throws EmployeeNotPresentEmployee {
		HashMap<EmployeeKey, ContractBasedEmployee> CBEmployees = c.getCBEmployees();
		Set<Map.Entry<EmployeeKey, ContractBasedEmployee>> CBEmployeeSet = CBEmployees.entrySet();

		for (Map.Entry<EmployeeKey, ContractBasedEmployee> CBEmployee : CBEmployeeSet) {
			if (CBEmployee.getValue().getKey().equals(Key))
				return CBEmployee.getValue();

		}
		throw (new EmployeeNotPresentEmployee(employeeNotFoundMessage));
	}

	public void CBEmployeeStatistics() {
		int totalCBEmployee = 0;

		Set<Map.Entry<String, Contractor>> contractorSet = contractors.entrySet();
		for (Map.Entry<String, Contractor> contractor1 : contractorSet) {
			String contractorName = contractor1.getValue().getname();
			int count = contractor1.getValue().getTotalCBEmployees();
			System.out.println("Contract based Employees with " + contractorName + " = " + count);
			totalCBEmployee += count;
		}
		System.out.println("Total CBEmployees = " + totalCBEmployee);
	}

	public void seeAllPermEmployees() {
		System.out.println("\n ***  Permanent Employees ***");

		Set<Map.Entry<EmployeeKey, PermanentEmployee>> empSet = permEmployees.entrySet();

		for (Map.Entry<EmployeeKey, PermanentEmployee> emp : empSet) {
			seeEmployeeDetail(emp.getValue());
		}
		/*
		 * for (PermanentEmployee e : permEmployees) { seeEmployeeDetail(e); }
		 */
	}

	public void seeAllContractors() {
		System.out.println("\n***  All Contractors ***");
		Contractor c = null;
		Set<Map.Entry<String, Contractor>> contractorSet = null;
		contractorSet = contractors.entrySet();

		for (Map.Entry<String, Contractor> contractor : contractorSet) {
			c = contractor.getValue();

			// System.out.println("Contractor Name : " + c.getname());
			System.out.println("Contractor Name : " + contractor.getValue().getname());
			System.out.println("No of Employees under this contractor = " + c.getTotalCBEmployees());
		}
	}

	// Shows all contract based employees for given contractor
	public void seeCBEmployees(Contractor c) {
		System.out.println("\n ***  Contract Based Employees ***");

		HashMap<EmployeeKey, ContractBasedEmployee> CBEmployees = c.getCBEmployees();
		Set<Map.Entry<EmployeeKey, ContractBasedEmployee>> CBEmployeeSet = CBEmployees.entrySet();

		for (Map.Entry<EmployeeKey, ContractBasedEmployee> CBEmployee : CBEmployeeSet) {
			seeEmployeeDetail(CBEmployee.getValue());
		}
	}

	// shows all contract based employees of all contractors
	public void seeAllCBEmployees() {
		System.out.println("\n ***  Contract Based Employees ***");

		Set<Map.Entry<String, Contractor>> contractorS = contractors.entrySet();

		for (Map.Entry<String, Contractor> contractor : contractorS) {
			System.out.println("Contractor : " + contractor.getValue().getname());
			seeCBEmployees(contractor.getValue());
		}
	}

	// Details of a particular Employee
	public void seeEmployeeDetail(Employee e) {
		System.out.println("Emp Id : " + e.getKey().toString());
		System.out.println("First Name : " + e.getFirstName());
		System.out.println("Last Name : " + e.getLastName());
		System.out.println("Salary : " + e.getSalary());
		System.out.println("Grade : " + e.getGrade());
		System.out.println("Joining date :" + e.getJoiningMonth() + "\n\n");
	}

	public void seeAllEmployees() {
		seeAllCBEmployees();
		seeAllPermEmployees();
	}
}
