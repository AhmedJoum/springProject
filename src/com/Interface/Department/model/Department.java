/*
 * Copyright (c) 2016, Interface Company - Sudan and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package com.Interface.Department.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.apache.log4j.Logger;

import com.Interface.Employee.model.Employee;

/**
 * Contains the <i>Department</i> Component model, and all it's properties which
 * are Three: dep_id, dep_name, and depEmployees.
 * 
 * @author Ahmed A.Moniem Hassan
 */

@Entity(name = "dep")
public class Department {
	static Logger log = Logger.getLogger(Department.class.getName());

	/**
	 * dep_id representing the Department ID property.
	 * 
	 * <ul>
	 * <li>Get Method : getDep_id</li>
	 * <li>Set Method : SetDep_id</li>
	 * </ul>
	 */

	@Id
	@Column(name = "dep_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dep_id;

	/**
	 * dep_name representing the Department ID property.
	 * 
	 * <ul>
	 * <li>Get Method : getDep_name</li>
	 * <li>Set Method : SetDep_name</li>
	 * </ul>
	 */

	@Column(name = "dep_name")
	private String dep_name;

	/**
	 * depEmployees representing the Department ID property.
	 * 
	 * <ul>
	 * <li>Get Method : getDepEmployees</li>
	 * <li>Set Method : SetDepEmployees</li>
	 * </ul>
	 */

	@OneToMany(mappedBy = "dep")
	private List<Employee> depEmployees;

	/**
	 * Get the dep_id property value.
	 * 
	 * @return Integer dep_id
	 */

	public int getDep_id() {
		log.trace("get Dep_id = " + dep_id);
		return dep_id;
	}
	
	/**
	 * Set the dep_id property value.
	 * 
	 * @param Integer dep_id
	 */

	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
		log.trace("set dep_id = " + dep_id);
	}
	
	/**
	 * Get the dep_name property value.
	 * 
	 * @return String dep_name
	 */

	public String getDep_name() {
		log.trace("get dep_name = " + dep_name);
		return dep_name;
	}

	/**
	 * Set the dep_name property value.
	 * 
	 * @param String dep_name
	 */
	
	public void setDep_name(String dep_name) {
		log.trace("set dep_name = " + dep_name);
		this.dep_name = dep_name;
	}

	/**
	 * Get the depEmployees property value.
	 * 
	 * @return List of <i>Employee</i> depEmployees
	 */
	
	public List<Employee> getDepEmployees() {
		for (Employee e : depEmployees) {
			log.trace(" get department " + dep_name + " Employee : " + e);
		}
		return depEmployees;
	}

	/**
	 * Set the depEmployees property value.
	 * 
	 * @param List of <i>Employee</i> depEmployees
	 */
	
	public void setDepEmployees(List<Employee> depEmployees) {
		this.depEmployees = depEmployees;
		for (Employee e : depEmployees) {
			log.trace(" set department " + dep_name + " Employee : " + e);
		}
	}

}
