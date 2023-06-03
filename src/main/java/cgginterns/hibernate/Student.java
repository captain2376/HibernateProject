package cgginterns.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

//entity to tell jdbc to create student table same as class name -@Entity



////to change table name
//
//@Table(name="mystudents")
//
@Entity
public class Student {
	//to recognize each row we need a primary key @Id above that attribute can tell what is primary key
	
	@Id
	private int id;
	private String name;
	private String city;
	private Certificate certi;
	
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	public Student() {
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
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public Certificate getCerti() {
		return certi;
	}

	public void setCerti(Certificate certi) {
		this.certi = certi;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
}
