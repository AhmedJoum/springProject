package com.Interface.Employee.dao;

import java.util.List;

import org.apache.log4j.*;

import com.Interface.Employee.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement
public class EmployeeDAOImpl implements EmployeeDAO {
	

	private static final Logger log = Logger.getLogger(EmployeeDAO.class.getName());

	/**
	 * One Property is set on this class, <p> a <i>SessionFactory</i> type,
	 * which Autowired with it's bean in <i>servlet-context.xml</i> that named:
	 * <i>EmployeeService</i>.
	 *
	 */
	
	private SessionFactory sessionFactory;

	/**
	 * sets the mapped bean implementation class object for <i>SessionFactory</i>
	 * interface. 
	 */
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addEmloyee(Employee employee) {
		Session addSession = this.sessionFactory.getCurrentSession();
		addSession.persist(employee);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		Session updateSession = this.sessionFactory.getCurrentSession();
		updateSession.update(employee);
	}

	@Override
	@Transactional
	public List<Employee> allEmloyees() {
		Session allEmpSession = this.sessionFactory.getCurrentSession();
		List<Employee> EmployeeList = allEmpSession.createQuery("from emp").list();
		
		return EmployeeList;
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int emp_id) {
		Session employeeByIDSession = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) employeeByIDSession.load(Employee.class, new Integer(emp_id));
		log.debug("getEmployeeById : " + employee);
		
		return employee;
	}

	@Override
	@Transactional
	public void deleteEmployee(int emp_id) {
		Session deleteSession = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) deleteSession.load(Employee.class, new Integer(emp_id));
		if(employee != null){
			deleteSession.delete(employee);
		}
		//log 
	}

}
