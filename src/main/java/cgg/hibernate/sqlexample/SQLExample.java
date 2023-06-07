package cgg.hibernate.sqlexample;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		
		//sql query
		String query="select * from student";
		
		NativeQuery nq = session.createNativeQuery(query);
		
		nq.setFirstResult(10);//starting index
		nq.setMaxResults(15);//page size
		List<Object []> list = nq.list();
		
		for (Object[] object : list) {
			//System.out.println(Arrays.toString(object));
			System.out.println(object[0]+" : "+object[4]);
		}
		
		
		session.close();
		
		factory.close();

	}

}
