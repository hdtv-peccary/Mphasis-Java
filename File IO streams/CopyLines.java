package com.mph;

import java.io.*;

public class CopyLines {
    public static void main(String[] args) throws IOException {
        //out.close autoflush takes place , autoflush can be enabled
        //flush allows to push data to the file
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new FileReader("bfile.txt"));
            out = new PrintWriter(new PrintWriter(new FileWriter("bfile2.txt")));
            //printWriter is more flexible than buffered writer, we use it extensively in web based app
            String l;
            while ((l = in.readLine()) != null) {
                out.println(l);
            }
        }
            finally{
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }


        }
    }