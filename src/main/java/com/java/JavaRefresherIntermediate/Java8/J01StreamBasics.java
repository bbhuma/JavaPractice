package com.java.JavaRefresherIntermediate.Java8;
/*
==============================================================
01_StreamBasics.java
Author: ChatGPT
Purpose:
    Java Streams Interview Handbook - Part 1

This file is intentionally written like a textbook rather than
a normal example program.

Topics in this file
-------------------
1. What is a Stream?
2. Stream Pipeline
3. Stream vs Collection
4. Creating Streams
5. map()
6. filter()
7. sorted()
8. distinct()
9. limit()
10. skip()
11. peek()
12. forEach()
13. collect()

NOTE:
The remaining advanced topics (collectors, reduce, optional,
flatMap, primitive streams, etc.) will be provided in later files.
==============================================================
*/

import java.util.*;
import java.util.stream.*;

public class J01StreamBasics {
    public static void main(String[] args) {

        /*
        ==============================================================
        CHAPTER 1 : WHAT IS A STREAM?
        ==============================================================
        Stream = A pipeline that processes data.

        Collection stores data.
        Stream processes data.

        Think:

        List<Employee>

              ↓

            Stream

              ↓

          filter()

              ↓

            map()

              ↓

         collect()

        Streams DO NOT modify the original collection.
        They produce a new result.
        ==============================================================
        */

        List<String> names = Arrays.asList(
                "John","David","Alex","Mike","Bob","David"
        );

        /*
        ==============================================================
        map()

        Purpose
        -------
        Transform one object into another.

        String

           ↓

        Integer(length)

        Equivalent for-loop

        List<Integer> lengths = new ArrayList<>();

        for(String s : names){
            lengths.add(s.length());
        }

        Interview Frequency
        ★★★★★
        ==============================================================
        */

        List<Integer> lengths =
                names.stream()
                        .map(String::length)
                        .toList();

        System.out.println(lengths);

        /*
        ==============================================================
        filter()

        Purpose

        Keep only elements matching a condition.

        Equivalent for-loop

        List<String> result = new ArrayList<>();

        for(String s : names){

            if(s.length() > 4)
                result.add(s);

        }
        ==============================================================
        */

        List<String> big =
                names.stream()
                        .filter(s -> s.length() > 4)
                        .toList();

        System.out.println(big);

        /*
        ==============================================================
        distinct()

        Removes duplicates.

        Original

        John
        David
        Alex
        David

        Result

        John
        David
        Alex
        ==============================================================
        */

        System.out.println(
                names.stream()
                        .distinct()
                        .toList()
        );

        /*
        ==============================================================
        sorted()

        Ascending order.

        Equivalent

        Collections.sort(list)

        ==============================================================
        */

        System.out.println(
                names.stream()
                        .sorted()
                        .toList()
        );

        /*
        ==============================================================
        limit()

        First N elements.
        ==============================================================
        */

        System.out.println(
                names.stream()
                        .limit(3)
                        .toList()
        );

        /*
        ==============================================================
        skip()

        Skip first N elements.
        ==============================================================
        */

        System.out.println(
                names.stream()
                        .skip(2)
                        .toList()
        );

        /*
        ==============================================================
        peek()

        Used mainly for debugging.

        It lets you look at values while they flow through
        the stream.

        Avoid using peek() for business logic.
        ==============================================================
        */

        names.stream()
                .peek(s -> System.out.println("Before : " + s))
                .map(String::toUpperCase)
                .peek(s -> System.out.println("After  : " + s))
                .toList();

        /*
        ==============================================================
        collect()

        Converts stream into another collection.

        Example:

        Stream

             ↓

        List

        ==============================================================
        */

        List<String> collected =
                names.stream()
                        .filter(s -> s.startsWith("D"))
                        .collect(Collectors.toList());

        System.out.println(collected);

        /*
        ==============================================================
        THINKING PROCESS

        Need names longer than 4

        List<String>

             ↓

          stream()

             ↓

        filter()

             ↓

        collect()

        Need lengths?

        stream()

             ↓

          map()

             ↓

        collect()

        Need remove duplicates?

        distinct()

        Need first 5?

        limit(5)

        Need skip first 3?

        skip(3)

        ==============================================================
        */
    }
}
