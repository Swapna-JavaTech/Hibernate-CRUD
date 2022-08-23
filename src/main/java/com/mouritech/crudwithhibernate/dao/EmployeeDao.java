package com.mouritech.crudwithhibernate.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.crudwithhibernate.entity.Employee;
import com.mouritech.crudwithhibernate.service.EmployeeService;
import com.mouritech.crudwithhibernate.util.HibernateUtil;




public class EmployeeDao {

	
	public void employeeSave(Employee emp) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(emp);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public void getAllEmployees() {
		// retrieve the data from database to java program using hibernate
		//Transaction transaction = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {

					List<Employee> employeeList = session.createQuery("from Employee", Employee.class).list();
					employeeList.forEach(stud -> System.out.println(stud));

				} catch (Exception e) {
					e.printStackTrace();
				}
				
		
	}
	public void deleteEmployee1(Long empid) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
			Employee deleteEmp = session1.get(Employee.class, empid);
			System.out.println(deleteEmp);
			if(deleteEmp!=null) {
				session1.delete(deleteEmp);
				System.out.println("Employee deleted successfully");
			}
			
			/*
			 * Employee emp2 = new Employee(); emp2.setEmpId(empid); session1.delete(emp2);
			 * System.out.println("Employee deleted"); transaction1.commit();
			 */
			transaction1.commit();
			
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
		
	}
	public void deleteEmployee(Class<?> type,Serializable empid) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
			Employee emp = session1.get(Employee.class, empid);
			System.out.println(emp);
			if(emp!=null) {
				session1.remove(emp);
				System.out.println("Employee deleted successfully");
			}
			
			/*
			 * Employee emp2 = new Employee(); emp2.setEmpId(empid); session1.delete(emp2);
			 * System.out.println("Employee deleted"); transaction1.commit();
			 */
			transaction1.commit();
			
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void updateEmployee(Long empid,String mobNo) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			Employee updatingEmp = session.get(Employee.class, empid);
			System.out.println(updatingEmp);
			//do changes
			updatingEmp.setEmpMobileNo(mobNo);
			//update the Employee object
			session.saveOrUpdate(updatingEmp);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void getEmployeeById(Long empid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			Employee empById = session.get(Employee.class, empid);
			if(empById!=null) {
				
				System.out.println("Employee details are = " + empById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public void deleteByName(String empName) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
			//String deleteSql = "Delete from Employee Where empName = :empName";
			Query<Employee> deleteQuery = session1.createQuery
					("delete from Employee where empName = :empName");
			deleteQuery.setParameter("empName",empName);
			int deleteStatus = deleteQuery.executeUpdate();
			System.out.println(deleteStatus);
			transaction1.commit();
			
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void getEmployeeByName(String empName) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction1 = session1.beginTransaction();
			//Hibernate Named Query Example
			TypedQuery<Employee> empNamedquery = session1.getNamedQuery("searchEmployeeByName");
			empNamedquery.setParameter("name", empName);
			List<Employee> employeesWithName = empNamedquery.getResultList();
			
			Iterator<Employee> empItr = employeesWithName.iterator();
			while(empItr.hasNext()) {
				Employee emp = empItr.next();
				System.out.println(emp);
			}
			
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void getEmployeeByEmail(String empEmail) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction1 = session1.beginTransaction();
			//Hibernate Named Query Example
			TypedQuery<Employee> empEmailquery = session1.getNamedQuery("searchEmployeeByEmail");
			empEmailquery.setParameter("email", empEmail);
			List<Employee> employeesWithEmail = empEmailquery.getResultList();
			
			Iterator<Employee> empItr1 = employeesWithEmail.iterator();
			while(empItr1.hasNext()) {
				Employee emp = empItr1.next();
				System.out.println(emp);
			}
			
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
	}

}
