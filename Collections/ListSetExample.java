package com.mph;



import java.lang.reflect.Array;
import java.util.*;


class Tasks{
    public Collection<String > getResult(){

        //prints it in the insertion order
//        ArrayList<String> result = new ArrayList<String>();
//        result.add("A");
//        result.add("E");
//        result.add("F");
//        result.add("D");

          //set doesn't guarantee the insertion order
          //set doesn't store duplicate values
          Collection<String> result = new HashSet<String>();
          result.add("A");
          result.add("B");
          result.add("C");
          result.add("D");
        return result;
    }

}
public class ListSetExample{
    public static void main(String[] args) {
        Tasks t = new Tasks();
        Collection<String> result = t.getResult();

        //Iterator it = result.iterator();
        // string value is upcasted and returned as an object in it.next()

        Iterator<String> it = result.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("iterating using enhanced for loop syntax");
        for(String text: result){
            System.out.println(text);
        }

    }
}
