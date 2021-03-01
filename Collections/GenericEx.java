package com.mph;

class Point1<T>{
private T x,y;

public Point1(T x, T y) {
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
 class Task{

    // to include sub types of Number
    //Point<? super Number>
    public void test(Point1<? extends Number> point){
        System.out.println(point);
    }
 }
public class GenericEx {

    public static void main(String[] args) {

        Point1<Integer> point1 =new Point1<Integer>(2,4);
        System.out.println(point1);
        Point1<Float> point2 = new Point1<Float>(2.2f,4.4f);
        System.out.println(point2);

        Integer ix = point1.getX();
        Float fx= point2.getX();
        System.out.println(point1);

        Task task =new Task();
        task.test(point1);
        task.test(point2);


       // task.test(new Point1<String>("string","3")); will throw error since generic type should extend int is specified above
    }
}
