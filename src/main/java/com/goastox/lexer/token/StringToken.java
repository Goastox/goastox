package com.goastox.lexer.token;

public class StringToken extends AbstractToken<java.lang.String>{
    public StringToken(String lexeme, int line, int index) {
        super(lexeme, line, index);
    }
}
