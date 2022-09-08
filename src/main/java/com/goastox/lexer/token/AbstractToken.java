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
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"lexeme\":\"")
                .append(lexeme).append('\"');
        sb.append(",\"line\":")
                .append(line);
        sb.append(",\"index\":")
                .append(index);
        sb.append('}');
        return sb.toString();
    }
}
