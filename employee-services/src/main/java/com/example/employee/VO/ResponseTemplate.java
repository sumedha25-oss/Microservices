package com.example.employee.VO;

import java.util.Optional;

import com.example.employee.entity.Employee;

public class ResponseTemplate {
	
	private Employee employee;
	private Department department;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
