package com.mph;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("charfile.txt");
            outputStream = new FileWriter("charfileop.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    //file reader, writer -> reads the charcters and prints out , one byte at a time
    //buffered reader -> deals with one line at a time
    //with lines we have /n new line and /r carriage return

}
