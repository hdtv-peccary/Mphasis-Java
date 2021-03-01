package com.mph;

import java.util.LinkedList;

public class LinkedListPopTask {
    public static void main(String args[]) {
        // Create a collection.
        LinkedList<String> adq = new LinkedList<String>();

        // Use the collection like a stack.
        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");

        System.out.print("Popping the stack: ");

        while (adq.peek() != null)
            System.out.print(adq.pop() + " ");

        System.out.println();
    }
}
