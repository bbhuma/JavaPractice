
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;

/*
===============================================================================
J13_PriorityQueueMaster.java

PriorityQueue = Heap implementation.

Interview Rating : ★★★★★

Used In
-------
K Largest Elements
K Closest Points
Top K Frequent
Merge K Sorted Lists
Dijkstra
===============================================================================
*/

public class J13_PriorityQueueMaster {

    public static void main(String[] args){

        /*
        WHY PriorityQueue?

        Queue

            First In First Out

        PriorityQueue

            Highest / Lowest priority first.

        Default

            Min Heap

        */

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(10);
        minHeap.offer(2);
        minHeap.offer(7);
        minHeap.offer(1);

        while(!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }

        /*
        Max Heap

        Comparator.reverseOrder()

        OR

        (a,b)->Integer.compare(b,a)
        */

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Comparator.reverseOrder());

        maxHeap.addAll(Arrays.asList(10,2,7,1));

        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll());
        }

        /*
        Complexity

        offer() O(log n)
        poll()  O(log n)
        peek()  O(1)

        Interview Memory

        Need smallest quickly?

            Min Heap

        Need largest quickly?

            Max Heap
        */
    }
}
