package com.cdk.demoservice.service;

import com.cdk.demoservice.controller.DepartmentDto;
import com.cdk.demoservice.domain.Department;

public interface DepartmentService {

	Department save(DepartmentDto departmentDto);

	DepartmentDto findOne(String deptId);
}
