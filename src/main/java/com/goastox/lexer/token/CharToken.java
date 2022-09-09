package com.goastox.lexer.token;

public class CharToken extends AbstractToken<Character>{

    private final char ch;

    public CharToken(char ch, int line, int index) {
        super(String.valueOf(ch), line, index + 1);
        this.ch = ch;
    }

    @Override
    public TokenType getType() {
        return TokenType.Char;
    }
}
