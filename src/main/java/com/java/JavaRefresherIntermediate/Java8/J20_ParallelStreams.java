
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;
import java.util.stream.*;

/*
===============================================================================
J20_ParallelStreams.java

Interview Rating : ★★★★★

Topics
------
1. Sequential Stream
2. Parallel Stream
3. Fork/Join Concept
4. Ordered vs Unordered
5. Thread Safety
6. When NOT to use parallel streams
===============================================================================
*/
public class J20_ParallelStreams {

    public static void main(String[] args) {

        List<Integer> numbers =
                IntStream.rangeClosed(1,10).boxed().toList();

        /*
        Sequential Stream

        One thread processes every element.

        1 -> 2 -> 3 -> ...
        */

        int sum1 = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        /*
        Parallel Stream

        Data split into chunks.

        Chunk1  Chunk2  Chunk3

            \     |     /

              ForkJoinPool

        Results merged.
        */

        int sum2 = numbers.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum1);
        System.out.println(sum2);

        System.out.println("\nThreads Used");
        numbers.parallelStream().forEach(n ->
                System.out.println(n + " -> " +
                        Thread.currentThread().getName()));

        /*
        Interview Notes

        Advantages
        ----------
        Large CPU-bound work
        Multi-core CPUs

        Disadvantages
        -------------
        Small collections
        Shared mutable state
        Blocking I/O

        Common Mistake

        list.parallelStream()
            .forEach(list::add);

        Not thread-safe.

        Prefer immutable operations.

        Questions

        1. What is ForkJoinPool?
        2. Why order changes with forEach()?
        3. Difference between forEach and forEachOrdered?
        4. When is parallel slower?
        */
    }
}
