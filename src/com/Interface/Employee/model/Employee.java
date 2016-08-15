/*
 * Copyright (c) 2016, Interface Company - Sudan and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package com.Interface.Employee.model;

import java.util.Iterator;
import java.util.List;

import com.Interface.Department.model.Department;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import org.hibernate.annotations.Generated;
import org.hibernate.exception.JDBCConnectionException;
import org.apache.log4j.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Contains the <i>Employee</i> Component model, and all it's properties which
 * are six: emp_id, emp_name, emp_email, emp_pos, emp_phone, emp_salary and dep
 * 
 * @author Ahmed A.Moniem Hassan
 */

@Entity(name = "emp")
public class Employee {
	static Logger log = Logger.getLogger(Employee.class.getName());

	/**
	 * emp_id representing the Employee ID property.
	 * 
	 * <ul>
	 * <li>Get Method : getEmp_id</li>
	 * <li>Set Method : SetEmp_id</li>
	 * </ul>
	 */

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;

	/**
	 * emp_name representing the Employee Name property.
	 * 
	 * <ul>
	 * <li>Get Method : getEmp_name</li>
	 * <li>Set Method : SetEmp_name</li>
	 * </ul>
	 */

	private String emp_name;

	/**
	 * emp_email representing the Employee Email property.
	 * 
	 * <ul>
	 * <li>Get Method : getEmp_email</li>
	 * <li>Set Method : SetEmp_email</li>
	 * </ul>
	 */

	private String emp_email;

	/**
	 * emp_pos representing the Employee Position property.
	 * 
	 * <ul>
	 * <li>Get Method : getEmp_pso</li>
	 * <li>Set Method : SetEmp_pos</li>
	 * </ul>
	 */

	private String emp_pos;

	/**
	 * emp_phone representing the Employee Phone property.
	 * 
	 * <ul>
	 * <li>Get Method : getEmp_phone</li>
	 * <li>Set Method : SetEmp_phone</li>
	 * </ul>
	 */

	private String emp_phone;

	/**
	 * emp_salary representing the Employee Salary property.
	 * 
	 * <ul>
	 * <li>Get Method : getEmp_salary</li>
	 * <li>Set Method : SetEmp_salary</li>
	 * </ul>
	 */

	private Float emp_salary;
	@ManyToOne
	@JoinColumn(name = "dep_id")
	private Department dep;

	public Employee() {
	}

	/* setters and getters */

	/**
	 * Get the emp_name property value.
	 * 
	 * @return String emp_name
	 */

	public String getEmp_name() {
		log.trace("Employee : get Emp_name = " + emp_name);
		return emp_name;
	}

	/**
	 * set emp_name property value.
	 * 
	 * @param String
	 *            emp_name
	 */

	public void setEmp_name(String emp_name) {
		log.trace("Employee : set Emp_name = " + emp_name);
		this.emp_name = emp_name;
	}

	/**
	 * Get the emp_email property value.
	 * 
	 * @return String emp_email
	 */

	public String getEmp_email() {
		log.trace("Employee : getEmp_email() used");
		return emp_email;
	}

	/**
	 * Set the emp_email property value.
	 * 
	 * @param String
	 *            emp_email
	 */

	public void setEmp_email(String emp_email) {
		log.trace("Employee : set Emp_email = " + emp_email);
		this.emp_email = emp_email;
	}

	/**
	 * Get the emp_pos property value.
	 * 
	 * @return String emp_pos
	 */

	public String getEmp_pos() {
		log.trace("Employee : get Emp_pos = " + emp_pos);
		return emp_pos;
	}

	/**
	 * Set the emp_pos property value.
	 * 
	 * @param String
	 *            emp_pos
	 */

	public void setEmp_pos(String emp_pos) {
		log.trace("Employee : set Emp_pos = " + emp_pos);
		this.emp_pos = emp_pos;
	}

	/**
	 * Get the emp_phone property value.
	 * 
	 * @return String emp_phone
	 */

	public String getEmp_phone() {
		log.trace("Employee : get Emp_phone = " + emp_phone);
		return emp_phone;
	}

	/**
	 * set the emp_phone property value.
	 * 
	 * @param String
	 *            emp_phone
	 */

	public void setEmp_phone(String emp_phone) {
		log.trace("Employee : set Emp_phone = " + emp_phone);
		this.emp_phone = emp_phone;
	}

	/**
	 * Get the emp_salary property value.
	 * 
	 * @return Float emp_salary
	 */

	public Float getEmp_salary() {
		log.trace("Employee : get Emp_salary = " + emp_salary);
		return emp_salary;
	}

	/**
	 * Set the emp_salary property value.
	 * 
	 * @param Float
	 *            emp_salary
	 */

	public void setEmp_salary(Float emp_salary) {
		log.trace("Employee : set Emp_salary = " + emp_salary);
		this.emp_salary = emp_salary;
	}

	/**
	 * Get the emp_id property value.
	 * 
	 * @return Integer emp_id
	 */

	public int getEmp_id() {
		log.trace("Employee : get Emp_id = " + emp_id);
		return emp_id;
	}

	/**
	 * set the emp_id property value.
	 * 
	 * @param Integer
	 *            emp_id
	 */

	public void setEmp_id(int emp_id) {
		log.trace("Employee : set Emp_id = " + emp_id);
		this.emp_id = emp_id;
	}

	/**
	 * Get the getDep property value.
	 * 
	 * @return Department getDep
	 */

	public Department getDep() {
		return dep;
	}

	/**
	 * set the getDep property value.
	 * 
	 * @param Department
	 *            getDep
	 */

	public void setDep(Department dep) {
		this.dep = dep;
	}

	/* end of getter and setters */

}
