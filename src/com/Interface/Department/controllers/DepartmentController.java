/*
 * Copyright (c) 2016, Interface Company - Sudan and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package com.Interface.Department.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Interface.Department.model.Department;
import com.Interface.Department.services.DepartmentService;
import com.Interface.Employee.model.Employee;
import com.Interface.Employee.services.EmployeeService;

/**
 * This class contains of Mapping controlling methods which get and post HTTP 
 * requests for user's view. It is related to 'Department' component, <p> It takes the 
 * Submitted url and compare with the given @RequestMapping on the class.
 * 
 * @author Ahmed A.Moniem Hassan 
 * @see    EmployeeService
 * @see    Employee
 * 
 */

@Controller
@EnableTransactionManagement
public class DepartmentController {
	
	/**
	 * One Property is set on this class, <p> a <i>departmentService</i> type,
	 * which Autowired with it's bean in <i>department-context.xml</i> that named:
	 * <i>DepartmentService</i>.
	 */
	
	private DepartmentService departmentService;

	/**
	 * sets the mapped bean implementation class object for <i>DepartmentService</i>
	 * interface. 
	 */
	
	@Autowired(required = true)
	@Qualifier(value = "DepartmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	/**
	 * Handle <a><i>"/Departments"<i></a> requested page, and added two model
	 * attributes to be send to the returned view.
	 * 
	 * <ul>
	 * 		<li><i>Department : </i> sets an empty <i>Department</i> object, this 
	 * 			   object will be  filled by the user input.</li>
	 * 		<li><i>ListDepartments : </i> gets list off <i>Department</i> objects, 
	 * 			   and send it to the view to be shown on table.</li>
	 * </ul>
	 * 
	 * @param  org.springframwork.ui.Model object. sets attributes that to be
	 *         reflected on the view.
	 * @return a string of the requested view name.
	 * */

	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public String listDepartment(Model model) {
		model.addAttribute("department", new Department());
		model.addAttribute("listDepartments", this.departmentService.allDepartments());
		return "department";
	}

	/**
	 * Handle <a><i>"/Department/add"<i></a> requested page, it takes an 
	 * <i>Department</i> object and check if it have an id = 0, that means it is
	 * a new Department and be saved as a new record on database, else, it will 
	 * update the Department with requested <i>emp_id</i>
	 * 
	 * @param  <i>Department</i> Object. which will be submitted from the view as
	 * 		   model attribute.
	 * @return a string for redirecting to <i>listDepartments</i> control method.
	 */
	
	
	@RequestMapping(value = "/department/add", method = RequestMethod.POST)
	public String addDepartment(@ModelAttribute("department") Department department) {
		if (department.getDep_id() == 0) {
			this.departmentService.addDepartment(department);
		} else {
			this.departmentService.updateDepartment(department);
		}
		return "redirect:/departments";
	}

	/**
	 * Handle <a><i>"/department/edit/{id}"<i></a> requested page, it takes an
	 * <i>emp_id</i> and gets it's record with the submitted <i>Department</i>
	 * object, and view it on the view to be modified by the user.
	 * It submit two model attributes for the view : 
	 * 
	 * <ul>
	 * 		<li><i>Department : </i> sets an <i>Department</i> object, which contain
	 *             the Department data that requested by the submitted <i>emp_id.</i></li>
	 *             
	 * 		<li><i>ListDepartments : </i> gets list off <i>Department</i> objects, 
	 * 			   and send it to the view to be shown on table.</li>
	 * </ul>
	 * @param   org.springframwork.ui.Model object. sets attributes that to be
	 *          reflected on the view.
	 * @param   Integer dep_id. represent the id of the record that should be 
	 * 		    edited.
	 * @return  a string of the requested view name.
	 */

	
	@RequestMapping(value = "/department/edit/{id}")
	public String editDeparment(@PathVariable("id") int dep_id, Model model) {
		model.addAttribute("department", this.departmentService.getDepartmentByID(dep_id));
		model.addAttribute("listDepartments", this.departmentService.allDepartments());
		return "department";
	}

	/**
	 * Handle <a><i>"/Department/remove/{id}"<i></a> requested page, it takes an
	 * <i>emp_id</i> and remove it record from the database, by calling 
	 * <i>deleteDepartment</i> from  <i>DepartmentService</i> object.
	 * 
	 * @param  Integer dep_id. represent the id of the record that should be 
	 * 		   removed.
	 * @return a string for redirecting to <i>listDepartments</i> control method.
	 */
	
	@RequestMapping(value = "/department/remove/{id}")
	public String removeDepartment(@PathVariable("id") int dep_id) {
		this.departmentService.deleteDepartment(dep_id);
		return "redirect:/departments";
	}

}
