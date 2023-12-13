package com.study.web1.exception;

public class InvaildEmailFormatException extends RuntimeException {

    public InvaildEmailFormatException(String message) {
        super(message);
    }

    public InvaildEmailFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
