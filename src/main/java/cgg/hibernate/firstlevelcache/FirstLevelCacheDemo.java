package cgg.hibernate.firstlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cgginterns.hibernate.Student;

public class FirstLevelCacheDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		//as long as you dont close the session it will be there in cache memory

		Student student=null;
		System.out.println(session.contains(student));
		 student = session.get(Student.class, 21);
		System.out.println(student);
		System.out.println(session.contains(student));
		System.out.println("working something.......");
		
		//need the same object once again
		//so ask session
		
		Student student2 = session.get(Student.class, 21);
		
		System.out.println(student2);
		//session method to know objec exists in session.contains()
		System.out.println(session.contains(student));
		
		session.close();
		
		factory.close();
	}

}
