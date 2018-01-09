package com.cdk.demoservice.service;

import com.cdk.demoservice.controller.DepartmentDto;
import com.cdk.demoservice.domain.Department;

public interface DepartmentService {

	void save(DepartmentDto departmentDto);

	Department findOne(String deptId);
}
