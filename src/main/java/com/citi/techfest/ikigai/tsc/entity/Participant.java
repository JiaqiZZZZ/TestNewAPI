package com.citi.techfest.ikigai.tsc.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@DynamoDBTable(tableName = "Participant")
public class Participant {

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBHashKey(attributeName = "Role")
    @DynamoDBAutoGeneratedKey
    private String role;

    @DynamoDBAttribute(attributeName = "Name")
    private String name;

    @DynamoDBAttribute(attributeName = "Gender")
    private String gender;

    @DynamoDBAttribute(attributeName = "ContactNumber")
    private String contactNumber;

    @DynamoDBAttribute(attributeName = "Email")
    private String email;

    @DynamoDBAttribute(attributeName = "DateOfBirth")
    private String dateOfBirth;

    //only used in beneficiary
    @DynamoDBAttribute(attributeName = "CabinNumber")
    private String cabinNumber;


    @DynamoDBAttribute(attributeName = "MoveInDate")
    private LocalDate moveInDate;

    @DynamoDBAttribute(attributeName = "Comments")
    private String comments;

    // used for caseworkers of an organization
    @DynamoDBAttribute(attributeName = "OrganizationName")
    private String organizationName;

    @DynamoDBAttribute(attributeName = "ServiceCategory")
    private String serviceCategory;

    @DynamoDBHashKey(attributeName = "ServiceName")
    private String serviceName;

    //used for assigned navigator
    @DynamoDBAttribute(attributeName = "AssignedNavigatorID")
    private String assignedNavigatorID;

    private List<ServicePlan> servicePlanList;

}
