package com.goastox.ast.expr;

import com.goastox.ast.Node;
import com.goastox.lexer.token.Token;

public class StringTerminator extends Node {

    public StringTerminator(Token token, String var) {
        super(token, var);
    }
}
