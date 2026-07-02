
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;
import java.util.stream.*;

/*
===============================================================================
J05_ReduceMaster.java

Topics
------
reduce()
identity
accumulator
Optional result
Primitive reductions

Interview Rating : ★★★★★
===============================================================================
*/
public class J05_ReduceMaster {

    public static void main(String[] args){

        List<Integer> numbers = List.of(1,2,3,4,5);

        /*
        ===========================================================================
        WHY reduce()?

        Interview Problem

        Sum

        Product

        Maximum

        Minimum

        String concatenation

        All follow the SAME pattern.

        Combine many values

                 ↓

             One value

        reduce()

        Signature

        T reduce(T identity,
                 BinaryOperator<T> accumulator)

        identity

            Starting value

        accumulator

            How to combine two values.
        ===========================================================================
        */

        int sum = numbers.stream()
                .reduce(0,(a,b)->a+b);

        System.out.println(sum);

        /*
        Dry Run

        identity = 0

        0 + 1 = 1
        1 + 2 = 3
        3 + 3 = 6
        6 + 4 = 10
        10 + 5 = 15
        */

        int product = numbers.stream()
                .reduce(1,(a,b)->a*b);

        System.out.println(product);

        Optional<Integer> max = numbers.stream()
                .reduce(Integer::max);

        System.out.println(max);

        /*
        Equivalent Loop

        int ans = 0;

        for(int n:numbers){
            ans += n;
        }

        Complexity

        O(n)

        Common Mistakes

        Wrong identity.

        Product identity is 1.

        Sum identity is 0.

        Interview Thinking

        Many

            ↓

        One

            ↓

        reduce()

        Compare

        map()

            transform

        filter()

            keep

        reduce()

            combine
        */
    }
}
