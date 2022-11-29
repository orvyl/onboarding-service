package com.example.onboardingservice.controller;

import com.example.onboardingservice.payload.RegistrationRequest;
import com.example.onboardingservice.payload.RegistrationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("register")
public class RegistrationController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RegistrationResponse registerCustomer(@Valid @RequestBody RegistrationRequest request) {
        return null;
    }

}
