package cgg.hibernate.sma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SMAppMain {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		
		boolean value=true;
		
		while(value) {
			
		System.out.println("PRESS '1' TO INSERT INTO STUDENT :");
		System.out.println("PRESS '2 ' TO UPDATE STUDENT :");
		System.out.println("PRESS 3 TO DELETE STUDENT");
		System.out.println("PRESS 4 TO DISPLAY DETAILS");
		System.out.println("PRESS 5 TO EXIT APPLICATION");
		System.out.println("-----------------------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int key=Integer.parseInt(br.readLine());
			
			switch (key) {
			case 1:
				System.out.println("name");
				String sname=br.readLine();
				System.out.println("id");
				int sid=Integer.parseInt(br.readLine());
				System.out.println("rollno");
				int srollno=Integer.parseInt(br.readLine());
				
				StudentApp s1 = new StudentApp();
				s1.setId(sid);
				s1.setName(sname);
				s1.setRollno(srollno);
				Session session = factory.openSession();
				Transaction t = session.beginTransaction();
				session.save(s1);
				t.commit();
				System.out.println("inserted successfully");
				session.close();
				break;
			case 2:
					//update name and rollno
				Session session1 = factory.openSession();
				Transaction txupdate = session1.beginTransaction();
				int updateId=Integer.parseInt(br.readLine());
				
				StudentApp supdate=session1.get(StudentApp.class,updateId);
				System.out.println("name");
				String name=br.readLine();
				System.out.println("rollno");
				int rollno=Integer.parseInt(br.readLine());
				
				supdate.setName(name);
				supdate.setRollno(rollno);
				session1.update(supdate);
				
				txupdate.commit();
				System.out.println("updated");
				session1.close();
				break;
				
			case 3:
				//delete
				Session session11 = factory.openSession();
				Transaction tx = session11.beginTransaction();
				int delId=Integer.parseInt(br.readLine());
				StudentApp sa=session11.get(StudentApp.class,delId);
				session11.delete(sa);
				tx.commit();
				session11.close();
				break;
			case 4:
				Session session111 = factory.openSession();
					String query="from StudentApp";
					Query q=session111.createQuery(query);
					List <StudentApp>list = q.list();
					
					for (StudentApp s : list) {
						
						System.out.println(s.getId()+" "+s.getName()+" "+s.getRollno());
					}
					session111.close();
				break;
			case 5:
				System.out.println("THANK YOU");
				value=false;
				break;
			default:
				System.out.println("please enter suitable value");
				break;
			}
			
		} catch (NumberFormatException | IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
		factory.close();
	}
}
