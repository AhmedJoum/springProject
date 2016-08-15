package com.Interface.Employee.services;

import java.util.List;

import com.Interface.Employee.model.Employee;
import com.Interface.Employee.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService {
	
	/**
	 * One Property is set on this class, <p> a <i>EmployeeDAO</i> type,
	 * which Autowired with it's bean in <i>employee-context.xml</i> that named:
	 * <i>EmployeeService</i>.
	 *
	 */
	
	private EmployeeDAO employeeDAO;
	
	/**
	 * sets the mapped bean implementation class object for <i>EmployeeDAO</i>
	 * interface. 
	 */
	
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public void addEmloyee(Employee employee) {
		this.employeeDAO.addEmloyee(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		this.employeeDAO.updateEmployee(employee);
		
	}

	@Override
	public List<Employee> allEmloyees() {
		return this.employeeDAO.allEmloyees();
	}

	@Override
	public Employee getEmployeeById(int emp_id) {
		return this.employeeDAO.getEmployeeById(emp_id);
	}

	@Override
	public void deleteEmployee(int emp_id) {
		this.employeeDAO.deleteEmployee(emp_id);
		
	}

}
