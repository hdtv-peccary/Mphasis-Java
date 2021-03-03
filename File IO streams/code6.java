package com.mph;

import java.io.ByteArrayInputStream;

public class code6 {
    public static void main(String args[]){
        String tmp = "abcdefghijklmnopqrstuvwxyz";
        byte b[] = tmp.getBytes();
        ByteArrayInputStream input1 = new ByteArrayInputStream(b);
        ByteArrayInputStream input2 = new ByteArrayInputStream(b, 0, 3);

    }
}
