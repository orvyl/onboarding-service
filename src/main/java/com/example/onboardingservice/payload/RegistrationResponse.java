package com.example.onboardingservice.payload;

import lombok.Data;

import java.util.List;

@Data
public class RegistrationResponse {
    private String customerId;
    private List<String> accountIds;
}
