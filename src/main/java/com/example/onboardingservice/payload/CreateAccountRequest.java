package com.example.onboardingservice.payload;

import lombok.Data;

@Data
public class CreateAccountRequest {

    public CreateAccountRequest(String customerId) {
        this.customerId = customerId;
    }

    public CreateAccountRequest() {
    }

    private String customerId;
}
