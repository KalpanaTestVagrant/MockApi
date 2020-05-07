package com.mock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mock.entities.Data;
import com.mock.entities.EmployeeResponse;
import com.mock.services.EmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockApiService.class)
public class DataApiMockTest {

        @Autowired
        private EmployeeService empService;
        @Autowired
        private RestTemplate restTemplate;

        private MockRestServiceServer mockServer;
        private ApiConfig config = new ApiConfig();
        private ObjectMapper mapper = new ObjectMapper();

        @Before
        public void init() {
            restTemplate = config.restTemplate();
            mockServer = MockRestServiceServer.createServer(restTemplate);
        }

        @Test
        public void givenMockingIsDoneByMockRestServiceServer_whenGetIsCalled_thenReturnsMockedObject() throws JsonProcessingException {
            Data empData = new Data("1", "Eric Simmons","1500","20","");
            EmployeeResponse employeeDetails = new EmployeeResponse();
            employeeDetails.setData(empData);
            employeeDetails.setSuccess("true");

            mockServer.expect(ExpectedCount.once(),requestTo("http://dummy.restapiexample.com/api/v1/employee/1"))  //http://localhost:8080/employee/E001
                    .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
                    .andRespond(withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                            .body(mapper.writeValueAsString(employeeDetails))
                    );

        EmployeeResponse employee = empService.getEmployee("1");
            mockServer.verify();
            Assert.assertEquals(employeeDetails, employee);
        }
}
