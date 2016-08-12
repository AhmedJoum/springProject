package com.Interface.Employee.model;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Column;
import org.hibernate.annotations.Generated;
import org.hibernate.exception.JDBCConnectionException;
import org.apache.log4j.*;

import javax.persistence.Id;

@Entity(name = "emp")
public class Employee {
	static Logger log = Logger.getLogger(Employee.class.getName());

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	private String emp_name; 
	private String emp_email; 
	private String emp_pos; 
	private String emp_phone;
	private Float emp_salary;
	private int dep_id;

	public Employee() {
	}

	/* setters and getters */

	public String getEmp_name() {
		log.trace("Employee : get Emp_name = " + emp_name);
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		log.trace("Employee : set Emp_name = " + emp_name);
		this.emp_name = emp_name;
	}

	public String getEmp_email() {
		log.trace("Employee : getEmp_email() used");
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		log.trace("Employee : set Emp_email = " + emp_email);
		this.emp_email = emp_email;
	}

	public String getEmp_pos() {
		log.trace("Employee : get Emp_pos = " + emp_pos);
		return emp_pos;
	}

	public void setEmp_pos(String emp_pos) {
		log.trace("Employee : set Emp_pos = " + emp_pos);
		this.emp_pos = emp_pos;
	}

	public String getEmp_phone() {
		log.trace("Employee : get Emp_phone = " + emp_phone);
		return emp_phone;
	}

	public void setEmp_phone(String emp_phone) {
		log.trace("Employee : set Emp_phone = " + emp_phone);
		this.emp_phone = emp_phone;
	}

	public Float getEmp_salary() {
		log.trace("Employee : get Emp_salary = " + emp_salary);
		return emp_salary;
	}

	public void setEmp_salary(Float emp_salary) {
		log.trace("Employee : set Emp_salary = " + emp_salary);
		this.emp_salary = emp_salary;
	}

	public int getEmp_id() {
		log.trace("Employee : get Emp_id = " + emp_id);
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		log.trace("Employee : set Emp_id = " + emp_id);
		this.emp_id = emp_id;
	}

	/* end of getter and setters */

}
