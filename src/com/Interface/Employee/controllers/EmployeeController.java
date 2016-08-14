/*
 * Copyright (c) 2016, Interface Company - Sudan and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package com.Interface.Employee.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Interface.Department.services.DepartmentService;
import com.Interface.Employee.model.Employee;
import com.Interface.Employee.services.EmployeeService;

/**
 * This class contains of Mapping controlling methods which get and post HTTP 
 * requests for user's view. It is related to 'Employee' component, <p> It takes the 
 * Submitted url and compare with the given @RequestMapping on the class.
 * 
 * @author Ahmed A.Moniem Hassan 
 * @see    EmployeeService
 * @see    Employee
 * 
 */

@Controller
@EnableTransactionManagement
public class EmployeeController {
	
	/**
	 * One Property is set on this class, <p> a <i>EmployeeService</i> type,
	 * which Autowired with it's bean in <i>servlet-context.xml</i> that named:
	 * <i>EmployeeService</i>.
	 *
	 */

	private EmployeeService employeeService;
	
	/**
	 * sets the mapped bean implementation class object for <i>EmployeeService</i>
	 * inerface. 
	 */
	
	@Autowired(required = true)
	@Qualifier(value = "EmployeeService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/***/
	
	private DepartmentService departmentService;
	
	@Autowired(required = true)
	@Qualifier(value = "DepartmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	/**
	 * Handle <a><i>"/employees"<i></a> requested page, and added two model
	 * attributes to be send to the returned view.
	 * 
	 * <ul>
	 * 		<li><i>employee : </i> sets an empty <i>Employee</i> object, this 
	 * 			   object will be  filled by the user input.</li>
	 * 		<li><i>ListEmployees : </i> gets list off <i>Employee</i> objects, 
	 * 			   and send it to the view to be shown on table.</li>
	 * </ul>
	 * 
	 * @param  org.springframwork.ui.Model object. sets attributes that to be
	 *         reflected on the view.
	 * @return a string of the requested view name.
	 * */
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listOfDepartments", this.departmentService.allDepartments());
		model.addAttribute("listEmployees", this.employeeService.allEmloyees());
		return "employee";
	}
	
	/**
	 * Handle <a><i>"/employee/add"<i></a> requested page, it takes an 
	 * <i>Employee</i> object and check if it have an id = 0, that means it is
	 * a new Employee and be saved as a new record on database, else, it will 
	 * update the employee with requested <i>emp_id</i>
	 * 
	 * @param  <i>Employee</i> Object. which will be submitted from the view as
	 * 		   model attribute.
	 * @return a string for redirecting to <i>listEmployees</i> control method.
	 */
	
	// For add and update employee both
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee) {

		if (employee.getEmp_id() == 0) {
			// new employee, add it
			this.employeeService.addEmloyee(employee);
		} else {
			// existing employee, call update
			this.employeeService.updateEmployee(employee);
		}
		return "redirect:/employees";
	}
	
	/**
	 * Handle <a><i>"/employee/remove/{id}"<i></a> requested page, it takes an
	 * <i>emp_id</i> and remove it record from the database, by calling 
	 * <i>deleteEmployee</i> from  <i>employeeService</i> object.
	 * 
	 * @param  Integer emp_id. represent the id of the record that should be 
	 * 		   removed.
	 * @return a string for redirecting to <i>listEmployees</i> control method.
	 */
	
	@RequestMapping("/employee/remove/{id}")
	public String removeEmployee(@PathVariable("id") int emp_id) {

		this.employeeService.deleteEmployee(emp_id);
		return "redirect:/employees";
	}
	
	/**
	 * Handle <a><i>"/employee/edit/{id}"<i></a> requested page, it takes an
	 * <i>emp_id</i> and gets it's record with the submitted <i>Employee</i>
	 * object, and view it on the view to be modified by the user.
	 * It submit two model attributes for the view : 
	 * 
	 * <ul>
	 * 		<li><i>employee : </i> sets an <i>Employee</i> object, which contain
	 *             the employee data that requested by the submitted <i>emp_id.</i></li>
	 *             
	 * 		<li><i>ListEmployees : </i> gets list off <i>Employee</i> objects, 
	 * 			   and send it to the view to be shown on table.</li>
	 * </ul>
	 * @param   org.springframwork.ui.Model object. sets attributes that to be
	 *          reflected on the view.
	 * @param   Integer emp_id. represent the id of the record that should be 
	 * 		    edited.
	 * @return  a string of the requested view name.
	 */

	@RequestMapping("/employee/edit/{emp_id}")
	public String editEmployee(@PathVariable("emp_id") int emp_id, Model model) {
		model.addAttribute("employee", this.employeeService.getEmployeeById(emp_id));
		model.addAttribute("listEmployees", this.employeeService.allEmloyees());
		return "employee";
	}

}
