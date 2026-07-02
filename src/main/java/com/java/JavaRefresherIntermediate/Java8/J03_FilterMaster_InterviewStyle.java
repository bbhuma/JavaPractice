
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;
import java.util.function.Predicate;

/*
===============================================================================
J03_FilterMaster.java

Focus
-----
filter()
distinct()
sorted()
limit()
skip()
peek()

Interview Rating : ★★★★★
===============================================================================
*/

public class J03_FilterMaster_InterviewStyle {

    public static void main(String[] args){

        List<String> names = Arrays.asList(
                "John","David","Alex","Mike","Bob","David"
        );

        /*
        ===========================================================================
        WHY filter()?

        Before Java 8

        for(...)
            if(...)
                add(...)

        filter()

        keeps only elements matching a Predicate.

        Predicate<T>

        Input

            T

        Output

            boolean

        Signature

        Stream<T> filter(Predicate<? super T> predicate)

        ===========================================================================
        */

        List<String> longNames = names.stream()
                .filter(s -> s.length() > 4)
                .toList();

        System.out.println(longNames);

        /*
        DRY RUN

        John  -> false

        David -> true

        Alex  -> false

        Mike  -> false

        Bob   -> false

        David -> true

        Result

        David
        David
        */

        /*
        Equivalent Loop

        List<String> out = new ArrayList<>();

        for(String s:names){

            if(s.length()>4)
                out.add(s);

        }
        */

        /*
        distinct()

        Removes duplicates.

        Internally relies on equality
        (equals() / hashCode()).
        */

        System.out.println(
                names.stream()
                        .distinct()
                        .toList()
        );

        /*
        sorted()

        Natural ordering.

        For custom objects,
        provide Comparator.
        */

        System.out.println(
                names.stream()
                        .sorted()
                        .toList()
        );

        /*
        limit()

        First N elements.

        Useful for pagination.
        */

        System.out.println(
                names.stream().limit(3).toList()
        );

        /*
        skip()

        Skip first N.

        Used with limit()
        for pagination.
        */

        System.out.println(
                names.stream().skip(2).limit(2).toList()
        );

        /*
        peek()

        Debugging only.

        Avoid business logic here.

        Because peek()
        is meant for observing,
        not modifying.
        */

        names.stream()
                .peek(System.out::println)
                .map(String::toUpperCase)
                .toList();

        /*
        INTERVIEW THINKING

        Need transform?

            map()

        Need keep?

            filter()

        Need unique?

            distinct()

        Need order?

            sorted()

        Need first page?

            skip()
            limit()

        TOP QUESTIONS

        1. filter vs map
        2. filter vs removeIf
        3. Why is filter lazy?
        4. Why peek should not change state?
        5. distinct() depends on what methods?
        */
    }
}
