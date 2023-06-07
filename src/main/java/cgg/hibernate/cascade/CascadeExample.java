package cgg.hibernate.cascade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cgg.hibernate.sma.StudentApp;
import cgginterns.hibernate.map.Brand;
import cgginterns.hibernate.map.Product;

public class CascadeExample {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
	Brand b1=new Brand();
		b1.setBrandId(4);
		b1.setBrandName("SAMSUNG");
		
		Product p1 = new Product(41,"SamsungPhone");
		
		Product p2 = new Product(42,"Samsung pods");
		
		Product p3 = new Product(43,"Samsung TV");
		
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(p2);
		list.add(p3);
		list.add(p1);
		
		b1.setProducts(list);
		
		Transaction t = session.beginTransaction();
		session.save(b1);
		session.delete(b1);
		//in brand class changes made --cascade all is added
//		@OneToMany(mappedBy="brand",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//		//if join is not there productbrand table is not created
//////		List<Product> products;
////		
////		
		t.commit();
//		
//		Session session11 = factory.openSession();
//		Transaction tx = session11.beginTransaction();
//	
//		Brand br=session11.get(Brand.class,4);
//		session11.delete(br);
//		tx.commit();
//		session11.close();
		
		session.close();
		factory.close();
	}
}


