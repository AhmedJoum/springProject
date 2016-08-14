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
import com.Interface.Employee.services.EmployeeService;

@Controller
@EnableTransactionManagement
public class DepartmentController {
	private DepartmentService departmentService;

	@Autowired(required = true)
	@Qualifier(value = "DepartmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public String listDepartment(Model model) {
		model.addAttribute("department", new Department());
		model.addAttribute("listDepartments", this.departmentService.allDepartments());
		return "department";
	}

	@RequestMapping(value = "/department/add", method = RequestMethod.POST)
	public String addDepartment(@ModelAttribute("department") Department department) {
		if (department.getDep_id() == 0) {
			this.departmentService.addDepartment(department);
		} else {
			this.departmentService.updateDepartment(department);
		}
		return "redirect:/departments";
	}

	@RequestMapping(value = "/department/edit/{id}")
	public String editDeparment(@PathVariable("id") int dep_id, Model model) {
		model.addAttribute("department", this.departmentService.getDepartmentByID(dep_id));
		model.addAttribute("listDepartments", this.departmentService.allDepartments());
		return "department";
	}

	@RequestMapping(value = "/department/remove/{id}")
	public String removeDepartment(@PathVariable("id") int dep_id) {
		this.departmentService.deleteDepartment(dep_id);
		return "redirect:/departments";
	}

}
