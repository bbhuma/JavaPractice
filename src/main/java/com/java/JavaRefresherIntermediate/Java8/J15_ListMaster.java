
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;

/*
===============================================================================
J15_ListMaster.java

Topics
------
List Interface
ArrayList
LinkedList
Vector
Stack

Interview Rating : ★★★★★
===============================================================================
*/

public class J15_ListMaster {

    public static void main(String[] args){

        /*
        WHY List?

        Ordered Collection

        Allows duplicates

        Index based access

        Implementations

        ArrayList
        LinkedList
        Vector
        Stack
        */

        List<Integer> arrayList = new ArrayList<>();

        /*
        ArrayList

        Internally

            Dynamic Array

        Best For

        Fast random access

        Complexity

        get()       O(1)
        add(end)    Amortized O(1)
        add(front)  O(n)
        remove(mid) O(n)
        */

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        System.out.println(arrayList.get(1));

        /*
        LinkedList

        Doubly Linked List

        Fast insertion/removal

        Slow random access

        get(index)

            O(n)

        addFirst()

            O(1)

        addLast()

            O(1)
        */

        LinkedList<String> linked = new LinkedList<>();

        linked.add("A");
        linked.addFirst("Start");
        linked.addLast("End");

        System.out.println(linked);

        /*
        Vector

        Synchronized

        Legacy class

        Thread-safe

        Slower than ArrayList
        */

        Vector<Integer> vector = new Vector<>();
        vector.add(100);

        /*
        Stack

        LIFO

        push()
        pop()
        peek()

        Interview

        Prefer Deque over Stack
        for new code.
        */

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());
        System.out.println(stack.pop());

        /*
        Interview Memory

        ArrayList

            Read

        LinkedList

            Insert/Delete

        Vector

            Thread-safe

        Stack

            LIFO
        */
    }
}
