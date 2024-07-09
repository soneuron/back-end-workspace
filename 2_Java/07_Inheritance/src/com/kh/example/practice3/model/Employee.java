package com.kh.example.practice3.model;

public class Employee {

	
	private int empNO;
	private String name;
	private char gender;
	private String phone;
	private String dept;
	private int salary;
	private double bonous;
	
	public Employee() {
	}


	public Employee(int empNO, String name, char gender, String phone, String dept, int salary, double bonous) {
		this.empNO = empNO;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.dept = dept;
		this.salary = salary;
		this.bonous = bonous;
	}


	public int getEmpNO() {
		return empNO;
	}


	public void setEmpNO(int empNO) {
		this.empNO = empNO;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public double getBonous() {
		return bonous;
	}


	public void setBonous(double bonous) {
		this.bonous = bonous;
	}


	@Override
	public String toString() {
		return "Employee [empNO=" + empNO + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", dept="
				+ dept + ", salary=" + salary + ", bonous=" + bonous + "]";
	}
	
	
}
