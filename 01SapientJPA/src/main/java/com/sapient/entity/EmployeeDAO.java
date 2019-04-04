package com.sapient.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class EmployeeDAO {
	//SessionFactory  sesssionFactory = new Configuration().configure().buildSessionFactory();
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
    
	public void addEmployee(Employee emp){
//		Session session = sesssionFactory.openSession();
//		Transaction tx = null;
//		tx = session.beginTransaction();
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(emp);
		
		transaction.commit();
		em.close();
		
		
	}
	
	public Employee findEmployee(int id){
		
		EntityManager em = emf.createEntityManager();
		Employee emp =  em.find(Employee.class, id);
		em.close();
		
		return emp;
	}

	public boolean deleteEmployee(int id) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(em.find(Employee.class, id));
		transaction.commit();
		em.close();
		return true;
	}
	
	public boolean updateEmployee(int id,int sal) 
	{

		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Employee emp = em.find(Employee.class, id);
		emp.setSalary(sal);
		
		transaction.commit();
		em.close();
		
		return true;
	}
	

}