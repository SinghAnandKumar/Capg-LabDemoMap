package com.labdemo;

import java.util.HashMap;
import java.util.Scanner;

import com.labdemo.beans.Contractor;
import com.labdemo.beans.Contractor.ContractBasedEmployee;
import com.labdemo.beans.Employee;
import com.labdemo.beans.EmployeeKey;
import com.labdemo.beans.PermanentEmployee;
import com.labdemo.exception.EmployeeNotPresentEmployee;
import com.labdemo.exception.InvalidEmployeeKeyException;
import com.labdemo.utils.Statistics;

class HRManage {
	static HashMap<EmployeeKey, PermanentEmployee> permEmployees = new HashMap<EmployeeKey, PermanentEmployee>();
	static HashMap<String, Contractor> contractors = new HashMap<String, Contractor>();
	static int rate_per_hour = 50;
	static Scanner sc = new Scanner(System.in);
	

	public static void main(String args[]) throws InvalidEmployeeKeyException {
		
		Statistics statistics = new Statistics(permEmployees, contractors);
		PermanentEmployee permEmployee;
		EmployeeKey empKey = new EmployeeKey();

		// Permanent Employee creation
		// Employee with MMYYYY
		empKey = empKey.generateKey();
		permEmployee = new PermanentEmployee(empKey, "Anand", "Singh", 10000, "A1", 8, 2016);
		permEmployees.put(empKey, permEmployee);

		// Employee with DDMMYYYY
		empKey = empKey.generateKey();
		permEmployee = new PermanentEmployee(empKey, "Rohit", "Singh", 15000, "A2", 1, 9, 2012);
		permEmployees.put(empKey, permEmployee);

		// Employee with DDMMYYYY
		empKey = empKey.generateKey();
		permEmployee = new PermanentEmployee(empKey, "Ram", "Krishna", 20000, "A3", 6, 2013);
		permEmployees.put(empKey, permEmployee);
		// Permanent Employee creation

		// Contract based employee
		Contractor contractor;

		// For Contractor 1
		contractor = new Contractor("Contractor 1");
		contractors.put(contractor.getname(), contractor);

		ContractBasedEmployee CBEmployee;
		empKey = empKey.generateKey();
		CBEmployee = contractor.new ContractBasedEmployee(empKey, "Sarthak ", "Srivastava", "A1", 1, 10, 2016,
				rate_per_hour);
		CBEmployee.setHours_worked(100);
		// seeEmployeeDetail(CBEmployee);
		contractor.addCBEmployee(CBEmployee);

		empKey = empKey.generateKey();
		CBEmployee = contractor.new ContractBasedEmployee(empKey, "Tushar ", "Sahay", "A2", 1, 11, 2016,
				rate_per_hour);
		CBEmployee.setHours_worked(150);
		// seeEmployeeDetail(CBEmployee);
		contractor.addCBEmployee(CBEmployee);
		// --For Contractor 1

		// For Contractor 2
		contractor = new Contractor("Contractor 2");
		contractors.put(contractor.getname(), contractor);

		empKey = empKey.generateKey();
		CBEmployee = contractor.new ContractBasedEmployee(empKey, "Dipan ", "Mirgani", "B1", 1, 04, 2015,
				rate_per_hour);
		CBEmployee.setHours_worked(50);
		// seeEmployeeDetail(CBEmployee);
		contractor.addCBEmployee(CBEmployee);

		empKey = empKey.generateKey();
		CBEmployee = contractor.new ContractBasedEmployee(empKey, "Vishal ", "Yadav", "B2", 1, 05, 2014,
				rate_per_hour);
		CBEmployee.setHours_worked(80);
		// seeEmployeeDetail(CBEmployee);
		contractor.addCBEmployee(CBEmployee);
		// --For Contractor 2

		// --Contract based employee creation

		// Statistics

		statistics.seeAllPermEmployees();
		statistics.seeAllContractors();
		statistics.seeAllCBEmployees();
		
		System.out.println("Total Permanent Employees = " + PermanentEmployee.getTotalPermEmployees());
		System.out.println("Total Employees = " + Employee.getTotalEmployee());
		// --Statistics

		// Search an Employee with employee ID
		System.out.println("Enter emp ID : ");
		String tempEmpId = sc.next();
		int code = Integer.valueOf(tempEmpId.substring(3));
		EmployeeKey searchKey = new EmployeeKey(code);

		try {
			Employee e = statistics.searchEmployee(searchKey);
			statistics.seeEmployeeDetail(e);
		} catch (EmployeeNotPresentEmployee e) {
			// System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// --Search an Employee with employee ID

	}// --End of main()

	
}
