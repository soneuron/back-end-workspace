package com.kh.example.practice3.controller;

import com.kh.example.practice3.model.Employee;

public class EmployeeController {

	private Employee employee = new Employee();
	
	// 오버로딩
	
	public void add(int empNO, String name, char gender, String phone) {
		employee.setEmpNO(empNO);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
	}
	public void add(int empNO, String name, char gender, String phone, String dept, int salary, double bonus) {
		employee.setEmpNO(empNO);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
		employee.setDept(dept);
		employee.setSalary(salary);
		employee.setBonous(bonus);
	}
	
	public void modify (String phone) {
		employee.setPhone(phone);
	}
	
	public void modify (int salary) {
		employee.setSalary(salary);
	}
	
	public void modify (double bonous) {
		employee.setBonous(bonous);
	}
	
	public Employee info() {
		return employee;
	}
}
