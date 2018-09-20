package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.bean.Employee;
import com.capgemini.bean.Status;
import com.capgemini.bean.Statuss;
import com.capgemini.service.IEmployeeService;

@Controller
public class ManagerController {
	
	private static final Logger logger = Logger.getLogger(ManagerController.class);

	/*@Autowired
	EmployeeService empService;*/
	@Autowired
	IEmployeeService iEmployeeService;
	boolean booleanStatus = false;
	

	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(value = "username") String uname,
			@RequestParam("password") String pass, HttpServletRequest request,
			HttpSession session) {
	
		
		//boolean valid = true;
		List<Employee> empList = iEmployeeService.getAllEmployee();
		for (Employee e : empList) {
			if (uname.equals(e.getUname()) && pass.equals(e.getPass())) {
				session.setAttribute("name", uname);
		   //	valid = false;
				session.setAttribute("mgrId", e.getEmpId());
				session.setAttribute("jobRole", e.getJob());
				session.setAttribute("empId", e.getEmpId());
				session.setAttribute("Ename", e.getEname());				
				return new ModelAndView("login");
			}
		}
		 
		return new ModelAndView("ErrorPage", "errorPage", "Error is Occured Please Do login Again");
		
	}

	@RequestMapping(value="/addEmployee")
	public ModelAndView addEmployee(
		
			@ModelAttribute("employee") Employee employee,
			@RequestParam(value = "added",required = false, defaultValue = "false") String st)
			throws IOException {
		return new ModelAndView("addEmployee", "addedStatus", st);

	}

	@RequestMapping(value="/addNewEmployee", method= RequestMethod.POST)
	public void addNewEmployee(HttpServletResponse response,
			HttpSession session, @ModelAttribute("employee") Employee employee,
			BindingResult result, Model model
			) throws IOException {
		logger.info("model daata is-------------------------------------"+employee);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		long empId=employee.getEmpId();
		try {
			
		
			iEmployeeService.addEmployee(employee);
			
			logger.info("result");
		} catch (Exception e) {
			out.println("alert('Data Cannot be inserted');");
		}
		response.sendRedirect("listdetails");
	
		
	

	}

	/* List all employees */
	@RequestMapping(value="/listdetails")
	public ModelAndView listAllEmployees(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employeeList", this.iEmployeeService.getAllEmployee());

		return new ModelAndView("listAllEmployees");
	}

	/* Get employee by ID 
	@RequestMapping(value="/getEmployeeById")
	public ModelAndView getEmployee() {
		return new ModelAndView("getEmployee");
	}*/

	@RequestMapping(value="/showEmployee")
	public ModelAndView ShowEmployee(Model model, Employee employee,
			@RequestParam("empId") long employeeId) {
		Employee emp = iEmployeeService.getEmployeeById(employeeId);
		System.out.println(emp);
		return new ModelAndView("getEmployee", "employeeData", emp);
	}

	/* removing an employee */
	@RequestMapping("/remove/{id}")
	public ModelAndView removeEmployee(@PathVariable("id") int id,Model model,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		model.addAttribute("emp", this.iEmployeeService.getEmployeeById(id));
		Employee emp=iEmployeeService.getEmployeeById(id);
		try {
			iEmployeeService.deleteEmployee(id);
		} catch (Exception e) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Data Cann't be removed');");
		
			out.println("</script>");
		}
		return new ModelAndView("deleteEmployee","emp",emp);
	}
	@RequestMapping(value="/deleteEmpDetails")
	public void deleteEmployee(@ModelAttribute("emp") Employee employee,
			HttpServletResponse response)
			throws IOException {
		logger.info("data of edit-----------------------------= "+employee);
		
		response.sendRedirect("listdetails");
	}


	/* edit an employee */
	@RequestMapping(value="/edit/{id}")
	public ModelAndView editEmployee(@PathVariable("id") long empId,
			Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employeeList", this.iEmployeeService.getAllEmployee());
		logger.info("data of editing= ........................"+empId);
		Employee emp=iEmployeeService.getEmployeeById(empId);
		return new ModelAndView("editEmployee", "emp", emp );
				
	}

	@RequestMapping(value="/upadteEditEmpDetails")
	public void editEmployee(@ModelAttribute("emp") Employee employee,
			HttpServletResponse response)
			throws IOException {
		logger.info("data of edit-----------------------------= "+employee);
		
		//employee.setJob(job);
		iEmployeeService.updateEmployee(employee);
		
		response.sendRedirect("listdetails");
	}

	@RequestMapping(value="/addStatus")
	public ModelAndView addStatus(
			Model model,
			HttpSession session,
			@RequestParam(value = "statusExists", required = false, defaultValue = "false") String statusExists) {
		long id = (long) session.getAttribute("empId");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		String today = dtf.format(localDate);

		String statusId = id + today;
		if (iEmployeeService.getStatusById(statusId) != null) {
			statusExists = "true";
		}
		model.addAttribute("statusExists", statusExists);
		return new ModelAndView("addStatus", "emp",
				iEmployeeService.getEmployeeById(id));
	}

	/* add Status of an employee*/ 
	@RequestMapping("/addStatus{id}")
	public ModelAndView addStatusEmployee(@PathVariable("id") long empId,
			Model model, @ModelAttribute("employee") Employee employee,
			HttpServletResponse response) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		String today = dtf.format(localDate);

		String statusId = empId + today;
		System.out.println(statusId);
		if (iEmployeeService.getStatusById(statusId) != null) {
			response.sendRedirect("addStatus?statusExists=true");
		}
		Employee emp = iEmployeeService.getEmployeeById(empId);
		return new ModelAndView("addEmpStatus", "emp", emp);
	}

	@RequestMapping("/EmployeeStatusInserted")
	public void EmployeeStatusInserted(
			@ModelAttribute("employee") Employee employee, @RequestParam("status") String statusValue, HttpServletResponse response)
			throws IOException {
		logger.info("method is start  EmployeeStatusInserted......................"+statusValue);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();

		long empId = employee.getEmpId();
		logger.info(" employee id is....................."+empId);
		String today = dtf.format(localDate);
		String statusId = empId + today;
		
		
		Status st = new Status();
		st.setEmpId(empId);
		st.setDate(today);
		st.setStatus(statusValue);
		st.setStatusId(statusId);

		iEmployeeService.addStatus(st);

		response.sendRedirect("addStatus?statusExists=true");

	}

	@RequestMapping("/statusAdded")
	public void statusAdded(@RequestParam("date") String date,
			@RequestParam("status") String statusValue,
			@ModelAttribute("employee") Employee employee,
			HttpServletResponse response) throws IOException {
		boolean statusMatched = false;
		String statusId = employee.getEmpId() + date;
		List<Status> statusList = iEmployeeService.getAllStatus();
		for (Status sl : statusList) {
			if (statusId.equals(sl.getStatusId())) {
				statusMatched = true;
				response.sendRedirect("addStatus?error=true");
			}
		}
		if (statusMatched == false) {
			Status status = new Status();

			status.setStatusId(statusId);
			status.setEmpId(employee.getEmpId());
			status.setDate(date);
			status.setStatus(statusValue);

			iEmployeeService.addStatus(status);
			response.sendRedirect("addStatus");
		}
	}

	 /*View the status */

	@RequestMapping("/viewStatus")
	public ModelAndView viewStatus(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employeeList", this.iEmployeeService.getAllEmployee());

		return new ModelAndView("viewStatus");
	}

	@RequestMapping("/editStatus")
	public ModelAndView editEmployeeStatuss(Model model) {
		return new ModelAndView("editStatus");
		
	}
	
	
	@RequestMapping("/editStatus{id}")
	public ModelAndView editEmployeeStatus(@PathVariable("id") long empId,
			Model model, @ModelAttribute("status") Status status) {
		model.addAttribute("empId", empId);
		return new ModelAndView("editStatus");
	}

	@RequestMapping("/findStatus")
	public ModelAndView findEmployeeStatus(@RequestParam("id") long empId,
			Model model, @ModelAttribute("status") Status status,
			@RequestParam("date") String date) {
		String statusId = empId + date;
		Status status1 = iEmployeeService.getStatusById(statusId);
		model.addAttribute("empId", empId);
		if (status1 == null)
			model.addAttribute("emptyStatus", "true");
		return new ModelAndView("editStatus", "status1", status1);
	}

	@RequestMapping("/submitEditStatus")
	public void submitEditStatus(@ModelAttribute("status") Status status,
			@RequestParam(value="status") String statusValue,
			HttpServletResponse response) throws IOException {
		String statusId = status.getEmpId() + status.getDate();
		Status st = new Status();
		st.setStatusId(statusId);
		st.setDate(status.getDate());
		st.setEmpId(status.getEmpId());
		st.setStatus(statusValue);
		System.out.println(st);
		iEmployeeService.editStatus(st);
		response.sendRedirect("viewStatus");
	}

	/* view status by date */
	@RequestMapping("/viewStatusByDate{id}")
	public ModelAndView viewStatusByDate(@PathVariable("id") long empId) {
		return new ModelAndView("viewStatusByDate");
	}

	/* Employee activities*/ 
	@RequestMapping("/empViewStatus")
	public ModelAndView empViewStatus(Model model, HttpSession session) {
		long id = (long) session.getAttribute("empId");

		return new ModelAndView("empViewStatus", "emp",
				iEmployeeService.getEmployeeById(id));
	}

	@RequestMapping("/viewByDate")
	public ModelAndView viewByDate() {
		return new ModelAndView("viewByDate");
	}

	@RequestMapping("/getDetailsByDate")
	public ModelAndView getDetailsByDate(
			@RequestParam("startDate") String sdate,
			@RequestParam("endDate") String edate, HttpSession session,
			HttpServletResponse response) throws IOException {
		long id =  (long) session.getAttribute("empId");
		List<Status> statusList = iEmployeeService.getDetailsByDate(sdate, edate, id);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if (statusList.isEmpty()) {
			System.out.println("s");

		}

		return new ModelAndView("viewByDate", "statusList", statusList);

	}

}
