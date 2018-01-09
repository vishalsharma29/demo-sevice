package com.cdk.demoservice.controller;

public class DepartmentDto {

	private String departmentName;
	private HeadOfDepartmentDto headOfDepartmentDto;

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
}
