package com.goastox.ast.decl;

import com.goastox.ast.Node;
import com.goastox.lexer.token.Token;

public class Declaration extends Node {

    private String name;

    private Token<?> token;

    private Node expr;


    public Declaration(Token token, String name) {
        super(token, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Token<?> getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Node getExpr() {
        return expr;
    }

    public void setExpr(Node expr) {
        this.expr = expr;
    }
}
