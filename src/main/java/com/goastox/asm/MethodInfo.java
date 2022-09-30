package com.goastox.asm;

public class MethodInfo {

    private byte[] access_flags = new byte[2];
    private byte[] name_index = new byte[2];
    private byte[] descriptor_index = new byte[2];
    private byte[] attributes_count = new byte[2];

    private int size;



    public void parse(byte[] content){
        MethodInfo info = new MethodInfo();
        Stream.readU2Simple(content, info.access_flags);
        Stream.readU2Simple(content, info.name_index);
        Stream.readU2Simple(content, info.descriptor_index);
        Stream.readU2Simple(content, info.attributes_count);
    }
}
