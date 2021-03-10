package com.mph;

import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.Deque;
import java.util.Objects;
import java.util.logging.Logger;

class Point {
    private int x;
    private int y;

    public Point() {
        this.x =2;
        this.y=4;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


}
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
	// write your code here
        Object object = null;
        try {
            object = Class.forName(args[0]).newInstance();
            //class.forName returns a class , newInstance returns the object
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Class PrimitiveClass =int.class;
        System.out.println(PrimitiveClass);
        System.out.println(PrimitiveClass.getCanonicalName());



        Integer i =3;//autoboxing
        Class theClass = i.getClass();
        System.out.println(theClass.getCanonicalName());

        Class StringObject ="A".getClass();
        System.out.println(StringObject.getCanonicalName());

        Class dateClass = Date.class;
        //samething is got in diff way as below
        //Class dateClass2 = new Date().getClass();// we obtain the class out of the obj

        Logger logger = Logger.getLogger(Main.class.getName());


        Class <?> cl =Class.forName("java.util.Calendar");
        Class<?> typeParam = Class.forName("java.util.ArrayList");
        Class c = java.lang.String.class;
        System.out.println(Modifier.toString(c.getModifiers()));

        Class classname = System.out.getClass(); //system class , out is static ref
        System.out.println(classname);


        System.out.println(object);

    }
}
