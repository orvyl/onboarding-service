package com.example.onboardingservice.payload;

import lombok.Data;

@Data
public class CreateAccountResponse {
    private String accountId;
    private String customerId;
    private Double currentBalance;
    private Double availableBalance;
}
