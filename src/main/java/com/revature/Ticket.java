package com.revature;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tickets_table")
public class Ticket {
	@Id
	@GeneratedValue  
	private int id;
	
//	// foreign key in user/employee table
//	@Column(name = "user_id", nullable = false)
//	private int employeeId; 
	
	@Column(name = "ticket_type", nullable = false)
	private String type;
	
	@Column(name = "ticket_status", nullable = false)
	private String status;
	
	@Column(name = "reimbursement_amount")
	private double reimbursementAmount;
	
	@Column(name = "ticket_description")
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	@ManyToOne
	@JoinColumn(name="employee_id", nullable = false)
	private Employee employeeId;
	
	public Ticket () {};
	
	public Ticket (int id, Employee employeeId, String type, String status,
			double reimbursementAmount, String description, Date timestamp) {
		this.id = id;
		this.employeeId = employeeId;
		this.type = type;
		this.status = status;
		this.reimbursementAmount = reimbursementAmount;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return employeeId.getId();
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

	public String getType() {
		return type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
