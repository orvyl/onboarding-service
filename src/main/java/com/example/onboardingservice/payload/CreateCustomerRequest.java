package com.example.onboardingservice.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateCustomerRequest {
    @NotEmpty
    private String email;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;
    private String middleName;

    @NotEmpty
    private String presentAddress;
    private String permanentAddress;

    private String password;
}
