package com.goastox.exception;

public class CompileExpressionErrorException extends ExpressionRuntimeException {
    public CompileExpressionErrorException() {
    }

    public CompileExpressionErrorException(String message) {
        super(message);
    }

    public CompileExpressionErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
