package com.goastox.asm;

import java.util.HashMap;
import java.util.Map;

public class ConstantPool {

    public static final byte CONSTANT_Utf8 = 1;
    public static final byte CONSTANT_Integer = 3;
    public static final byte CONSTANT_Float = 4;
    public static final byte CONSTANT_Long = 5;
    public static final byte CONSTANT_Double = 6;
    public static final byte CONSTANT_Class = 7;
    public static final byte CONSTANT_String = 8;
    public static final byte CONSTANT_Fieldref = 9;
    public static final byte CONSTANT_Methodref = 10;
    public static final byte CONSTANT_InterfaceMethodref = 11;
    public static final byte CONSTANT_NameAndType = 12;
    public static final byte CONSTANT_MethodHandle = 15;
    public static final byte CONSTANT_MethodType = 16;
    public static final byte CONSTANT_Dynamic = 17;
    public static final byte CONSTANT_InvokeDynamic = 18;
    public static final byte CONSTANT_Module = 19;
    public static final byte CONSTANT_Package = 20;

    private Map<Integer, Object> constants;

    private int size;

    public ConstantPool(int size) {
        this.size = size;
        this.constants = new HashMap<>(size);
    }


    public Map<Integer, Object> getConstants() {
        return constants;
    }

    public void parse(byte[] content){
        byte[] u2 = new byte[2];
        for (int i = 1; i < size; i++) {
            int tag = Stream.readU1Simple(content);
            switch (tag){
                case CONSTANT_Utf8: {
                    Stream.readU2Simple(content, u2);
                    byte[] str = new byte[Byteoperator.toint2(u2)];
                    Stream.readSimple(content, str);
                    System.out.println("第" + i + " 个： 类型: utf8，       值： " + new String(str));
                    break;
                }
                case CONSTANT_Methodref:{
                    Stream.readU2Simple(content, u2);
                    int classindex = Byteoperator.toint2(u2);

                    Stream.readU2Simple(content, u2);
                    int nameAndTypeIndex = Byteoperator.toint2(u2);
                    System.out.println("第 " + i+ " 个: 类型: Method，     值: class_index: " + classindex + " nameAndTypeIndex: " + nameAndTypeIndex);
                    break;
                }
                case CONSTANT_Class:{
                    Stream.readU2Simple(content, u2);
                    int classindex = Byteoperator.toint2(u2);
                    System.out.println("第 " + i+ " 个: 类型: Class，      值: " + classindex);
                    break;
                }
                case CONSTANT_NameAndType:{
                    Stream.readU2Simple(content, u2);
                    int name_index = Byteoperator.toint2(u2);

                    Stream.readU2Simple(content, u2);
                    int descriptor_index = Byteoperator.toint2(u2);
                    System.out.println("第 " + i+ " 个: 类型: NameAndType，值: name_index: " + name_index + " descriptor_index: " + descriptor_index);
                    break;
                }
                case CONSTANT_Fieldref:{
                    Stream.readU2Simple(content, u2);
                    int class_index = Byteoperator.toint2(u2);

                    Stream.readU2Simple(content, u2);
                    int name_and_type_index = Byteoperator.toint2(u2);
                    System.out.println("第 " + i+ " 个: 类型: Field，      值: class_index: " + class_index + " name_and_type_index: " + name_and_type_index);
                    break;
                }
            }
        }


    }

}
