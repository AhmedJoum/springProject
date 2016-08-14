package com.Interface.Department.dao;

import java.util.List;

import com.Interface.Department.model.Department;

public interface DepartmentDAO {
	public void addDepartment(Department department);

	public void updateDepartment(Department department);

	public Department getDepartmentByID(int dep_id);

	public List<Department> allDepartments();
	
	public void deleteDepartment(int dep_id); 
}
