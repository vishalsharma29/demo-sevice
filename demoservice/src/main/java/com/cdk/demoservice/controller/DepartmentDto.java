package com.cdk.demoservice.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class DepartmentDto {
	private String deptId;

	private String departmentName;

	@JsonProperty(value = "headOfDepartment")
	private HeadOfDepartmentDto headOfDepartmentDto;

	public DepartmentDto(String deptId, String departmentName, HeadOfDepartmentDto headOfDepartmentDto) {
		this.deptId = deptId;
		this.departmentName = departmentName;
		this.headOfDepartmentDto = headOfDepartmentDto;
	}
	public DepartmentDto() {
	}
	public HeadOfDepartmentDto getHeadOfDepartmentDto() {
		return headOfDepartmentDto;
	}

	public void setHeadOfDepartmentDto(HeadOfDepartmentDto headOfDepartmentDto) {
		this.headOfDepartmentDto = headOfDepartmentDto;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
}
