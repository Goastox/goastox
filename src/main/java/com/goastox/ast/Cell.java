package com.goastox.ast;

import com.goastox.lexer.token.Token;

public class Cell {

    private Cell left;

    private Sign sign;

    private Cell right;

    public Cell() {
    }

    public Cell(Sign sign) {
        this.sign = sign;
    }

    public Cell getLeft() {
        return left;
    }

    public void setLeft(Cell left) {
        this.left = left;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public Cell getRight() {
        return right;
    }

    public void setRight(Cell right) {
        this.right = right;
    }
}
