package com.citi.techfest.ikigai.tsc.repository;
import com.citi.techfest.ikigai.tsc.entity.Navigator;
import com.citi.techfest.ikigai.tsc.entity.Participant;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableScan
public interface NavigatorRepository extends CrudRepository<Navigator, String> {
    List<Navigator> findAll();

}
