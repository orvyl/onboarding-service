package com.example.onboardingservice.service;

public class RegistrationServiceException extends Exception {
    public RegistrationServiceException() {
        super();
    }

    public RegistrationServiceException(String message) {
        super(message);
    }

    public RegistrationServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistrationServiceException(Throwable cause) {
        super(cause);
    }

    protected RegistrationServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
