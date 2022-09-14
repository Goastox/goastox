package com.goastox.lexer.token;

public interface Token<T> {

    enum TokenType {
        String, Variable, Number, Char, Operator
    }


    TokenType getType();

    String getLexeme();

    Integer getLine();

    Integer getIndex();

}
