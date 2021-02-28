package com.mph;

import java.io.*;

class Person implements Serializable{
    int id; String name;
    public Person(int id, String name){
        this.id =id;
        this.name=name;
    }
}

class Student extends Person {
    int rollno; String sname;
    public Student(int rollno, String course,int id, String name){
        super(id,name);

        this.rollno =rollno;
        this.sname =sname;
    }
}

public class SerializeWithInheritance {
    public static void main(String []args){
        Student s1 = new Student(35,"raji",122,"person");
        try {
            FileOutputStream fout = new FileOutputStream("filenew.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(s1);
            out.close();
            System.out.println("success");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("filenew.txt"));
            Student s = (Student) in.readObject();
            System.out.println(s.rollno+ " "+s.name + " "+ s.id + " "+ s.sname);



        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
