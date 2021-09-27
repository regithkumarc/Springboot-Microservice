package com.cprm.userservice.exception;

import java.util.Date;

public class ErrorMessage {

    private int errorId;
    private String errorMessage;
    private Date timestamp;

    public ErrorMessage(int errorId, String errorMessage, Date timestamp) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }

    public int getErrorId() {
        return errorId;
    }

    public void setErrorId(int errorId) {
        this.errorId = errorId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
