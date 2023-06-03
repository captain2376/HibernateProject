package cgginterns.hibernate.map2;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

		@Id
		@Column(name="e_id")
		private int employeeId;
		private String employeeName;
		
		@ManyToMany
		@JoinTable(name="emp_proj",joinColumns= {@JoinColumn(name="eid")},
		inverseJoinColumns= {@JoinColumn(name="pid")})
		private List<Project> projects;
		
		
		
		public List<Project> getProjects() {
			return projects;
		}
		public void setProjects(List<Project> projects) {
			this.projects = projects;
		}
		public Employee(int employeeId, String employeeName) {
			super();
			this.employeeId = employeeId;
			this.employeeName = employeeName;
		}
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		
		
		
}
