package com.goastox.asm;

public class CodeAttribute {


    private byte[] name_index = new byte[2];

    private byte[] length = new byte[2];

    private byte[] max_stack = new byte[2];

    private byte[] code_length = new byte[4];

    private byte[] code = new byte[Byteoperator.toint(code_length)];

    private byte[] exception_table_length = new byte[2];


    private byte[] attribute_count = new byte[2];

}
