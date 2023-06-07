package cgginterns.hibernate.hql;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cgginterns.hibernate.Student;

public class HQLDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s=factory.openSession();
//		String query="from Student where city='hyd'";
		//Parameters dynamic
//		String query="from Student as st where st.city= :x and st.name= :n";
//		//alias for table in hql::String query="from Student  st where st.city= :x and st.name= :n";
//		Query q = s.createQuery(query);
//		q.setParameter("x", "hyd");
//		q.setParameter("n", "hto");
		//single reslult-unique
		//Multiple res-list
//		List <Student>list = q.list();
		
//		for (Student student : list) {
//			System.out.println(student.getName()+" "+student.getCerti().getCourse());
//		}
		
		System.out.println("--------------------------------------");
		//Transaction tx = s.beginTransaction();
		
		//delete query
		
//		Query q1=s.createQuery("delete from Student st where st.city= :x");
//		
//		q1.setParameter("x", "hyd");
//		int r=q1.executeUpdate();
//		System.out.println("deleted :");
//		System.out.println(r);
		
		//update query
		
		
		//create query from session
//		Query q1=s.createQuery("update Student set City= :c where name= :n");
//		
//		q1.setParameter("c", "delhi");//set the parameters
//		q1.setParameter("n", "raj");//set the parameters
//		int r = q1.executeUpdate();
//		System.out.println("updated :"+ r);
//		tx.commit();
		//how to execute join query
		
		Query q1 = s.createQuery("select b.brandId,b.brandName,p.productName from Brand as b INNER JOIN b.products as p");
		
		List <Object []>list2 = q1.getResultList();//array of arraylist every elements of the list is object array
		
		for (Object[] arr : list2) {
			System.out.println(Arrays.toString(arr));
		}
		
		
		
		s.close();
		factory.close();
	}}

