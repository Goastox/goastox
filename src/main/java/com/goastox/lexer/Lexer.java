package com.goastox.lexer;

import com.goastox.exception.CompileExpressionErrorException;
import com.goastox.io.Handler;
import com.goastox.lexer.token.*;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.LinkedList;
import java.util.List;

public class Lexer {

    private final CharacterIterator iterator;

    private int line;
    private int index;

    private char peek;

    public Lexer(String iterator) {
        this.iterator = new StringCharacterIterator(iterator);
        this.peek = this.iterator.current();
        this.line = 1;
        this.index = 1;
    }

    private List<Token<?>> tokens = new LinkedList<>();


    public void next(){
        this.peek = this.iterator.next();
        ++ this.index;
    }

    public void line(){
        ++ this.line;
        this.index = 1;
    }

    public void scan() throws Exception {
        int state = 0;
        StringBuilder token = new StringBuilder();
        for (;;){
            if (peek == CharacterIterator.DONE){
                return;
            }
            switch (state){
                case 0:
                    token = new StringBuilder();
                    // 负数放在语法分析阶段处理
                    if(isNumber(peek)){
                        state = 2;
                        token.append(peek);
                        next();
                    } else if (isLetter(peek)) {
                        state = 4;
                        token.append(peek);
                        next();
                    } else if (peek == '%') { // 单行注释%   多行注释  %{ }% 和Matlab保持一致
                        state = 8;
                        token.append(peek);
                        next();
                    } else if (peek == 0x20) {// 空格
                        state = 0;
                        next();
                    } else if (peek == '\n') {
                        next();
                        state = 0;
                        line();
                    } else if (peek == '\'') { //判断字符串
                        state = 7;
                        next();
                    } else {
                        state = 13;
                    }
                    break;
                case 1:
                    if (isNumber(peek)){
                        state = 2;
                        token.append(peek);
                    }else {
                        //处理异常情况
                        state = 0;
                    }
                    break;
                case 2:
                    if (isNumber(peek)){
                        state = 2;
                        token.append(peek);
                        next();
                    } else if (peek == '.') {
                        state = 3;
                        token.append(peek);
                    }else {
                        state = 11;
                    }
                    break;
                case 3:
                    if (isNumber(peek)){
                        state = 10;
                        token.append(peek);
                    }
                    break;
                case 4:
                    // 仅支持字母数字下划线（字母开头）
                    if (isNumber(peek) || isLetter(peek) || peek == '_'){
                        state = 4;
                        token.append(peek);
                        next();
                    }else {
                        state = 12;
                    }
                    break;
                case 5:
                    if(peek == '}'){
                        state = 6;
                        next();
                    }else {
                        if(peek == '\n'){
                            line();
                        }
                        state = 5;
                        next();
                    }
                    break;
                case 6:
                    if(peek == '%'){
                        state = 0; //注释块结束
                        next();
                    }else{
                        //异常处理
                        state = 5;
                    }
                    break;
                case 7:// 判断字符串
                    if(peek == '\''){
                        state = 14;
                        next();
                    }else {
                        token.append(peek);
                        state = 7;
                        next();
                    }
                    break;
                case 8:
                    if(peek == '{'){//说明是注释块 开头
                        state = 5;
                        next();
                    }else{
                        state = 9;// 说明是单行注释
                    }
                    break;
                case 9:
                    if(peek == '\n'){// 单行注释处理完成
                        line();
                        state = 0;
                    }else {
                        state = 9;
                        next();
                    }
                    break;
                case 10:
                    if (isNumber(peek)){
                        state = 10;
                        token.append(peek);
                    }else {
                        // 考虑是否在词法分析阶段处理数字类型错误
                        state = 11;
                    }
                    break;
                case 11:
                    // 判断是数字类型
                    tokens.add(new NumberToken(token.toString(), line, index));
                    state = 0;
                    break;
                case 12:
                    //判断是否是关键字
                    if (isVariable(token.toString())){
                        tokens.add(new VariableToken(token.toString(), line, index));
                    }else {
                        tokens.add(new StringToken(token.toString(), line, index));
                    }
                    state = 0;
                    break;
                case 13:
                    // 判断操作符
                    // 判断关键字
                    if(!ascii(peek)){
                        throw new CompileExpressionErrorException("Illegal character: " + this.peek);
                    }
                    tokens.add(new CharToken(peek, line, index));
                    state = 0;
                    next();
                    break;
                case 14:
                    // String 类型
                    tokens.add(new StringToken(token.toString(), line, index));
                    state = 0;
                    break;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        String init = new Handler("/Users/konghanghang/goastox/src/main/java/com/goastox/io/r.txt").init();
        Lexer lexer = new Lexer(init);
        lexer.scan();
        lexer.tokens.forEach(System.out::println);
    }

    private static boolean isNumber(char c){
        if(c >= 0x30 && c <= 0x39){
            return true;
        }
        return false;
    }

    private static boolean ascii(char ch){
        if(ch < 0x7f){
            return true;
        }
        return false;
    }

    private static boolean isLetter(int c){
        if(c >=0x41 && c <= 0x5A){// A Z
            return true;
        } else if (c >= 0x61 && c <= 0x7A) { // a z
            return true;
        }
        return false;
    }

    private static boolean isOperator(char ch){
        for (char s : operator) {
            if(s == ch){
                return true;
            }
        }
        return false;
    }

    private static boolean isVariable(String ch){
        for (String s : variable) {
            if (ch.equals(s)){
                return true;
            }
        }
        return false;
    }

    static final char[] operator = {'+','-','*','/'};
    static final String[] variable = {"if", "else", "switch", "case", "default", "while", "for", "break", "continue", "true", "false"};


}
