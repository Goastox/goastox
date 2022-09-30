package com.goastox.asm;


import java.util.ArrayList;
import java.util.List;

public class ByteVector {
    public ConstantPool setConstantPool(int size) {
        this.constantPool = new ConstantPool(size);
        return constantPool;
    }


    private byte[] magic = new byte[4];
    private byte[] minorVersion = new byte[2];

    private byte[] majorVersion = new byte[2];

    private byte[] constantPoolSize = new byte[2];

    public byte[] getConstantPoolSize() {
        return constantPoolSize;
    }

    public void setConstantPoolSize(byte[] constantPoolSize) {
        this.constantPoolSize = constantPoolSize;
    }

    private ConstantPool constantPool;
    private byte[] accessFlag = new byte[2];
    private byte[] thisClass = new byte[2];

    private byte[] superClass = new byte[2];
    private byte[] interfacesLength = new byte[2];

    private List<InterfaceInfo> interfaceInfos = new ArrayList();
    private byte[] fieldsLength = new byte[2];

    private FieldInfo fields;
    private byte[] methodLength = new byte[2];

    private MethodInfo methods;
    private int attributeLength;

    private List<AttributeInfo> attributeInfos = new ArrayList();

    public byte[] getAccessFlag() {
        return accessFlag;
    }

    public void setAccessFlag(byte[] accessFlag) {
        this.accessFlag = accessFlag;
    }

    public byte[] getThisClass() {
        return thisClass;
    }

    public void setThisClass(byte[] thisClass) {
        this.thisClass = thisClass;
    }

    public byte[] getSuperClass() {
        return superClass;
    }

    public void setSuperClass(byte[] superClass) {
        this.superClass = superClass;
    }

    public byte[] getMagic() {
        return magic;
    }

    public void setMagic(byte[] magic) {
        this.magic = magic;
    }

    public byte[] getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(byte[] minorVersion) {
        this.minorVersion = minorVersion;
    }

    public byte[] getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(byte[] majorVersion) {
        this.majorVersion = majorVersion;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public byte[] getInterfacesLength() {
        return interfacesLength;
    }

    public void setInterfacesLength(byte[] interfacesLength) {
        this.interfacesLength = interfacesLength;
    }

    public List<InterfaceInfo> getInterfaceInfos() {
        return interfaceInfos;
    }

    public void setInterfaceInfos(List<InterfaceInfo> interfaceInfos) {
        this.interfaceInfos = interfaceInfos;
    }

    public byte[] getFieldsLength() {
        return fieldsLength;
    }

    public void setFieldsLength(byte[] fieldsLength) {
        this.fieldsLength = fieldsLength;
    }

    public FieldInfo getFields() {
        return fields;
    }

    public void setFields(FieldInfo fields) {
        this.fields = fields;
    }

    public byte[] getMethodLength() {
        return methodLength;
    }

    public void setMethodLength(byte[] methodLength) {
        this.methodLength = methodLength;
    }

    public MethodInfo getMethods() {
        return methods;
    }

    public void setMethods(MethodInfo methods) {
        this.methods = methods;
    }

    public int getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(int attributeLength) {
        this.attributeLength = attributeLength;
    }

    public List<AttributeInfo> getAttributeInfos() {
        return attributeInfos;
    }

    public void setAttributeInfos(List<AttributeInfo> attributeInfos) {
        this.attributeInfos = attributeInfos;
    }
}
