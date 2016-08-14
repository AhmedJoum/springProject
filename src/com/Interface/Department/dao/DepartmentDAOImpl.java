package com.Interface.Department.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.Interface.Department.model.Department;

@EnableTransactionManagement
public class DepartmentDAOImpl implements DepartmentDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addDepartment(Department department) {
		Session addSession = this.sessionFactory.getCurrentSession();
		addSession.persist(department);
	}

	@Override
	@Transactional
	public void updateDepartment(Department department) {
		Session updateSession = this.sessionFactory.getCurrentSession();
		updateSession.update(department);
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public Department getDepartmentByID(int dep_id) {
		Session DepartmetnByIDSession = this.sessionFactory.getCurrentSession();
		Department department = (Department) DepartmetnByIDSession.load(Department.class, new Integer(dep_id));

		return department;
	}

	@Override
	@Transactional
	public List<Department> allDepartments() {
		Session allDepSession = this.sessionFactory.getCurrentSession();
		List<Department> DepartmentslList = allDepSession.createQuery("from dep").list();

		return DepartmentslList;
	}

	@Override
	@Transactional
	public void deleteDepartment(int dep_id) {
		Session deleteSession = this.sessionFactory.getCurrentSession();
		Department department = (Department) deleteSession.load(Department.class, new Integer(dep_id));
		if (department != null) {
			deleteSession.delete(department);
		}
	}

}
