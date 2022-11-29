package com.example.onboardingservice.service;

import com.example.onboardingservice.payload.RegistrationRequest;
import com.example.onboardingservice.payload.RegistrationResponse;

public interface RegistrationService {
    public RegistrationResponse register(RegistrationRequest request) throws RegistrationServiceException;
}
