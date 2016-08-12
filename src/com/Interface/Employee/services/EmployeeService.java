/*
 * Copyright (c) 2016, Interface Company - Sudan and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package com.Interface.Employee.services;

import java.util.List;

import com.Interface.Employee.model.Employee;

/**
 * Contains methods that works as adapter between Employee controller and DAO.
 * <p> It have  five main methods for: adding new Employee, update an Employee,
 *  gets all Employees, get Employee by ID and Delete an Employee. </p>
 *  
 *  @author Ahmed A.Moniem Hassan
 *  @see    EmployeeDAO
 */

public interface EmployeeService {
	
	/**
	 * Adding new Employee by taking an <i>Employee</i> object and submit it's
	 * properties value to saved as a record in database.
	 * 
	 * @param Employee object contains the data that must be saved.
	 */
	
	public void addEmloyee(Employee employee);
	
	/**
	 * Updating/Editing an Employee by taking an <i>Employee</i> object, take
	 * the given id property with the object to search for it's record in
	 * database, and change record data with other object properties value.
	 * 
	 * @param Employee object contains the data that must be updated.
	 */
	
	public void updateEmployee(Employee employee);
	
	/**
	 * Get all Employees from database.
	 *
	 * @return List of Employee Objects.
	 */

	public List<Employee> allEmloyees();
	
	/**
	 * Get Employee by the given Employee ID.
	 * 
	 *  @param Employee ID.
	 *  @return Employee Object.
	 */


	public Employee getEmployeeById(int emp_id);
	
	/**
	 * Delete Employee with the given Employee ID from database.
	 * 
	 * @param Employee ID.
	 */
	
	public void deleteEmployee (int emp_id);
}
