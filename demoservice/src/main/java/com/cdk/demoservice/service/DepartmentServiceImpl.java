package com.cdk.demoservice.service;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.demoservice.controller.DepartmentDto;
import com.cdk.demoservice.controller.HeadOfDepartmentDto;
import com.cdk.demoservice.domain.Department;
import com.cdk.demoservice.domain.HeadOfDepartment;
import com.cdk.demoservice.repository.DepartmentRepository;
import com.cdk.demoservice.repository.HeadOfDepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private HeadOfDepartmentRepository headOfDepartmentRepository;

	@Override
	public Department save(DepartmentDto departmentDto) {
		HeadOfDepartmentDto headOfDept = departmentDto.getHeadOfDepartmentDto();
		HeadOfDepartment headOfDepartment = new HeadOfDepartment(UUID.randomUUID().toString(), headOfDept.getName(),
				headOfDept.getAge(), Timestamp.valueOf(headOfDept.getDateOfJoining()));
		headOfDepartment = headOfDepartmentRepository.save(headOfDepartment);
		Department department = new Department();
		department.setDeptId(UUID.randomUUID().toString());
		department.setDepartmentName(departmentDto.getDepartmentName());
		department.setHeadOfDepartment(headOfDepartment.getId());
		return departmentRepository.save(department);
	}

	@Override
	public DepartmentDto findOne(String deptId) {
		Department dept = departmentRepository.findOne(deptId);
		HeadOfDepartment hod = headOfDepartmentRepository.findOne(dept.getHeadOfDepartment());
		DepartmentDto deptDto = new DepartmentDto(dept.getDeptId(), dept.getDepartmentName(),
				hod.toHeadOfDepartmentDto());
		return deptDto;
	}

}
