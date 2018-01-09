package com.cdk.demoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cdk.demoservice.domain.Department;

@EnableJpaRepositories
public interface DepartmentRepository extends JpaRepository<Department, String> {

}
