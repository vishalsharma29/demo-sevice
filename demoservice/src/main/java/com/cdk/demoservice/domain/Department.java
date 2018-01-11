package com.cdk.demoservice.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="demoservice_department")
public class Department {

    @DynamoDBHashKey
	private String deptId;

//	@Column
    @DynamoDBAttribute
	private String departmentName;
	
//	@OneToOne
//	@JoinColumn(name="employeeId", referencedColumnName="id")
	@DynamoDBAttribute
	private String headOfDepartment;

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


	public String getHeadOfDepartment() {
		return headOfDepartment;
	}


	public void setHeadOfDepartment(String headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}

	
}
