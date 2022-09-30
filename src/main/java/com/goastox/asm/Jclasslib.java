package com.goastox.asm;

public class Jclasslib {

    public static void parse(byte[] content){
        ByteVector vector = new ByteVector();
        Stream.readU4Simple(content, vector.getMagic());
        System.out.println("标识符：" + Integer.toHexString(Byteoperator.toint(vector.getMagic())));

        Stream.readU2Simple(content, vector.getMinorVersion());
        System.out.println("java 低版本：" + Byteoperator.toint2(vector.getMinorVersion()));

        Stream.readU2Simple(content, vector.getMajorVersion());
        System.out.println("java 高版本：" + Byteoperator.toint2(vector.getMajorVersion()));

        Stream.readU2Simple(content, vector.getConstantPoolSize());
        System.out.println("常量池size：" + Byteoperator.toint2(vector.getConstantPoolSize()));

        vector.setConstantPool(Byteoperator.toint2(vector.getConstantPoolSize())).parse(content);

        Stream.readU2Simple(content, vector.getAccessFlag());
        System.out.println("类访问表示： " + Byteoperator.toint2(vector.getAccessFlag()));

        Stream.readU2Simple(content, vector.getThisClass());
        System.out.println("this class： " + Byteoperator.toint2(vector.getThisClass()));

        Stream.readU2Simple(content, vector.getSuperClass());
        System.out.println("super class: " + Byteoperator.toint2(vector.getSuperClass()));

        Stream.readU2Simple(content, vector.getInterfacesLength());
        System.out.println("interfaces length:"+ Byteoperator.toint2(vector.getInterfacesLength()));

        Stream.readU2Simple(content, vector.getFieldsLength());
        System.out.println("field length: " + Byteoperator.toint2(vector.getFieldsLength()));

        Stream.readU2Simple(content, vector.getMethodLength());
        System.out.println("method length: " + Byteoperator.toint2(vector.getMethodLength()));



    }



}
