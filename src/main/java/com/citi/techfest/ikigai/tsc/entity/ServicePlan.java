package com.citi.techfest.ikigai.tsc.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.Data;

import java.time.LocalDate;

@Data
@DynamoDBDocument
public class ServicePlan {
    @DynamoDBHashKey(attributeName = "ServiceName")
    private String serviceName;
    @DynamoDBAttribute(attributeName = "OrganizationAddress")
    private String organizationAddress;
    @DynamoDBAttribute(attributeName = "ServiceCategory")
    private String serviceCategory;
    @DynamoDBRangeKey(attributeName="ServiceDate")
    private LocalDate serviceDate;
    @DynamoDBAttribute(attributeName = "ServiceStatus")
    private String serviceStatus;
    @DynamoDBAttribute(attributeName = "ServiceComments")
    private String serviceComments;
    @DynamoDBAttribute(attributeName = "ServiceFeedback")
    private String serviceFeedback;
    @DynamoDBAttribute(attributeName = "AssignedCaseWorker")
    private String assignedCaseWorker;
}
