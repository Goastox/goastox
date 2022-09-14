package com.goastox.ast.expr;

import com.goastox.ast.Node;

public class BinaryExpr extends Node {

    private Node left;

    private Node right;

    private Node operator;

    public BinaryExpr() {
        super(null, null);
    }


    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getOperator() {
        return operator;
    }

    public void setOperator(Node operator) {
        this.operator = operator;
    }
}
