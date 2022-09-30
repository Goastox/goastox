package com.goastox.asm;

public class Stream {

    private static int index  = 0;

    public static void readU2Simple(byte[] content, byte[] ret) {
        System.arraycopy(content, index, ret, 0, 2);
        index += 2;
    }

    public static void readSimple(byte[] content, byte[] ret) {
        System.arraycopy(content, index, ret, 0, ret.length);
        index += ret.length;
    }

    public static byte readU1Simple(byte[] content) {
        byte[] arr = new byte[1];

        System.arraycopy(content, index, arr, 0, 1);
        index +=1;
        return arr[0];
    }

    public static void readU4Simple(byte[] content, byte[] ret) {
        System.arraycopy(content, index, ret, 0, 4);
        index += 4;
    }


    public static void readU8Simple(byte[] content, byte[] ret) {
        System.arraycopy(content, index, ret, 0, 8);
        index += 8;
    }

    public static String toHex(String s) {
        String str = "";

        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);

            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }

        return str;
    }

    public static int byteToUnsignedShort(byte[] bytes, int off) {
        int high = bytes[off];
        int low = bytes[off + 1];

        return (high << 8 & 0xFF00) | (low & 0xFF);
    }

    public static byte[] unsignedShortToByte(int s) {
        byte[] targets = new byte[2];

        targets[0] = (byte) (s >> 8 & 0xFF);
        targets[1] = (byte) (s & 0xFF);

        return targets;
    }
}
