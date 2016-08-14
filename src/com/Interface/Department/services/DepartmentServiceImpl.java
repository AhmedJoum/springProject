package com.Interface.Department.services;

import java.util.List;

import com.Interface.Department.dao.DepartmentDAO;
import com.Interface.Department.model.Department;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDAO departmentDAO;

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
