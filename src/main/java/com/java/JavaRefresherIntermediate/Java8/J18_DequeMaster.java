
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;

/*
===============================================================================
J18_DequeMaster.java

Interview Rating : ★★★★★

Deque = Double Ended Queue

Can work as
1. Queue (FIFO)
2. Stack (LIFO)

Best implementation:
ArrayDeque

Avoid Stack for new code.
===============================================================================
*/

public class J18_DequeMaster {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        /*
        Queue Operations

        offerLast() -> enqueue
        pollFirst() -> dequeue
        peekFirst() -> front
        */

        deque.offerLast(10);
        deque.offerLast(20);
        deque.offerLast(30);

        System.out.println(deque);
        System.out.println(deque.pollFirst());
        System.out.println(deque.peekFirst());

        /*
        Stack Operations

        push() == addFirst()
        pop()  == removeFirst()
        peek() == peekFirst()
        */

        deque.push(100);
        deque.push(200);

        System.out.println(deque.peek());
        System.out.println(deque.pop());

        /*
        Double Ended Operations

        offerFirst()
        offerLast()

        pollFirst()
        pollLast()

        peekFirst()
        peekLast()
        */

        deque.offerFirst(1);
        deque.offerLast(999);

        System.out.println(deque);
        System.out.println(deque.pollLast());

        /*
        Complexity

        offerFirst()  O(1)
        offerLast()   O(1)
        pollFirst()   O(1)
        pollLast()    O(1)

        Interview Uses

        Sliding Window Maximum
        Monotonic Queue
        BFS
        Stack replacement
        */
    }
}
