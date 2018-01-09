package com.cdk.demoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cdk.demoservice.domain.HeadOfDepartment;

@EnableJpaRepositories
public interface HeadOfDepartmentRepository extends JpaRepository<HeadOfDepartment, String> {

}
