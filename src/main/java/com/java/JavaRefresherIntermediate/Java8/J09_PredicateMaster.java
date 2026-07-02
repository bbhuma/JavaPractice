
package com.java.JavaRefresherIntermediate.Java8;

import java.util.function.Predicate;
import java.util.*;

/*
===============================================================================
J09_PredicateMaster.java

Predicate<T>

Input

    T

Output

    boolean

Used by

filter()

removeIf()

Optional.filter()

Interview Rating : ★★★★★
===============================================================================
*/

public class J09_PredicateMaster {

    public static void main(String[] args){

        Predicate<Integer> even = n -> n % 2 == 0;

        System.out.println(even.test(10));
        System.out.println(even.test(11));

        /*
        test()

        Executes predicate.

        Returns true/false.
        */

        Predicate<Integer> positive = n -> n > 0;

        /*
        and()

        Both predicates true.
        */

        System.out.println(
                even.and(positive).test(20)
        );

        /*
        or()

        Either predicate true.
        */

        System.out.println(
                even.or(positive).test(-4)
        );

        /*
        negate()

        Reverse result.
        */

        System.out.println(
                even.negate().test(3)
        );

        List<Integer> numbers =
                Arrays.asList(1,2,3,4,5,6);

        /*
        Predicate in Streams

        filter()

        Equivalent

        for(...)

            if(predicate)

                add()
        */

        System.out.println(
                numbers.stream()
                        .filter(even)
                        .toList()
        );

        /*
        Interview Memory

        Function

            transform

        Predicate

            decide

        Consumer

            use

        Supplier

            produce
        */
    }
}
