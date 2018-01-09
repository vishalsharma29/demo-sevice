package com.cdk.demoservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cdk.demoservice.domain.Department;
import com.cdk.demoservice.service.DepartmentService;

@RestController
public class DataController {

	@Autowired
	private DepartmentService departmentService;

	Logger log = LoggerFactory.getLogger(DataController.class);

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void upload(@RequestBody DepartmentDto departmentDto) {
		departmentService.save(departmentDto);
	}

	@RequestMapping(value = "/department/{deptId}", method = RequestMethod.GET)
	public Department getDepartment(@PathVariable(value = "deptId") String deptId) {
		return departmentService.findOne(deptId);
	}
}
