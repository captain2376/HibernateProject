package cgginterns.hibernate.map2;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {

	public static void main(String[] args) {
		
		System.out.println("hello world");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Employee e1 = new Employee();
		e1.setEmployeeId(1);
		e1.setEmployeeName("Ram");
		
		Employee e2 = new Employee();
		e2.setEmployeeId(2);
		e2.setEmployeeName("Shyam");
	
		Project p1 = new Project();
		p1.setProjectId(11);
		p1.setProjectName("Library management system");

		Project p2 = new Project();
		p2.setProjectId(22);
		p2.setProjectName("ChatBot");
		
		ArrayList<Employee> list1 = new ArrayList<Employee>();
		list1.add(e1);
		list1.add(e2);
		
		ArrayList<Project> list2 = new ArrayList<Project>();
		
		list2.add(p1);
		list2.add(p2);
		
		
		e1.setProjects(list2);
		//e2.setProjects(list2);
	
		p2.setEmployees(list1);
		
		
		Session session = factory.openSession();
		
		Transaction tn = session.beginTransaction();
		
		session.save(e1);
		
		session.save(e2);
		
		session.save(p1);
		
		session.save(p2);
		
		tn.commit();
		
		Employee emp = session.get(Employee.class, 1);
		System.out.println(emp.getEmployeeName());
		for (Project project : emp.getProjects()) {
			System.out.println(project.getProjectName());
		}
		System.out.println("---------------");
		Project pro = session.get(Project.class, 22);
		System.out.println(pro.getProjectName());
		for (Employee e: pro.getEmployees()) {
			System.out.println(e.getEmployeeName());
		}
		
		session.close();
		
		factory.close();

	}

}
