package com.revature;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String username;
	private String password;
	private String type; // for determining if is employee or finance manager.
	
	@OneToMany(mappedBy="employeeId")
	private transient Set<Ticket> tickets;
	
	public Employee() {

	}
	public Employee(String name, String email, String username, String password, String type) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.type = type;
	}
	public Employee(int id, String name, String email, String username, String password, String type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.type = type;
	}
	
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
				+ password + ", type=" + type + "]";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set getTickets() {
		return tickets;
	}
	public void setTickets(Set tickets) {
		this.tickets = tickets;
	}
	
}

