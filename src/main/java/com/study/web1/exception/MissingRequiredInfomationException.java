package com.study.web1.exception;

public class MissingRequiredInfomationException extends RuntimeException {

    public MissingRequiredInfomationException(String message) {
        super(message);
    }

    public MissingRequiredInfomationException(String message, Throwable cause) {
        super(message, cause);
    }
}
