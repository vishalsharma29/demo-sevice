package com.cdk.demoservice.repository;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import com.cdk.demoservice.domain.HeadOfDepartment;

//@EnableJpaRepositories
@EnableScan
public interface HeadOfDepartmentRepository extends DynamoDBCrudRepository<HeadOfDepartment, String> {

}
