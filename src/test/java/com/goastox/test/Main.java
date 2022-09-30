package com.goastox.test;


import com.goastox.asm.Jclasslib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {

    static String  aaa = "cafebabe0000003d00180a000200030700040c000500060100106a6176612f6c616e672f4f626a6563740100063c696e69743e010003282956090008000907000a0c000b000c0100106a6176612f6c616e672f53797374656d0100036f75740100154c6a6176612f696f2f5072696e7453747265616d3b0a000e000f0700100c001100120100136a6176612f696f2f5072696e7453747265616d0100077072696e746c6e010004284929560700140100054a74657374010004436f64650100046d61696e010016285b4c6a6176612f6c616e672f537472696e673b2956002100130002000000000002000100050006000100150000001100010001000000052ab70001b10000000000 00000000000";

    public static void main(String[] args) throws Exception {
        FileInputStream stream = new FileInputStream("/Users/konghanghang/Jtest.class");
        byte[] bytes = new byte[stream.available()];
        stream.read(bytes);
        stream.close();
        Jclasslib.parse(bytes);
    }


    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }
    private static byte toByte(char c) {
        byte b = (byte) "0123456789abcdef".indexOf(c);
        return b;
    }

//    public static void main(String[] args) throws IOException {
//        //1.在文件和程序之间铺设管道
//        FileInputStream fis = new FileInputStream("/Users/konghanghang/Jtest.class");
//        //创建一个通往其他文件的管道
//        FileOutputStream fos = new FileOutputStream("/Users/konghanghang/work/Jtest.class",true);
//        //2.开水龙头
//        int ch = 0;
//        while ( (ch=fis.read())!=-1){
//            System.out.print(ch);
//            fos.write(ch);
//        }
//        //3.关闭水龙java头（关闭流）
//        fis.close();
//        fos.close();
//    }
}
