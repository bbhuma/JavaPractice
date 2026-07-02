
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;

/*
===============================================================================
J34_StreamDeepDive.java

Topics
------
Lazy Evaluation
Fusion
Stateless Operations
Stateful Operations
Terminal Operations
===============================================================================
*/
public class J34_StreamDeepDive {

    public static void main(String[] args){

        List<String> names =
                Arrays.asList("John","Alex","David","Bob");

        /*
        Pipeline

        Source

            |

        map()

            Stateless

        filter()

            Stateless

        sorted()

            Stateful

        collect()

            Terminal

        Stateless

            Processes one element.

        Stateful

            Needs more/all elements.

        Example

        sorted()

        must see every element.

        filter()

        decides immediately.

        Java fuses operations.

        One traversal instead of many.
        */

        System.out.println(
                names.stream()
                        .map(String::toUpperCase)
                        .filter(s->s.length()>3)
                        .sorted()
                        .toList());

        /*
        Interview

        Lazy?

            Yes

        Reusable?

            No

        Parallel?

            Supported
        */
    }
}
