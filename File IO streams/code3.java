package com.mph;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class code3 {
    public static void main(String args[]) throws IOException {
        String dirname = "D:/java";

        File f1 = new File(dirname);
        FilenameFilter only = new FilenameFilter(){
            public boolean accept(File dir, String name) {
                if (name.endsWith(".sz")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        String s[] = f1.list(only);

        for (int i=0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

}

