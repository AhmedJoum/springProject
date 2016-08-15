/*
 * Copyright (c) 2016, Interface Company - Sudan and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package com.Interface.Department.services;

import java.util.List;

import com.Interface.Department.dao.DepartmentDAO;
import com.Interface.Department.model.Department;

/**
 * Contains methods that works as adapter between Department controller and DAO.
 * <p> It have  five main methods for: adding new Department, update an Department,
 *  gets all Departments, get Department by ID and Delete an Department. </p>
 *  
 *  @author Ahmed A.Moniem Hassan
 *  @see    DepartmentDAO
 */

public interface DepartmentService {
	
	/**
	 * Adding new Department by taking an <i>Department</i> object and submit it's
	 * properties value to saved as a record in database.
	 * 
	 * @param Department object contains the data that must be saved.
	 */
	
	public void addDepartment(Department department);
	
	/**
	 * Updating/Editing an Department by taking an <i>Department</i> object, take
	 * the given id property with the object to search for it's record in
	 * database, and change record data with other object properties value.
	 * 
	 * @param Department object contains the data that must be updated.
	 */
	

	public void updateDepartment(Department department);
	
	/**
	 * Get Department by the given Department ID.
	 * 
	 *  @param Department ID.
	 *  @return Department Object.
	 */

	public Department getDepartmentByID(int dep_id);
	
	
	/**
	 * Get all Departments from database.
	 *
	 * @return List of Department Objects.
	 */

	public List<Department> allDepartments();
	
	/**
	 * Delete Department with the given Department ID from database.
	 * 
	 * @param Department ID.
	 */
	
	public void deleteDepartment(int dep_id); 

}
