package com.teja.hibernate.demo;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.teja.hibernate.demo.entity.Instructor;
import com.teja.hibernate.demo.entity.InsturctorDetail;


public class CreateDemo {

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
			System.out.println("Creating new object: ");
			session.beginTransaction();
			Instructor theInstructor = new Instructor("Teja","Anagani","anst@gmail.com");
			InsturctorDetail theInstructorDetail = new InsturctorDetail("youtube/anagani.com","Teja here Useless guy");
			theInstructor.setInstructorDetail(theInstructorDetail);
			
			/*
			//To Delete 
			session.beginTransaction();
			
			int sid = 1;
			Instructor theInstructor = session.get(Instructor.class,sid);
			System.out.println("Deleting : "+theInstructor);
			
			session.delete(theInstructor);*/ 
			session.save(theInstructor);
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally
		{
			factory.close();
		}
	}

	

}
