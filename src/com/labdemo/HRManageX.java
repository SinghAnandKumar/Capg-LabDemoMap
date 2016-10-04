package com.labdemo;

import java.util.*;

import com.labdemo.beans.Employee;

class HRManageX {

	ArrayList<Employee> employees = new ArrayList<Employee>();
	static Scanner sc = new Scanner(System.in);
	static int cntr = 0;

//	public static void main(String args[]) {
//		int ch;
//		while (true) {
//			System.out.println("Enter choice :\n1.Add a new Employee" + "\n2.View total Employees"
//					+ "\n3.Delete an Employee record" + "\n4.Exit");
//			ch = sc.nextInt();
//			if (ch == 1)
//				addNewEmployee();
//			else if (ch == 2)
//				viewTotal();
//			else if (ch == 3)
//				deleteEmployee();
//			else
//				System.exit(0);
//		}
//
//	}
//
//	static void addNewEmployee() {
//		int month, year;
//
//		Employee emp = new Employee();
//		emp.setEmpId = generateEmpId();
//
//		System.out.println("Enter First name :");
//		emp.setFirstName = sc.next();
//
//		System.out.println("Enter Last name :");
//		emp.setLastName = sc.next();
//
//		System.out.println("Enter Salary :");
//		emp.setSalary = sc.nextLong();
//
//		System.out.println("Enter Grade :");
//		emp.setGrade = sc.next();
//
//		while (true) {
//			System.out.println("Enter Joinig month :");
//			month = sc.nextInt();
//			if (month > 0 && month < 13) {
//				month = formatMonth(month);
//				break;
//			}
//		}
//
//		while (true) {
//			System.out.println("Enter Joinig Year :");
//			year = sc.nextInt();
//			if (year > 0) {
//				year = formatYear(year);
//				break;
//			}
//		}
//
//		emp.setJoiningMonth(String.valueOf(month) + String.valueOf(year));
//
//		employees.add(emp);
//	}
//
//	String generateEmpId() {
//		cntr++;
//		return "ABC" + cntr;
//	}
//
//	int formatMonth(int month) {
//		//
//		return month;
//	}
//
//	int formatYear(int year) {
//		//
//		return year;
//	}
//
//	static void deleteEmployee(String empId) {
//		Iterator itr = new Iterator(employees);
//
//		while (itr.hasNext()) {
//			Employee emp = itr.next;
//			if (emp.getEmpId == empId) {
//				employees.remove(emp);
//				break;
//			}
//		} //
//
//	} // end of delete

} // end of class