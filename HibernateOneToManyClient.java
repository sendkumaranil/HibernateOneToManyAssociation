package com.association.onetomany.annotation.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.association.onetomany.annotation.model.Department;
import com.association.onetomany.annotation.model.Employee;
import com.association.onetomany.annotation.util.HibernateUtil;

public class HibernateOneToManyClient {

	public static void main(String[] args) {
	
		Department department=new Department();
		department.setName("Finance");
		
		Employee emp1 =new Employee();
		emp1.setFirstname("Gaurav");
		emp1.setLastname("Agarwal");
		emp1.setBirthdate(new Date());
		emp1.setDepartment(department);
		
		Employee emp2 =new Employee();
		emp2.setFirstname("Surubhi");
		emp2.setLastname("Batra");
		emp2.setBirthdate(new Date());
		emp2.setDepartment(department);
				
		
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		try{
			sessionFactory=HibernateUtil.getSessionfactory();
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(emp1);
			session.save(emp2);
			
			tx.commit();
			session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
