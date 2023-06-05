package cgginterns.hibernate.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cgginterns.hibernate.Certificate;
import cgginterns.hibernate.Student;

public class StateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//create student objects
		
		Student s1 = new Student();
		s1.setId(1971);
		s1.setName("salal");
		s1.setCity("opp");
		
		s1.setCerti(new Certificate("R programming","3 Months"));
//		Certificate c1 = new Certificate();
//		c1.setCourse("Hibernate");
//		c1.setDuration( "2 montsh");
		//transient state
//		s1.setCerti(c1);
//		
//		Session session = factory.openSession();
//		
//		Transaction t = session.beginTransaction();
//		session.save(s1);
//		//student persistent :Session,database
//		
//		s1.setName( "auv");
//		
//		
//			
//		Student stu = session.get(Student.class, 1971);
//		session.delete(stu);
////		System.out.println(stu.getName()+" "+stu.getCity());
////		
//		session.delete(stu);
//		//student :removed state
//		
//		t.commit();	
//		session.close();
//		//detach state
//		s1.setName("DEf");
//		
//		System.out.println(s1.getName());
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student s = session.get(Student.class, 121);
		//detach state
//		session.evict(s);
//		s.setName("popopo");
//		
//		session.update(s);
		
		//----remove state
//		session.delete(s);
		
		
		
	//	transaction.commit();
		
		session.close();
		s.setName( "bb");
		session=factory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(s);
		tr.commit();
		session.close();
		factory.close();
	}

}
