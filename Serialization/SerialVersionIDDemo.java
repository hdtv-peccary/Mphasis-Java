package com.mph;

import java.io.*;

class Data implements Serializable{
    private static final long serialVersionUID =11l;
    int i=10;
    int j=20;
    //int k=30;
}




public class SerialVersionIDDemo {
    public static void main(String[] args) {
        Data data = new Data();
        try {

            // Saving of object in a file
            FileOutputStream file = new FileOutputStream("xyz.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(data);
            FileInputStream fin = new FileInputStream("xyz.txt");
            ObjectInputStream in = new ObjectInputStream(fin);

            // Method for deserialization of object
            Data dataRestored = (Data)in.readObject();


            System.out.println("Deserialized Object value "+ dataRestored.i+" "+dataRestored.j);

        }

        catch (IOException | ClassNotFoundException ex) {
                  ex.printStackTrace();

    }
}
    }
