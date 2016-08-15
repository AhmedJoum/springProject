/*
 * Copyright (c) 2016, Interface Company - Sudan and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package com.Interface.Department.services;

import java.util.List;

import com.Interface.Department.dao.DepartmentDAO;
import com.Interface.Department.model.Department;

public class DepartmentServiceImpl implements DepartmentService {
	
	/**
	 * One Property is set on this class, <p> a <i>DepartmentDAO</i> type,
	 * which Autowired with it's bean in <i>department-context.xml</i> that named:
	 * <i>EmployeeService</i>.
	 *
	 */
	
	private DepartmentDAO departmentDAO;
	
	/**
	 * sets the mapped bean implementation class object for <i>DepartmentDAO</i>
	 * interface. 
	 */

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	@Override
	public void addDepartment(Department department) {
		this.departmentDAO.addDepartment(department);

	}

	@Override
	public void updateDepartment(Department department) {
		this.departmentDAO.updateDepartment(department);

	}

	@Override
	public Department getDepartmentByID(int dep_id) {
		return this.departmentDAO.getDepartmentByID(dep_id);
	}

	@Override
	public List<Department> allDepartments() {
		return this.departmentDAO.allDepartments();
	}

	@Override
	public void deleteDepartment(int dep_id) {
		this.departmentDAO.deleteDepartment(dep_id);

	}

}
