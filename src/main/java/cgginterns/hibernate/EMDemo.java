	package cgginterns.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EMDemo {

	public static void main(String[] args) {
		
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
	
	//create student object
	Student student = new Student();
	student.setId(102);
	student.setName( "Vrinda");
	student.setCity( "dwarka");
	
	//create certificate object
	
	Certificate certi = new Certificate();
	certi.setCourse("Android");
	certi.setDuration( "2 months");
	
	student.setCerti(certi);
	System.out.println(student);
	Student student1 = new Student();
	student1.setId(101);
	student1.setName( "Vihaari");
	student1.setCity( "goa");
	
	//create certificate object
	
	Certificate certi1 = new Certificate();
	certi1.setCourse("AWS");
	certi1.setDuration( "1 months");
	
	student1.setCerti(certi1);
	System.out.println(student1);
	
	Session session = factory.openSession();
	
	
	session.beginTransaction();
	
	session.save(student);
	session.save(student1);
	session.getTransaction().commit();
	session.close();
	factory.close();
	}

}
