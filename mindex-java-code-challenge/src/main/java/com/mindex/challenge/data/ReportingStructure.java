package com.mindex.challenge.data;

import java.util.*;

public class ReportingStructure {
	private Employee employee;
	private int numberOfReports;	
	
	public ReportingStructure () {
		this.employee = null;
		this.numberOfReports = 0;
	}

	public ReportingStructure (Employee employee) {
		this.employee = employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public int setNumOfReports() {
		return setNumOfReports(this.employee);
	}


	//This function returns the number of employees that return to this.employee
	public int setNumOfReports(Employee employee) {
		int total = 0;
		List<Employee> listOfDirectReports = employee.getDirectReports();
		
		//This if statement makes it possible to not add the this.employee to the number
		//of employees reporting them. It checks to see if the employee your on is this.employee
		if (employee == this.employee) {
			if (listOfDirectReports == null) {
				return 0;
			} else {
				for (int i = 0; i < listOfDirectReports.size(); i++) {
					System.out.println("First");
					total += setNumOfReports(listOfDirectReports.get(i));
				}
			}
		//The else begins the recursive call to count the number of employees below this.employee
		} else {
			if (listOfDirectReports == null) {
				System.out.println("Bottomed");
				return 1;
			} else {
				total += 1;
				for (int i = 0; i < listOfDirectReports.size(); i++) {
					System.out.println("Second");
					total += setNumOfReports(listOfDirectReports.get(i));
				}
				return total;
			}
		}	
		this.numberOfReports = total;
		return total;
	}
}
