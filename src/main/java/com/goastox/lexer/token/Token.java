package com.goastox.lexer.token;

public interface Token<T> {

    enum TokenType {
        String, Variable, Number, Char
    }


    TokenType getType();

    String getLexeme();

}
