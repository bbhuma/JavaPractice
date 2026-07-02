
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;

/*
===============================================================================
J28_PriorityQueueInternals.java

Goal

Understand Binary Heap.

Interview Rating : ★★★★★
===============================================================================
*/
public class J28_PriorityQueueInternals {

    public static void main(String[] args){

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.offer(10);
        heap.offer(4);
        heap.offer(7);
        heap.offer(1);

        System.out.println(heap);

        /*
        INTERNAL ARRAY

        Index

        0

              1

          4       7

        10

        Parent

            (i-1)/2

        Left Child

            2*i+1

        Right Child

            2*i+2

        offer()

            insert end

                ↓

            heapifyUp()

        poll()

            remove root

                ↓

            last element to root

                ↓

            heapifyDown()

        Complexity

        offer() O(log n)

        poll() O(log n)

        peek() O(1)

        Interview Uses

        K Largest
        K Smallest
        Top K Frequent
        Dijkstra
        Merge K Sorted Lists
        */
    }
}
