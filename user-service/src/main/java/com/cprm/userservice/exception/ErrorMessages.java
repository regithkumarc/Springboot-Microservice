package com.cprm.userservice.exception;

public enum ErrorMessages {

    MISSING_REQUIRED_FIELDS("Missing Required Fields,Please check the documentation for Required Fields"),
    NO_DATA_FOUND("NO Data Found");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
