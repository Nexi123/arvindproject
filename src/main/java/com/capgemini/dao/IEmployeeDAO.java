package com.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.capgemini.bean.Employee;
import com.capgemini.bean.Status;

public interface IEmployeeDAO {

	public abstract void setEntityManager(EntityManager entityManager);

	public abstract void addEmployee(Employee emp);

	public abstract List<Employee> getAllEmp();

	public abstract Employee getEmployeeById(long employeeId);

	public abstract void deleteEmployee(long empId);

	public abstract long updateEmployee(Employee emp);
	
	public abstract void  addStatus(Status status);
	
	public abstract  List<Status> getAllStatus();
	
	public abstract Status getStatusById(String statusId);
	
	public abstract Status editStatus(Status status);
	
	public abstract List<Status> getDetailsByDate(String sDate,String eDate,long empId);

}