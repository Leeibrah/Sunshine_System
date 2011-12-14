package org.fleet.classes;

import java.sql.*;

public class Employee{
	private int empFileNum;
	private String name;
	private int driveClass;
	private static Database db;

	
//	public Employee(int empFileNum, String name, int driveClass){
//		this.empFileNum = empFileNum;
//		this.name = name;
//		this.driveClass = driveClass;
//		
//	}

	public int getEmpFileNum() {
		return empFileNum;
	}

	public void setEmpFileNum(int empFileNum) {
		this.empFileNum = empFileNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDriveClass() {
		return driveClass;
	}

	public void setDriveClass(int driveClass) {
		this.driveClass = driveClass;
	}

	public static void main(String[] args) throws SQLException {
		Employee e = new Employee();
		System.err.println("Emp.Number\tName\tDrive Class\n");
		e.setEmpFileNum(34);
		e.setDriveClass(1);
		e.setName("Maina");
		
		Employee em = new Employee();
		em.setEmpFileNum(545);
		em.setName("Charles");
		em.setDriveClass(1);
		e.toString();
		em.toString();
		
		e.addEmployee("James Bush", "2");
	}
	public void addEmployee(String name, String drive){
		db = new Database();
		  System.out.println("work");
	}
}
