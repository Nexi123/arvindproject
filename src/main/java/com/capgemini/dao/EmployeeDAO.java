package com.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.bean.Employee;
import com.capgemini.bean.Status;
import com.capgemini.controller.ManagerController;

@Repository("employeeDAO")
public class EmployeeDAO implements IEmployeeDAO{
	private static final Logger logger = Logger.getLogger(EmployeeDAO.class);
	
	/*JdbcTemplate template;*/

	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
    
	public void addEmployee(Employee emp) {
		
		try {
			
		logger.info("employee object............-----------------"+emp);
		
		entityManager.clear();
		entityManager.persist(emp);
		
		logger.info("method end");
		System.out.println("Entity saved.");
		} catch (Exception e) {
			System.out.println("Data Cannot be inserted"+e);
		}
		

		
		
	}

	public List<Employee> getAllEmp() {
		String str = "SELECT emp FROM Employee emp";
		TypedQuery<Employee> query = entityManager.createQuery(str,
				Employee.class);
		return query.getResultList();
	}

	public Employee getEmployeeById(long employeeId) {
		return entityManager.find(Employee.class, employeeId);

	}

	public void deleteEmployee(long empId) {
		Query query = entityManager
				.createNativeQuery("DELETE FROM Employe e WHERE e.empId =  " + empId);
		query.executeUpdate();
		
	}

	public long updateEmployee(Employee emp) {
		
		Employee employee = getEmployeeById(emp.getEmpId());
		if(employee == null){
			return 1;
		}
		else
		{
		employee.setEmpId(emp.getEmpId());
		employee.setEname(emp.getEname());
		employee.setEmail(emp.getEmail());
		employee.setUname(emp.getUname());
		employee.setPass(emp.getPass());
		employee.setMgr(emp.getMgr());
		employee.setJob(emp.getJob());
		employee.setSal(emp.getSal());
		entityManager.merge(employee);
		return 0;
		}
	}

	public void addStatus(Status status) {
		entityManager.persist(status);
	}

	public List<Status> getAllStatus() {
		String str = "SELECT st FROM Status st";
		TypedQuery<Status> query = entityManager.createQuery(str, Status.class);
		return query.getResultList();
	}
	public Status getStatusById(String statusId) {
		return entityManager.find(Status.class, statusId);

	}
	public Status editStatus(Status status)
	{
		return entityManager.merge(status);
	}
	public List<Status> getDetailsByDate(String sDate,String eDate,long empId)
	{
		String str= "SELECT st FROM Status st WHERE st.date BETWEEN '"+sDate+"' AND '"+eDate+"' "
				+ "AND st.empId="+ empId;
		TypedQuery<Status> query = entityManager.createQuery(str,
				Status.class);
		return query.getResultList();
		
	}

}
