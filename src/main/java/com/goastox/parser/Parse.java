package com.goastox.parser;

import com.alibaba.fastjson2.JSON;
import com.goastox.ast.Node;
import com.goastox.ast.Method;
import com.goastox.ast.decl.Declaration;
import com.goastox.ast.expr.BinaryExpr;
import com.goastox.ast.expr.NumberTerminator;
import com.goastox.ast.expr.StringTerminator;
import com.goastox.io.Handler;
import com.goastox.lexer.Lexer;
import com.goastox.lexer.token.Token;
import com.goastox.lexer.token.Token.TokenType;
import com.goastox.lexer.token.VariableToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parse {

    private final List<Token<?>> token;


    public Parse(List<Token<?>> token) {
        this.token = token;
        this.currentToken = token.get(0);
    }

    private Token<?> currentToken;

    private int index = 0;
    private void next(){
        this.currentToken = token.get(++ index);
    }

    public static void main(String[] args) throws Exception {
        String init = new Handler("/Users/konghanghang/goastox/src/main/java/com/goastox/io/r.txt").init();
        Lexer lexer = new Lexer(init);
        lexer.scan();
        lexer.getTokens().stream().forEach(System.out::println);
        Parse parse = new Parse(lexer.getTokens());
        parse.statement();

    }

    private void statement(){
        if (currentToken == VariableToken.IF){

        } else if (currentToken == VariableToken.FOR) {

        }else if (currentToken == VariableToken.WHILE){

        } else if (currentToken == VariableToken.SWITCH) {

        } else if (currentToken == VariableToken.FUNCTION) {
            next();
            parse_fun();
        }else {
            if (currentToken.getType() == TokenType.String){
                Declaration declaration = new Declaration(currentToken, currentToken.getLexeme());
                declaration.setToken(currentToken);
                next();
                if(currentToken.getLexeme().equals("=")){
                    next();
                    Node expr = expr();
                    declaration.setExpr(expr);
                    System.out.println(JSON.toJSONString(declaration));
                }
            }
        }
    }

    private Node expr(){
        return expr_tail(term());
    }

    private Node term(){
        return term_tail(factor());
    }

    private Node expr_tail(Node expr){
        if ("+".equals(currentToken.getLexeme()) || "-".equals(currentToken.getLexeme())) {
            BinaryExpr binaryExpr = new BinaryExpr();
            binaryExpr.setOperator(new Node(currentToken, currentToken.getLexeme()));
            binaryExpr.setLeft(expr);
            next();
            binaryExpr.setRight(term());
            return expr_tail(binaryExpr);
        }
        return expr;
    }

    private Node term_tail(Node expr){
        if ("*".equals(currentToken.getLexeme()) || "/".equals(currentToken.getLexeme())){
            BinaryExpr binaryExpr = new BinaryExpr();
            binaryExpr.setOperator(new Node(currentToken, currentToken.getLexeme()));
            binaryExpr.setLeft(expr);
            next();
            binaryExpr.setRight(factor());
            return term_tail(binaryExpr);
        }
        return expr;
    }
    private Node factor(){
        if("(".equals(currentToken.getLexeme())){
            next();
            Node expr = expr();
            if (")".equals(currentToken.getLexeme())){
                next();
            }
            return expr;
        }else {
            Node expr = null;
            if (currentToken.getType() == TokenType.Number){
                expr =  new NumberTerminator(currentToken, currentToken.getLexeme());
            } else if (currentToken.getType() == TokenType.String) {
                expr =  new StringTerminator(currentToken, currentToken.getLexeme());
            }
            next();
            return expr;
        }
    }


    private void parse_fun(){
        Method method = new Method();
        fun_return(method);

        // =
        if(currentToken.getLexeme().equals("=")){
            next();
        }
        // 函数名
        method.setName(currentToken.getLexeme());
        next();
        // 入参
        fun_arg(method);
        if(currentToken.getLexeme().equals("{")){
            next();
        }
        if (!currentToken.getLexeme().equals("}")){
            parse_exp();
        }

    }

    private void parse_exp(){

    }

    // 判断返回值
    private void fun_return(Method method){
        if (currentToken.getLexeme().equals("void")){
            method.setReturnType(null);
        }else if (currentToken.getType() == Token.TokenType.String){
            method.setReturnType(Arrays.asList(currentToken.getLexeme()));
        } else{
            if(currentToken.getLexeme().equals("[")){
                ArrayList<String> strings = new ArrayList<>();
                for (;;){
                    next();
                    if(currentToken.getLexeme().equals("]")){
                        break;
                    }
                    if(currentToken.getLexeme().equals(",")){
                        continue;
                    }
                    strings.add(currentToken.getLexeme());
                }
                method.setReturnType(strings);
            }
        }
        next();
    }

    private void fun_arg(Method method){
        if (currentToken.getLexeme().equals("(")){
            ArrayList<String> strings = new ArrayList<>();
            for (;;){
                next();
                if(currentToken.getLexeme().equals(")")){
                    break;
                }
                if(currentToken.getLexeme().equals(",")){
                    continue;
                }
                strings.add(currentToken.getLexeme());
            }
            method.setArgumentList(strings);
        }
        next();
    }

}
