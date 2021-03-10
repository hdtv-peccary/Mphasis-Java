package com.mph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        //class ending with stream, represents we are dealing with byte streams
        FileInputStream in =null; // initializing a local var is imp, we are trying to read from finally without writing to it'
        FileOutputStream out =null;
        try {
            in = new FileInputStream("src/filenew.txt"); // if file does not exist it throws an filenotfound exception
            out = new FileOutputStream("file2newtxt"); // if file does not exist it creates it
            int c;

            //byte c;
            //while((c=(byte)in.read()) !=-1)
            // type cast is CPU intensive activity ,
            // we can reduce it by increasing the memory usage of c variable from byte to int
            while ((c = in.read()) != -1) { //reads the byte and returns it as integer
                out.write(c);
            }
        }
            finally{
                if(in !=null){
                    in.close();
                }
                if(out!=null){
                    out.close();
                }
            }
        }



//ByteStreams should only be used for primitive IO, those limited to ascii code, alphabets, numeric, etc
    }

