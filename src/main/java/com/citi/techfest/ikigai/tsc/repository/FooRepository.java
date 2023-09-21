package com.citi.techfest.ikigai.tsc.repository;

import com.citi.techfest.ikigai.tsc.entity.Foo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface FooRepository extends
        CrudRepository<Foo, String> {
    
    Optional<Foo> findById(String id);
}