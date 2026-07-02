
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;
import java.util.stream.*;

/*
===============================================================================
J19_StreamsInternals.java

Interview Rating : ★★★★★

Goal

Understand HOW Streams execute internally.
===============================================================================
*/

public class J19_StreamsInternals {

    public static void main(String[] args){

        List<String> names =
                Arrays.asList("John","David","Alex");

        /*
        Stream Pipeline

        Source
          |
        stream()
          |
        map()
          |
        filter()
          |
        collect()

        Intermediate operations are LAZY.

        They DO NOT execute immediately.
        */

        List<Integer> result =
                names.stream()
                        .map(String::length)
                        .filter(n -> n > 4)
                        .toList();

        System.out.println(result);

        /*
        Simplified Internal Flow

        List
          |
        Spliterator
          |
        ReferencePipeline
          |
        map()
            stores Function
          |
        filter()
            stores Predicate
          |
        Terminal Operation
          |
        Iteration Starts
          |
        Element
          |
        map.apply()
          |
        filter.test()
          |
        Sink.accept()
          |
        Result

        Why can't Streams be reused?

        Because after a terminal operation,
        the pipeline is CLOSED.

        Common Exception

        IllegalStateException

        stream has already been operated upon
        or closed.
        */

        Stream<String> stream = names.stream();

        System.out.println(stream.count());

        // stream.count(); // Uncomment -> IllegalStateException

        /*
        Interview Questions

        1. Why lazy evaluation?
        2. Why one-time use?
        3. Difference between Collection and Stream?
        4. What is Spliterator?
        5. What is a terminal operation?
        */
    }
}
