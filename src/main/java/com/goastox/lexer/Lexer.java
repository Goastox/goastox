package com.goastox.lexer;

import com.goastox.io.Handler;
import com.goastox.lexer.token.NumberToken;
import com.goastox.lexer.token.Token;
import com.goastox.lexer.token.VariableToken;

import java.io.IOException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.LinkedList;
import java.util.List;

public class Lexer {


    private final CharacterIterator iterator;

    private int line;

    private char peek;

    public Lexer(String iterator) {
        this.iterator = new StringCharacterIterator(iterator);
        this.peek = this.iterator.current();
        this.line = 1;
    }

    private List<Token<?>> tokens = new LinkedList<>();


    public void next(){
        this.peek = this.iterator.next();
    }

    public void scan(){
        int state = 0;
        StringBuilder token = null;
        for (;; next()){
            if (peek == CharacterIterator.DONE){
                return;
            }
            switch (state){
                case 0:
                    token = new StringBuilder();
                    if(isNumber(peek)){
                        state = 2;
                        token.append(peek);
                    } else if (isLetter(peek)) {
                        state = 4;
                        token.append(peek);
                    } else if (peek == '%') { // 单行注释%   多行注释  %{ }% 和Matlab保持一致
                        state = 8;
                        token.append(peek);
                    }
                    break;
                case 1:
                    break;
                case 2:
                    if (isNumber(peek)){
                        state = 2;
                        token.append(peek);
                    } else if (peek == '.') {
                        state = 3;
                        token.append(peek);
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
                    }else {
                        state = 12;
                    }
                    break;
                case 5:

                    break;
                case 8:
                    if (peek == '\n'){
                        state = 0; // 注释结束
                    } else if (peek == '{') {//说明是注释块
                        state = 5;
                    } else {
                        state = 9;
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
                    tokens.add(new NumberToken(token.toString(), line, iterator.getIndex()));
                    state = 0;
                    break;
                case 12:
                    //判断是否是关键字
                    tokens.add(new VariableToken(token.toString(), line, iterator.getIndex()));
                    state = 0;
                    break;
            }
        }
    }


    public static void main(String[] args) throws IOException {
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

    private static boolean isLetter(int c){
        if(c >=0x41 && c <= 0x5A){
            return true;
        } else if (c >= 0x61 && c <= 0x7A) {
            return true;
        } else if (c >= 0xff) {
            return true;
        }
        return false;
    }

}
