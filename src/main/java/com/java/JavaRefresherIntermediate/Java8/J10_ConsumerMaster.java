
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;
import java.util.function.Consumer;

/*
===============================================================================
J10_ConsumerMaster.java

Consumer<T>

Input  : T
Output : void

Represents an operation that USES a value.

Interview Rating : ★★★★★

Used by
--------
forEach()
Optional.ifPresent()
Stream.peek() (often with Consumer)

Think

Function  -> transforms
Predicate -> decides
Consumer  -> consumes
Supplier  -> creates
===============================================================================
*/

public class J10_ConsumerMaster {

    public static void main(String[] args){

        Consumer<String> printer = System.out::println;

        printer.accept("Hello Consumer");

        /*
        accept()

        Executes the Consumer.

        Input

        "Java"

            |

        Consumer

            |

        Prints

        "Java"

        No value is returned.
        */

        List<String> names = Arrays.asList(
                "John","Alex","David"
        );

        names.forEach(printer);

        /*
        Equivalent Loop

        for(String s : names){

            printer.accept(s);

        }

        andThen()

        Executes Consumers in sequence.
        */

        Consumer<String> upper =
                s -> System.out.println(s.toUpperCase());

        printer.andThen(upper)
               .accept("Interview");

        /*
        Interview Questions

        1. Difference between Function and Consumer?

        Function
            returns value

        Consumer
            returns nothing

        2. Where is Consumer used?

        forEach()
        ifPresent()
        peek()

        Complexity

        O(1) for one accept()

        O(n) for collection traversal.
        */
    }
}
