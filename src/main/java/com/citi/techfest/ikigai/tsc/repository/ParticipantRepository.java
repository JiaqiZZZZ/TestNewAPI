package com.citi.techfest.ikigai.tsc.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.citi.techfest.ikigai.tsc.entity.Foo;
import com.citi.techfest.ikigai.tsc.entity.Participant;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface ParticipantRepository extends CrudRepository<Participant, String> {
    List<Participant> findByName(String name);

    List<Participant> findByAssignedNavigator(String assignedNavigatorID);

    List<Participant> findByOrganizationNameAndServiceName(String orgName, String serviceName);
    List<Participant> findByRole(String role);

    List<Participant> findAll();
}
