package com.goastox.ast;

import com.goastox.lexer.token.Token;

// 符号
public class Sign<T> {
    private String var;

    private Token<T> token;

    public Sign(String var, Token<T> token) {
        this.var = var;
        this.token = token;
    }

    public Token<T> getToken() {
        return token;
    }

    public void setToken(Token<T> token) {
        this.token = token;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }
}
