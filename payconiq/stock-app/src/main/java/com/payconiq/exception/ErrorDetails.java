package com.payconiq.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Exception mapping class for proper error handling.
 */
public class ErrorDetails {


    private String message;
    private String errorId;
    private String details;
    private String timestamp;

    public ErrorDetails(String message, String errorId, String details) {
        this.message = message;
        this.errorId = errorId;
        this.details = details;
        this.timestamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }
}
