
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/*
===============================================================================
J25_CustomCollectorMaster.java

Interview Rating : ★★★★★

Topics
------
1. Why Collector?
2. Supplier
3. Accumulator
4. Combiner
5. Finisher
6. Characteristics
===============================================================================
*/
public class J25_CustomCollectorMaster {

    public static void main(String[] args){

        List<String> names = List.of("John","Alex","David");

        /*
        Collector Life Cycle

        Supplier
            |
            V
        Create Result Container

        Accumulator
            |
            V
        Add one element at a time

        Combiner
            |
            V
        Merge partial results
        (parallel streams)

        Finisher
            |
            V
        Produce final result
        */

        Collector<String,StringBuilder,String> collector =
                Collector.of(
                        StringBuilder::new,          // Supplier
                        (sb,s)->sb.append(s).append(","), // Accumulator
                        StringBuilder::append,       // Combiner
                        StringBuilder::toString      // Finisher
                );

        String result = names.stream().collect(collector);
        System.out.println(result);

        /*
        Equivalent Loop

        StringBuilder sb = new StringBuilder();

        for(String s:names){
            sb.append(s).append(",");
        }

        return sb.toString();

        Interview Notes

        Supplier      -> Creates container
        Accumulator   -> Adds one element
        Combiner      -> Parallel merge
        Finisher      -> Final conversion
        */
    }
}
