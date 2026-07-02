
package com.java.JavaRefresherIntermediate.Java8;

import java.util.stream.Collector;

/*
===============================================================================
J38_CollectorCharacteristicsMaster

Collector Characteristics

IDENTITY_FINISH
UNORDERED
CONCURRENT

Interview Rating : ★★★★★
===============================================================================
*/
public class J38_CollectorCharacteristicsMaster {

    public static void main(String[] args){

        /*
        IDENTITY_FINISH

        Finisher returns same container.

        Example

        List -> List

        --------------------------------

        UNORDERED

        Collector does not care
        about encounter order.

        --------------------------------

        CONCURRENT

        Safe for parallel accumulation.

        Usually used together with
        ConcurrentHashMap collectors.

        Interview Questions

        1. Why Combiner?
        2. When is CONCURRENT useful?
        3. Difference between
           Collector and Collectors?
        */
        System.out.println(Collector.Characteristics.IDENTITY_FINISH);
        System.out.println(Collector.Characteristics.UNORDERED);
        System.out.println(Collector.Characteristics.CONCURRENT);
    }
}
