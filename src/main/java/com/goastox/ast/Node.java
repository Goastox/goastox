package com.goastox.ast;

import com.goastox.lexer.token.Token;

public class Node<T> {

    private Token<T> token;

    private String var;

    public Node(Token<T> token, String var) {
        this.token = token;
        this.var = var;
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
