package com.cdk.demoservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity
public class Department {

	@Id
	@Column
	private String deptId;

	@Column
	private String departmentName;
	
	@OneToOne
	@JoinColumn(name="employeeId", referencedColumnName="id")
	private HeadOfDepartment headOfDepartment;

	public String getDeptId() {
		return deptId;
	}


	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public HeadOfDepartment getHeadOfDepartment() {
		return headOfDepartment;
	}


	public void setHeadOfDepartment(HeadOfDepartment headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}

	
}
