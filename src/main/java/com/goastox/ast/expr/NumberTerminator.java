package com.goastox.ast.expr;

import com.goastox.ast.Node;
import com.goastox.lexer.token.Token;

public class NumberTerminator extends Node {


    public NumberTerminator(Token token, String var) {
        super(token, var);
    }
}
