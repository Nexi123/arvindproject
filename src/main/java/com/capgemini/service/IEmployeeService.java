package com.capgemini.service;

import java.util.List;

import com.capgemini.bean.Employee;
import com.capgemini.bean.Status;

public interface IEmployeeService {

	public abstract void addEmployee(Employee emp);

	public abstract List<Employee> getAllEmployee();

	public abstract Employee getEmployeeById(long empId);

	public abstract void deleteEmployee(long empId);

	public abstract long updateEmployee(Employee emp);
	
	public abstract Status getStatusById(String statusId);
	
	public abstract void  addStatus(Status status);
	
	public abstract  List<Status> getAllStatus();
	
	public abstract Status editStatus(Status status);
	 
	public abstract List<Status> getDetailsByDate(String sDate,String eDate,long empId);

}