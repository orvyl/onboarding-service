package com.example.onboardingservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    //TODO
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "{customerId}")
    public void createAndLinkAccount(@PathVariable String customerId) {
        // create a AccountServiceImpl that calls POST createAccount using the `customerId` received here
    }

    //TODO
    @GetMapping(path = "{customerId}")
    public List<String> getAccountsById(@PathVariable String customerId) {
        return null;
    }
}
