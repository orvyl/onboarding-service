package com.example.onboardingservice.service;

import com.example.onboardingservice.payload.CreateAccountRequest;
import com.example.onboardingservice.payload.CreateAccountResponse;
import com.example.onboardingservice.payload.CreateCustomerRequest;
import com.example.onboardingservice.payload.CreateCustomerResponse;
import com.example.onboardingservice.payload.RegistrationRequest;
import com.example.onboardingservice.payload.RegistrationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RestTemplate restTemplate;

    public RegistrationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public RegistrationResponse register(RegistrationRequest request) throws RegistrationServiceException {

        //call customer service
        CreateCustomerRequest body = new CreateCustomerRequest();
        body.setEmail(request.getEmail());
        body.setLastName(request.getLastName());
        body.setFirstName(request.getFirstName());
        body.setPassword(request.getPassword());
        body.setMiddleName(request.getMiddleName());
        body.setPermanentAddress(request.getPermanentAddress());
        body.setPresentAddress(request.getPresentAddress());

        ResponseEntity<CreateCustomerResponse> customerServiceResponse
                = restTemplate.postForEntity("http://localhost:8081/customer", body, CreateCustomerResponse.class);

        if (!customerServiceResponse.getStatusCode().equals(HttpStatus.CREATED)){
            throw new RegistrationServiceException("Failed to create customer: " + request.getEmail());
        }

        String customerId = customerServiceResponse.getBody().getCustomerId();

        //call account service
        ResponseEntity<CreateAccountResponse> accountServiceResponse
                = restTemplate.postForEntity("http://localhost:8082/account", new CreateAccountRequest(customerId), CreateAccountResponse.class);

        if (!accountServiceResponse.getStatusCode().equals(HttpStatus.CREATED)) {
            throw new RegistrationServiceException("Failed to create account for customer id: " + customerId);
        }

        String accountId = accountServiceResponse.getBody().getAccountId();

        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setCustomerId(customerId);
        registrationResponse.setAccountIds(Collections.singletonList(accountId));

        return registrationResponse;
    }
}
