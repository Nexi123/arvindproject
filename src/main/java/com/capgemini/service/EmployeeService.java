package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.bean.Employee;
import com.capgemini.bean.Status;
import com.capgemini.dao.EmployeeDAO;
import com.capgemini.dao.IEmployeeDAO;

@Service("employeeService")
@Transactional
public class EmployeeService implements IEmployeeService {
    @Autowired
	private IEmployeeDAO iEmployeeDAO;
    @Transactional(readOnly = false)
	public void addEmployee(Employee emp) {
		iEmployeeDAO.addEmployee(emp);
	}
  
	public List<Employee> getAllEmployee() {
		return iEmployeeDAO.getAllEmp();
	}
  
	public Employee getEmployeeById(long empId) {
		return iEmployeeDAO.getEmployeeById(empId);

	}
	@Transactional(readOnly = false)
	public void deleteEmployee(long empId) {
		iEmployeeDAO.deleteEmployee(empId);
	}
	@Transactional(readOnly = false)
	public long updateEmployee(Employee emp) {
		return iEmployeeDAO.updateEmployee(emp);
	}
  
	@Transactional(readOnly = false)
	public void addStatus(Status status) {
		iEmployeeDAO.addStatus(status);
	}
  
	public List<Status> getAllStatus() {
		return iEmployeeDAO.getAllStatus();
	}
   
	public Status getStatusById(String statusId) {
		return iEmployeeDAO.getStatusById(statusId);
	}
   
	public Status editStatus(Status status)
	{
		return iEmployeeDAO.editStatus(status);
	}
   
	public List<Status> getDetailsByDate(String sDate,String eDate,long empId)
	{
		return iEmployeeDAO.getDetailsByDate(sDate, eDate,empId);
	}
}
