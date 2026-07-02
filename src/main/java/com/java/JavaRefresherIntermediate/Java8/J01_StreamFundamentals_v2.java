
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;
import java.util.stream.*;

/*
===============================================================================
J01_StreamFundamentals.java
Version : 2.0 (Interview Edition)

GOAL
----
This is NOT a notes file.
This is a handbook that explains WHY Streams exist, HOW they work,
WHAT Java does internally, and HOW to answer interview questions.

===============================================================================
*/

public class J01_StreamFundamentals_v2 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "John","David","Alex","Mike","Bob","David"
        );

        /*
        ===============================================================================
        CHAPTER 1 : WHY WERE STREAMS INTRODUCED?
        ===============================================================================

        BEFORE JAVA 8

        Collections could STORE data.

            List<String>

        But they could not PROCESS data elegantly.

        We wrote:

            for(...)
            if(...)
            add(...)

        repeatedly.

        Java 8 introduced Streams to express DATA PROCESSING.

        Collection
            |
            | stores data
            V

        Stream
            |
            | processes data
            V

        RESULT

        Streams DO NOT store data.

        Streams DO NOT modify the original List.

        Streams describe a pipeline.

        Nothing executes until a TERMINAL OPERATION is reached.
        ===============================================================================
        */

        /*
        ===============================================================================
        CHAPTER 2 : STREAM PIPELINE

        Source
          |
          V
        stream()
          |
          V
        map()
          |
          V
        filter()
          |
          V
        sorted()
          |
          V
        collect()

        map(), filter(), sorted() are INTERMEDIATE operations.

        collect(), count(), forEach(), reduce()
        are TERMINAL operations.

        Java executes the pipeline ONLY after a terminal operation.
        ===============================================================================
        */

        /*
        ===============================================================================
        CHAPTER 3 : map()

        Interview Rating : ★★★★★

        PURPOSE

            Transform every element.

        Input

            String

        Output

            Integer

        Example

            "John"

                  |

             length()

                  |

                  4

        map() transforms one object into another.

        Signature

            <R> Stream<R> map(Function<? super T, ? extends R> mapper)

        Breakdown

        T = Input Type

        R = Output Type

        Example

        Stream<String>

              map(String::length)

        becomes

        Stream<Integer>

        Equivalent for-loop

        List<Integer> lengths = new ArrayList<>();

        for(String s : names){

            lengths.add(s.length());

        }

        Java Internally (Simplified)

        stream()

            ↓

        ReferencePipeline

            ↓

        store mapper

            ↓

        collect()

            ↓

        Spliterator begins iteration

            ↓

        mapper.apply(element)

            ↓

        new Stream<Integer>

        Complexity

        Time  : O(n)

        Space : O(n)

        Common Mistake

            names.stream()
                 .map(String::length);

        Nothing happens because there is no terminal operation.
        ===============================================================================
        */

        List<Integer> lengths = names.stream()
                .map(String::length)
                .toList();

        System.out.println(lengths);

        /*
        ===============================================================================
        CHAPTER 4 : filter()

        Interview Rating : ★★★★★

        PURPOSE

        Keep only elements satisfying a condition.

        Predicate<T>

            Input

            String

            Output

            true / false

        Dry Run

        John  -> length=4 -> false

        David -> length=5 -> true

        Alex  -> false

        Mike  -> false

        Bob   -> false

        David -> true

        Result

        [David, David]

        Equivalent Loop

        List<String> result = new ArrayList<>();

        for(String s : names){

            if(s.length()>4){

                result.add(s);

            }

        }

        Complexity

        O(n)

        Memory Trick

        map()

            transform

        filter()

            keep
        ===============================================================================
        */

        List<String> longNames = names.stream()
                .filter(s -> s.length() > 4)
                .toList();

        System.out.println(longNames);

        /*
        ===============================================================================
        CHAPTER 5 : collect()

        collect() is a TERMINAL operation.

        Think

        Stream

           |

        "Bring the result back."

        collect(Collectors.toList())

            returns List

        collect(Collectors.toSet())

            returns Set

        Interview Follow-up

        Q: Difference between Stream.toList() and Collectors.toList()?

        A:

        Stream.toList()

            Java 16+

            Unmodifiable list.

        Collectors.toList()

            Collector based.

            Usually mutable implementation but not guaranteed by contract.

        ===============================================================================
        */

        List<String> dNames = names.stream()
                .filter(s -> s.startsWith("D"))
                .collect(Collectors.toList());

        System.out.println(dNames);

        /*
        ===============================================================================
        INTERVIEW THINKING

        Need transformation?

            map()

        Need filtering?

            filter()

        Need final List?

            collect() or toList()

        Need unique values?

            distinct()

        Need sorting?

            sorted()

        Need first N?

            limit()

        Need skip?

            skip()

        ===============================================================================
        */

        /*
        ===============================================================================
        TOP INTERVIEW QUESTIONS

        1. Why are Streams lazy?

        2. Difference between Collection and Stream?

        3. Difference between map() and flatMap()?

        4. Why does mapToInt() exist?

        5. Difference between toList() and collect(toList())?

        6. What is a terminal operation?

        7. What happens if no terminal operation exists?

        8. Are Streams reusable?

            No.

        9. Can Streams modify the original List?

            No.

        10. Why were Streams introduced?

            Declarative programming
            Functional programming
            Less boilerplate
            Parallel processing support
        ===============================================================================
        */
    }
}
