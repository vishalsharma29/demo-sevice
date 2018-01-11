package com.cdk.demoservice.domain;

import java.sql.Timestamp;
import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class TimestampConverter implements DynamoDBTypeConverter<Date, Timestamp> {

	@Override
	public Date convert(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

	@Override
	public Timestamp unconvert(Date date) {
		return new Timestamp(date.getTime());
	}
}