
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;

/*
===============================================================================
J37_SpliteratorMaster

Spliterator = Split + Iterator

Used internally by Streams.

Interview Rating : ★★★★★
===============================================================================
*/
public class J37_SpliteratorMaster {

    public static void main(String[] args){

        List<String> names =
                Arrays.asList("John","Alex","David","Bob");

        Spliterator<String> sp = names.spliterator();

        System.out.println("tryAdvance()");
        sp.tryAdvance(System.out::println);

        System.out.println("Remaining");
        sp.forEachRemaining(System.out::println);

        /*
        trySplit()

        Parallel Streams use trySplit()
        to divide work.

        Characteristics

        ORDERED
        DISTINCT
        SORTED
        SIZED
        NONNULL
        IMMUTABLE
        CONCURRENT
        SUBSIZED
        */
    }
}
