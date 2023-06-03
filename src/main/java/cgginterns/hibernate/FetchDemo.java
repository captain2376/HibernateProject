package cgginterns.hibernate;

import java.io.FileOutputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		//no need to open txn for drl commands
		
		//Student s=(Student)session.get(Student.class, 3);
		//using load we get a proxy
//		Student s=(Student)session.load(Student.class, 3);
//		System.out.println(s);
//		
		
		//fetching address data
		Address addr=(Address)session.load(Address.class,1);
//		Address addr1=(Address)session.load(Address.class,1);
//		
    	//System.out.println(addr);
		//System.out.println(addr.getStreet()+" : "+addr.getCity());
//		System.out.println(addr.getStreet()+" : "+addr1.getCity());
		byte[] image=addr.getImage();
		try (FileOutputStream fos = new FileOutputStream("src/main/java/fetchImage.jfif");){
			
			fos.write(image);
			fos.flush();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		session.close();
		factory.close();    
	}

}
