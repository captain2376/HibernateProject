package cgginterns.hibernate.map;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BrandProductMapDemo {

	public static void main(String[] args) {
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//create a brand
		Brand brand = new Brand();
		brand.setBrandId(1);
		brand.setBrandName( "TATA");
		
		//creating product
		Product product = new Product();
		product.setProductId(11);
		product.setProductName("TATA AUTOMOTORS");
		product.setBrand(brand);
		
		Product product2 = new Product();
		product2.setProductId(2);
		product2.setProductName("TATA STEEL");
		product2.setBrand(brand);
		
		Product product3 = new Product();
		product3.setProductId(3);
		product3.setProductName( "TATA POWER");
		product3.setBrand(brand);
		
		ArrayList<Product> products = new ArrayList<>();
		products.add(product);
		products.add(product2);
		products.add(product3);
		
		brand.setProducts(products);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(brand);
		session.save(product);
		session.save(product2);
		session.save(product3);
		
		
		transaction.commit();
		//fetching objects
		Brand b=(Brand)session.get(Brand.class, 1);
			System.out.println(b.getBrandId());
			for  (Product p : b.getProducts()) {
				System.out.println(p.getProductName());
			}
			
			
		session.close();
		
		factory.close();
	}

}
