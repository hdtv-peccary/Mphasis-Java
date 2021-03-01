package com.mph;


class Point<T>{
    private T x,y;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
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
public class GenericsExample {

    public static void main(String[] args) {
	// write your code here
        Point<Integer> point1 =new Point<Integer>(2,4);
        // u have to specify the type to avoid the unsafe/unchecked operation warning
        System.out.println(point1);
        //Point point2 =new Point(2.2,4.4);
        Point<Float> point2 = new Point<Float>(2.2f,4.4f);
        System.out.println(point2);
       Integer ix = point1.getX();
       Float fx= point2.getX();
        System.out.println(ix);
    }
}
