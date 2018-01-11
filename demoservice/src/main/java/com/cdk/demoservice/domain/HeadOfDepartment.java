package com.cdk.demoservice.domain;

import java.sql.Timestamp;
import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.cdk.demoservice.controller.HeadOfDepartmentDto;

//@Table
//@Entity
@DynamoDBTable(tableName = "demoservice_headofdepartment")
public class HeadOfDepartment {

	// @Id
	// @Column
	@DynamoDBHashKey
	private String id;

	// @Column
	@DynamoDBAttribute
	private String name;

	// @Column
	@DynamoDBAttribute
	private int age;

	@DynamoDBAttribute
	@DynamoDBTypeConverted(converter = TimestampConverter.class)
	private Timestamp dateOfJoining;

	public HeadOfDepartment() {

	}

	public HeadOfDepartment(String id, String name, int age, Timestamp dateOfJoining) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dateOfJoining = dateOfJoining;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public Timestamp getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Timestamp dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public HeadOfDepartmentDto toHeadOfDepartmentDto() {
		return new HeadOfDepartmentDto(id, name, age, dateOfJoining.toString());
	}
}
