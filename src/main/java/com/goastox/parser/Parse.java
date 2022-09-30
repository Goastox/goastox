package com.goastox.parser;

import com.alibaba.fastjson2.JSON;
import com.goastox.ast.Cell;
import com.goastox.ast.Sign;
import com.goastox.ast.Method;
import com.goastox.ast.expression.Assign;
import com.goastox.io.Handler;
import com.goastox.lexer.Lexer;
import com.goastox.lexer.token.Token;
import com.goastox.lexer.token.Token.TokenType;
import com.goastox.lexer.token.VariableToken;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
                Cell assign = new Assign();
                assign.setLeft(new Cell(new Sign(currentToken.getLexeme(), currentToken)));
                next();
                if(currentToken.getLexeme().equals("=")){
                    assign.setSign(new Sign<>(currentToken.getLexeme(), currentToken));
                    next();
                    Cell expr = expr();
                    assign.setRight(expr);
                    System.out.println(JSON.toJSONString(assign));
                    aaa(expr);
                    list.stream().forEach(System.out::println);



                }
            }
        }
    }
    private List<String> list = new LinkedList<>();

    public void aaa(Cell cell){
        if(cell != null){
            aaa(cell.getLeft());
            aaa(cell.getRight());
            String var = cell.getSign().getVar();
            switch (cell.getSign().getToken().getType()){
                case Number:
                    list.add("sipush " + String.format("%08x", Integer.parseInt(var)));
                    break;
                case Char:
                    switch (cell.getSign().getToken().getLexeme()){
                        case "+":
                            list.add("iadd");
                            break;
                        case "-":
                            list.add("isub");
                            break;
                        case "*":
                            list.add("imul");
                            break;
                        case "/":
                            list.add("idiv");
                            break;
                    }
                    break;
            }
        }
    }


    private Cell expr(){
        return expr_tail(term());
    }

    private Cell term(){
        return term_tail(factor());
    }

    private Cell expr_tail(Cell expr){
        if ("+".equals(currentToken.getLexeme()) || "-".equals(currentToken.getLexeme())) {
            Cell cell = new Cell();
            cell.setSign(new Sign(currentToken.getLexeme(), currentToken));
            cell.setLeft(expr);
            next();
            cell.setRight(term());
            return expr_tail(cell);
        }
        return expr;
    }

    private Cell term_tail(Cell expr){
        if ("*".equals(currentToken.getLexeme()) || "/".equals(currentToken.getLexeme())){
            Cell cell = new Cell();
            cell.setSign(new Sign(currentToken.getLexeme(), currentToken));
            cell.setLeft(expr);
            next();
            cell.setRight(factor());
            return term_tail(cell);
        }
        return expr;
    }
    private Cell factor(){
        if("(".equals(currentToken.getLexeme())){
            next();
            Cell expr = expr();
            if (")".equals(currentToken.getLexeme())){
                next();
            }
            return expr;
        }else {
            Cell expr = new Cell();
            if (currentToken.getType() == TokenType.Number || currentToken.getType() == TokenType.String){
                expr.setSign(new Sign(currentToken.getLexeme(), currentToken));
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
