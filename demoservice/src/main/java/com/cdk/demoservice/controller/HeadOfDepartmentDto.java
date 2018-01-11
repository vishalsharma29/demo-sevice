package com.cdk.demoservice.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class HeadOfDepartmentDto {
	private String id;
	private String name;
	private int age;
	private String dateOfJoining;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public HeadOfDepartmentDto(String id, String name, int age, String dateOfJoining) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dateOfJoining = dateOfJoining;
	}

	public HeadOfDepartmentDto() {
	}
}
