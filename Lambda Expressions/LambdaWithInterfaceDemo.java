package com.mph;

interface Printer2{
    public void print(Point p);
}

class Point{
    int x,y;



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
public class LambdaWithInterfaceDemo {
    public static void main(String[] args) {
        Point point =new Point(2,4);
        Printer2 printer =(point1)->{
            System.out.println(point1); point1.x=6;
        };
        printer.print(point);
        System.out.println(point);
    }
}
