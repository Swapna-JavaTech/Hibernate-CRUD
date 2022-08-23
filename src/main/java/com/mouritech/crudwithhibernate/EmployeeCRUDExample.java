package com.mouritech.crudwithhibernate;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mouritech.crudwithhibernate.service.EmployeeService;
//import com.mouritech.crudwithhibernate.util.HibernateUtil;

public class EmployeeCRUDExample {

	//private static final Logger logger = LogManager.getLogger(EmployeeCRUDExample.class); 
	public static void main(String[] args) {
		char ch = 'y';
		String transaction = null;
		Scanner sc = new Scanner(System.in);
		EmployeeService empService = new EmployeeService();
		while(ch == 'y') {
			System.out.println("Enter the transaction type");
			System.out.println("save : to insert a new employee");
			System.out.println("update : to update an employee");
			System.out.println("delete : to delete an employee");
			System.out.println("delete1 : to delete an employee");
			System.out.println("getall : to get all employee details");
			System.out.println("get : to get an employee detail");
			System.out.println("deletebyname : to delete an employee by name");
			System.out.println("searchempbyname : to search an employee using name");
			System.out.println("searchempbyemail : to search an employee using name");
			transaction = sc.next();
			switch (transaction) {
			case "save":
				empService.employeeSave();
				break;
			case "getall":
				empService.getAllEmployees();
				break;
			case "delete":
				empService.deleteEmployee();
				break;
			case "deletebyname":
				empService.deleteByName();
				break;
			case "delete1":
				empService.deleteEmployee1();
				break;
			case "update":
				empService.getDetailsToUpdate();
				break;
			case "get":
				empService.getEmployeeeById();
				break;
			case "searchempbyname":
				empService.getEmployeeByName();
				break;
			case "searchempbyemail":
				empService.getEmployeeByEmail();
				break;
			default:
				System.out.println("Not a valid transaction");
				break;
			}
			System.out.println("Do you want to continue (y-yes/n-no)");
			ch = sc.next().charAt(0);
		}

		sc.close();
	}

}
