package com.study.web1.exception;

public class UnexpectedSqlResultException extends RuntimeException {

    public UnexpectedSqlResultException(String message) {
        super(message);
    }

    public UnexpectedSqlResultException(String message, Throwable cause) {
        super(message, cause);
    }
}
