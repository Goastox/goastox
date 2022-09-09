package com.goastox.lexer.token;

public class NumberToken extends AbstractToken<Number>{
    public NumberToken(String lexeme, int line, int index) {
        super(lexeme, line, index);
    }

    @Override
    public TokenType getType() {
        return TokenType.Number;
    }
}
