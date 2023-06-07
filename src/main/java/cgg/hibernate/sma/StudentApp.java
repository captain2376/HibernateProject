package cgg.hibernate.sma;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentApp {
	
	@Id
	private int id;
	private String name;
	private int rollno;
	public StudentApp(int id, String name, int rollno) {
		super();
		this.id = id;
		this.name = name;
		this.rollno = rollno;
	}
	public StudentApp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	
	
}
