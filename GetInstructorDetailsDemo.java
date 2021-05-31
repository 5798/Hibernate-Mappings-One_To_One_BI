package com.teja.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.teja.hibernate.demo.entity.Instructor;
import com.teja.hibernate.demo.entity.InsturctorDetail;



public class GetInstructorDetailsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InsturctorDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try
		{
			
			session.beginTransaction();
			int sid = 30;
			InsturctorDetail theInstructorDetail = session.get(InsturctorDetail.class,sid);
			System.out.println("theInstructorDetail : "+theInstructorDetail);
			System.out.println("Associated theInstructor : "+theInstructorDetail.getInstructor());
			
			//session.delete(theInstructor); 
			//session.save(theInstructor);
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.clear();//to hndle leak issue
			factory.close();
		}
	}

	
	

}
