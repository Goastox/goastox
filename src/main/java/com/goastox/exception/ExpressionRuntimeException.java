package com.goastox.exception;

public class ExpressionRuntimeException extends RuntimeException{
    public ExpressionRuntimeException() {
        super();
    }

    public ExpressionRuntimeException(String message) {
        super(message);
    }

    public ExpressionRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
