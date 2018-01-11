package com.cdk.demoservice;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.services.dynamodbv2.model.TableStatus;
import com.cdk.demoservice.domain.Department;

@Component
public class InitTables {

	@Autowired
	private AmazonDynamoDB amazonDynamoDB;

	@Autowired
	private DynamoDBMapper dynamoDBMapper;

	private static final String ACTIVE = TableStatus.ACTIVE.toString();

	@PostConstruct
	void initTable() {
		Class<Department> claz = Department.class;
		if (!tableExisted(claz)) {
			createTable(claz);
			// deleteTable(claz);
		}
	}

	public CreateTableResult createTable(Class<?> clazz) {
		CreateTableResult createTableResult;
		try {
			if (amazonDynamoDB.listTables().getTableNames().contains(getTableName(clazz))) {
				throw new AmazonClientException("Table already exists");
			}
			CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(clazz);
			tableRequest.setProvisionedThroughput(new ProvisionedThroughput(5L, 5L));
			createTableResult = amazonDynamoDB.createTable(tableRequest);
			int count = 0;
			while (!ACTIVE.equals(getTableDescription(clazz).getTableStatus())) {
				count++;
				Thread.sleep(1000);
				if (count > 5) {
					throw new AmazonClientException("Creating table, Connection error");
				}
			}
			createTableResult.setTableDescription(getTableDescription(clazz));
		} catch (Exception e) {
			throw new AmazonClientException("Table create error: " + e.getMessage(), e);
		}
		return createTableResult;
	}

	public DeleteTableResult deleteTable(Class<?> clazz) {
		DeleteTableResult deleteTableResult;
		try {
			DeleteTableRequest deleteTableRequest = dynamoDBMapper.generateDeleteTableRequest(clazz);

			deleteTableResult = amazonDynamoDB.deleteTable(deleteTableRequest);
			int count = 0;
			while (tableExisted(clazz)) {
				count++;
				Thread.sleep(1000);
				if (count > 20) {
					throw new AmazonClientException("Deleting table, Connection error");
				}
			}
		} catch (Exception e) {
			throw new AmazonClientException("delete table error: " + e.getMessage(), e);
		}
		return deleteTableResult;
	}

	public List<String> getAllTables() {
		return amazonDynamoDB.listTables().getTableNames();
	}

	public TableDescription getTableDescription(Class<?> clazz) {
		TableDescription tableDescription;
		try {
			DynamoDBTable dynamoDBTable = clazz.getAnnotation(DynamoDBTable.class);
			tableDescription = amazonDynamoDB.describeTable(dynamoDBTable.tableName()).getTable();
		} catch (Exception e) {
			throw new AmazonClientException("Table does not exist: " + e.getMessage(), e);
		}
		return tableDescription;
	}

	public boolean tableExisted(Class<?> clazz) {
		try {
			getTableDescription(clazz);
		} catch (RuntimeException e) {
			if (e.getMessage().startsWith("Table does not exist"))
				return false;
		}
		return true;
	}

	public String getTableName(Class<?> clazz) {
		return clazz.getAnnotation(DynamoDBTable.class).tableName();

	}
}
