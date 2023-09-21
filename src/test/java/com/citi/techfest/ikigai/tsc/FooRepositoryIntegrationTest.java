package com.citi.techfest.ikigai.tsc;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.citi.techfest.ikigai.tsc.entity.Foo;
import com.citi.techfest.ikigai.tsc.repository.FooRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TscApiApplication.class)
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = {
        "amazon.dynamodb.endpoint=https://dynamodb.us-east-2.amazonaws.com",
        "amazon.aws.accesskey=AKIA5K6HSESLW5JFPX6S",
        "amazon.aws.secretkey=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"})
public class FooRepositoryIntegrationTest {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    FooRepository fooRepository;

    private static final String EXPECTED_ID = "99";
    private static final String EXPECTED_NAME = "ikigai";
    private static final String EXPECTED_GENDER = "F";

    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

//        CreateTableRequest tableRequest = dynamoDBMapper
//                .generateCreateTableRequest(Foo.class);
//        tableRequest.setProvisionedThroughput(
//                new ProvisionedThroughput(1L, 1L));
//        amazonDynamoDB.createTable(tableRequest);

        dynamoDBMapper.batchDelete((List<Foo>) fooRepository.findAll());
    }

    @Test
    public void givenItemWithExpectedName_whenRunFindAll_thenItemIsFound() {
        Foo Foo = new Foo(EXPECTED_ID, EXPECTED_NAME, EXPECTED_GENDER);
        fooRepository.save(Foo);
        List<Foo> result = (List<Foo>) fooRepository.findAll();

        assertThat(result.size(), is(greaterThan(0)));
        assertThat(result.get(0).getName(), is(equalTo(EXPECTED_NAME)));
    }
}
