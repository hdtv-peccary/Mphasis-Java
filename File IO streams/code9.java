package com.mph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class code9 {
    public static void main(String args[]) throws IOException {
        FileReader fr = new FileReader("FileReaderDemo.java");
        BufferedReader br = new BufferedReader(fr);
        String s;

        while((s = br.readLine()) != null) {
            System.out.println(s);
        }

        fr.close();
    }
}
