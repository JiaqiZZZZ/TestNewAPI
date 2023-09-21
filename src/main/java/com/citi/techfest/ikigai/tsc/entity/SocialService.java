package com.citi.techfest.ikigai.tsc.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.time.LocalDate;

@Data
@DynamoDBTable(tableName = "SocialService")
public class SocialService {

    @DynamoDBRangeKey(attributeName = "OrganizationName")
    private String organizationName;

    @DynamoDBHashKey(attributeName = "ServiceName")
    private String serviceName;

    @DynamoDBAttribute(attributeName = "ServiceDescription")
    private String serviceDescription;

    @DynamoDBAttribute(attributeName = "ServiceAvailbility")
    private String serviceAvailbility;

    @DynamoDBAttribute(attributeName = "ServiceCategory")
    private String serviceCategory;

    @DynamoDBAttribute(attributeName = "OrganizationAddress")
    private String organizationAddress;
}
