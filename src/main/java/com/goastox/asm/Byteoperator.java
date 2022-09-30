package com.goastox.asm;

public final class Byteoperator {
    public static int toint(byte[] bytes) {
        return (bytes[0] & 0xff) << 24 | (bytes[1] & 0xff) << 16 | (bytes[2] & 0xff) << 8 | bytes[3] & 0xff;
    }
    public static int toint2(byte[] bytes) {
        return (bytes[0] & 0xff) << 8 | bytes[1] & 0xff;
    }

    public static String encodeHexString(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
