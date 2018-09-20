package com.capgemini.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {

	@Id
	@Column(name = "statusId")
	private String statusId;
	
	@Column(name = "empId")
	private long empId;
		
	@Column(name = "status")
	private String status;
	
	@Column(name = "date1")
	private String date;
	
	
	
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	 public Status() {
		// TODO Auto-generated constructor stub
	}
	public Status( String statusId,long empId, String status, String date) {
		super();
		this.statusId = statusId;
		this.empId = empId;
		this.status = status;
		this.date = date;
	}
	
}
