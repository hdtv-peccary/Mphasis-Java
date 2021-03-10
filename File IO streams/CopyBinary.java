package com.mph;

import java.io.*;

public class CopyBinary {
    public static void main(String[] args) throws IOException {

        DataOutputStream out =null;
        try {

            new DataOutputStream(new BufferedOutputStream(new FileOutputStream("bfile1.txt"))); // if file does not exist it creates it
            out.writeInt(12345);


        }
        finally{
            if(out!=null){
                out.close();
            }
        }
    }

}

