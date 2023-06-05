package cgginterns.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cgginterns.hibernate.Student;

public class HQLDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s=factory.openSession();
//		String query="from Student where city='hyd'";
		//paramaeters dyanamic
		String query="from Student as st where st.city= :x and st.name= :n";
		//alias for table in hql::String query="from Student  st where st.city= :x and st.name= :n";
		Query q = s.createQuery(query);
		q.setParameter("x", "hyd");
		q.setParameter("n", "hto");
		//single reslult-unique
		//Multiple res-list
		List <Student>list = q.list();
		
		for (Student student : list) {
			System.out.println(student.getName()+" "+student.getCerti().getCourse());
		}
		s.close();
		factory.close();
	}}

