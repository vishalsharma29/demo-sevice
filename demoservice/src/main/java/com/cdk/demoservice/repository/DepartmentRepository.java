package com.cdk.demoservice.repository;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import com.cdk.demoservice.domain.Department;

//@EnableJpaRepositories
@EnableScan
public interface DepartmentRepository extends DynamoDBCrudRepository<Department, String> {

}
