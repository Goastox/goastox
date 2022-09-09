package com.goastox.lexer.token;

import java.io.Serializable;

public class AbstractToken<T> implements Token<T>, Serializable {
    private String lexeme;

    private final int line;

    private final int index;


    public AbstractToken(String lexeme, int line, int index) {
        this.lexeme = lexeme;
        this.line = line;
        this.index = index - lexeme.length();
    }

    @Override
    public TokenType getType() {
        return null;
    }

    @Override
    public String getLexeme() {
        return null;
    }

    @Override
    public String toString() {
        return "[type='" + getType().name() + "',lexeme='" + lexeme + "',line=" + this.line +  "',index=" + this.index
                + "]";
    }
}
