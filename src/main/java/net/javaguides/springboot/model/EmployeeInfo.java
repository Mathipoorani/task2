package net.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class EmployeeInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@Column(columnDefinition="TEXT")
	private String address;
	
	private String bloodGroup;
	
	private String siblings;
	
	private String userSiblings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getSiblings() {
		return siblings;
	}

	public void setSiblings(String siblings) {
		this.siblings = siblings;
	}

	public String getUserSiblings() {
		return userSiblings;
	}

	public void setUserSiblings(String userSiblings) {
		this.userSiblings = userSiblings;
	}
	
	
}
