package com.goastox.lexer.token;

public class VariableToken extends AbstractToken<Object>{
    public VariableToken(String lexeme, int line, int index) {
        super(lexeme, line, index);
    }

    @Override
    public TokenType getType() {
        return TokenType.Variable;
    }

    public static final VariableToken FUNCTION = new VariableToken("function", 0, -1);

    public static final VariableToken TRUE = new VariableToken("true", 0, -1);
    public static final VariableToken FALSE = new VariableToken("false", 0, -1);
    public static final VariableToken IF = new VariableToken("if", 0, -1);
    public static final VariableToken ELSE = new VariableToken("else", 0, -1);

    public static final VariableToken FOR = new VariableToken("for", 0, -1);

    public static final VariableToken WHILE = new VariableToken("while", 0, -1);

    public static final VariableToken SWITCH = new VariableToken("switch", 0, -1);
    public static final VariableToken CASE = new VariableToken("case", 0, -1);

    public static final VariableToken BREAK = new VariableToken("break", 0, -1);
    public static final VariableToken CONTINUE = new VariableToken("continue", 0, -1);
    public static final VariableToken DEFAULT = new VariableToken("default", 0, -1);

}
