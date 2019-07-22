package com.oren.io;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamTest {

    private static final int LEN = 5;

    private static final byte[] ArrayLetters={
            0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B,
            0x6C, 0x6D, 0x6E, 0x6F,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
    };

    public static void main(String[] args) {
        String tmp = new String(ArrayLetters);
        System.out.println("ArrayLetters="+tmp);
    }

    private static void testByteArrayInputStream() {
        ByteArrayInputStream bais = new ByteArrayInputStream(ArrayLetters);

        for (int i = 0; i < LEN; i++) {
            if (bais.available() > 0) {
                int read = bais.read();
                System.out.printf("%d : 0x%s\n", i, Integer.toHexString(read));
            }
        }
    }
}
