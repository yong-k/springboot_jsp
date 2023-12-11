package com.study.web1.exception;

public class InvaildEmailFormatException extends RuntimeException {

    // 이거 생성자 2개 많이 사용함
    public InvaildEmailFormatException(String message) {
        super(message);
    }

    public InvaildEmailFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
