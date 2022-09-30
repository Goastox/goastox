package com.goastox.codegen;

public class ClassCode {

    // 魔术 u4
    public static final int magic = 0xcafebabe;

    // 版本号 u4

    // 常量池个数 u2 65535
        // 常量 1 2 3 。。。n


    // 访问表示 u2
    // this class u2
    // super class u2
    // 接口个数 u2
        // 接口
    // 字段个数 u2
        // 字段(成员变量，不包括局部变量)
    // 方法个数 u2
        // 方法1
//        u2 修饰符
//          u2 方法名称
//            u2 字段类型
//          u2 属性数量
//              属性
//                  u2 属性类型 Code
//                    u4 长度
//                        u2 max_stack
//                          u2 max_locals
//
    // 属性个数 u2
        // 属性





    public static void main(String[] args) {
        System.out.println(Character.MAX_VALUE);
        System.out.println(magic);
    }



}
