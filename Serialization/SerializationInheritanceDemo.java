package com.mph;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationInheritanceDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Derived derived = new Derived();
        derived.child = 11;
        derived.parent = 21;
        System.out.println("Serialization Starts");
        FileOutputStream fileOutputStream = new FileOutputStream("inheritance.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(derived);

        System.out.println("DeSerialization Starts");
        FileInputStream fileInputStream = new FileInputStream("inheritance.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Derived derived2 = (Derived)inputStream.readObject();

        System.out.println(derived2.child);
        System.out.println(derived2.parent);
    }

}
