package com.mock.services;

import com.mock.entities.Data;
import com.mock.entities.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

    @Service
    public class EmployeeService {

        @Autowired
        private RestTemplate restTemplate;

        public EmployeeResponse getEmployee(String id) {
            ResponseEntity resp =
                    restTemplate.getForEntity("http://dummy.restapiexample.com/api/v1/employee/" + id, EmployeeResponse.class);

            return resp.getStatusCode() == HttpStatus.OK ? (EmployeeResponse)resp.getBody() : null;
    }
}
