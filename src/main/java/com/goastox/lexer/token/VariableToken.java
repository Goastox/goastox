package com.goastox.lexer.token;

public class VariableToken extends AbstractToken<Object>{
    public VariableToken(String lexeme, int line, int index) {
        super(lexeme, line, index);
    }

    @Override
    public TokenType getType() {
        return TokenType.Variable;
    }
}
