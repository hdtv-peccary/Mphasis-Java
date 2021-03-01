package com.mph;

import java.lang.reflect.Array;
import java.util.*;

class Point2<T>{
    private T x,y;

    public Point2(T x, T y) {
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

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Point2<?> point =(Point2<?>) obj;
        return Objects.equals(x,point.x) && Objects.equals(y,point.y);
    }
}

class Task1{
    public Collection<Point2> getResult(){

        // we'll get duplicate values unless the hashcode and equals method are overridden
        Collection<Point2> result = new HashSet<Point2>();
        result.add(new Point2(2, 4));
        result.add(new Point2(3,6));
        result.add(new Point2(4,8));
        result.add(new Point2(2,4));
        result.add(new Point2(5,10));

        //System.out.println(result.getClass().getName().equals(AbstractCollection.class.getName())); //gets the fully qualified name
       // System.out.println(result instanceof String); inconvertable type error
        // System.out.println(result instanceof LinkedHashSet);//since its above the hierarchy , no compile error , it returns false
        return result;
    }

}
public class CollectionEx {
    public static void main(String[] args) {
        Task1 t = new Task1();
        Collection<Point2> result =t.getResult();
        Iterator<Point2> it = result.iterator();
        while(it.hasNext()){
            Point2 point = it.next();
            System.out.println(point);
        }


    }
}
