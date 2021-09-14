package com.mindex.challenge.data;

import com.mindex.challenge.service.EmployeeService;
import java.util.Date;

public class Compensation {
	
	private Employee employee;
	private int salary;
	private Date effectiveDate;

	public Compensation() {
		this.employee = null;
		this.salary = 0;
		this.effectiveDate = null;
	}

        public Compensation (Employee employee) {
		
                this.employee = employee;
                this.salary = 0;
                this.effectiveDate = new Date(System.currentTimeMillis());
        }   

        public Compensation (Employee employee, int salary) {
		
                this.employee = employee;
                this.salary = salary;
                this.effectiveDate = new Date(System.currentTimeMillis());
        }   

        public Compensation (Employee employee, int salary, Date effectiveDate) {
             	
		this.employee = employee;
                this.salary = salary;
                this.effectiveDate = effectiveDate;
        }
	
	public Employee getEmployee() {
		return this.employee;
	}

	public int getSalary() {
		return this.salary;
	}

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}	
}
