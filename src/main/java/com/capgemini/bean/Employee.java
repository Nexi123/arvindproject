package com.capgemini.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "Employe")
public class Employee implements Serializable {
 
	 private static final long serialVersionUID = -3465813074586302847L;

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", ename=" + ename + ", email="
				+ email + ", uname=" + uname + ", pass=" + pass + ", mgr="
				+ mgr + ", job=" + job + ", sal=" + sal + "]";
	}
	
   
    public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
   	@Column(name = "empid")
       @SequenceGenerator(name="empid",sequenceName="EMP_SEQ1",allocationSize=1)
       @GeneratedValue(generator="empid",strategy=GenerationType.SEQUENCE)
    private long empId;
    
    @Column(name = "ename")
    private String ename;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "USERNAME")
    private String uname;
    
    @Column(name = "PASSWORD")
    private String pass;
    
    @Column(name = "mgr")
    private String mgr;
    
    @Column(name = "job")
    private String job;
    
    @Column(name = "sal")
    private int sal;
     

	
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}