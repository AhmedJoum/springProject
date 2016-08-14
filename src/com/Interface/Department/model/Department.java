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

import com.Interface.Employee.model.Employee;

/**
 * Contains the <i>Department</i> Component model, and all it's properties which
 * are Three: dep_id, dep_name, and depEmployees.
 * 
 * @author Ahmed A.Moniem Hassan
 */

@Entity(name = "dep")
public class Department {

	/**
	 * dep_id representing the Department ID property.
	 * 
	 * <ul>
	 * 		<li>Get Method : getDep_id</li>
	 * 		<li>Set Method : SetDep_id</li>
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
	 * 		<li>Get Method : getDep_name</li>
	 * 		<li>Set Method : SetDep_name</li>
	 * </ul>
	 */
	
	@Column(name = "dep_name")
	private String dep_name;
	@OneToMany (mappedBy="dep")
	private List<Employee> depEmployees;
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public List<Employee> getDepEmployees() {
		return depEmployees;
	}
	public void setDepEmployees(List<Employee> depEmployees) {
		this.depEmployees = depEmployees;
	}

	
}
