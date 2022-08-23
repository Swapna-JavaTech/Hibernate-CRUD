package com.mouritech.crudwithhibernate.service;

import java.util.Scanner;

import com.mouritech.crudwithhibernate.dao.EmployeeDao;
import com.mouritech.crudwithhibernate.entity.Employee;

public class EmployeeService {
	static Scanner sc = new Scanner(System.in);
	EmployeeDao empdao = new EmployeeDao();

	public void employeeSave() {
		Employee emp = new Employee();
		System.out.println("Enter the details of the employee");
		//sc.nextLine()
		System.out.println("Enter the employee name....");
		emp.setEmpName(sc.nextLine());
		System.out.println("Enter the employee email....");
		emp.setEmpEmail(sc.nextLine());
		System.out.println("Enter the employee mobile number....");
		emp.setEmpMobileNo(sc.nextLine());
		empdao.employeeSave(emp);	
	}

	public void getAllEmployees() {
		
		empdao.getAllEmployees();
	}
	
	public void deleteEmployee() {

		System.out.println("Enter the employee id to delete....");
		Long empid = sc.nextLong();
		empdao.deleteEmployee(Employee.class,new Long(empid));
	}

	public void updateEmployee() {
		Employee emp = new Employee();
		System.out.println("Enter the details of the employee");
		//sc.nextLine()
		System.out.println("Enter the employee name....");
		emp.setEmpName(sc.nextLine());
		System.out.println("Enter the employee email....");
		emp.setEmpEmail(sc.nextLine());
		System.out.println("Enter the employee mobile number....");
		emp.setEmpMobileNo(sc.nextLine());
		//empdao.employeeSave(emp);	
		//empdao.updateEmployee(emp);
	}
	
	public  void getDetailsToUpdate() {
		System.out.println("Enter the employee id....");
		Long empid = sc.nextLong();
		System.out.println("Enter the mobile no");
		String mobNo = sc.next();
		//return mobNo;
		empdao.updateEmployee(empid,mobNo);
	}

	public void getEmployeeeById() {
		System.out.println("Enter the employee id....");
		Long empid = sc.nextLong();
		empdao.getEmployeeById(empid);
	}

	public void deleteEmployee1() {
		System.out.println("Enter the employee id....");
		Long empid = sc.nextLong();
		empdao.deleteEmployee1(empid);
		
	}

	public void deleteByName() {
		System.out.println("Enter the employee name....");
		String empName=sc.nextLine();
		empdao.deleteByName(empName);
	}

	public void getEmployeeByName() {
		System.out.println("Enter the employee name....");
		String empName=sc.nextLine();
		empdao.getEmployeeByName(empName);
		
	}

	public void getEmployeeByEmail() {
		System.out.println("Enter the employee email....");
		String empEmail=sc.nextLine();
		empdao.getEmployeeByEmail(empEmail);
		
	}

}
