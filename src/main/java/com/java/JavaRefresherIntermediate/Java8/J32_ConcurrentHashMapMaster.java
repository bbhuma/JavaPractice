
package com.java.JavaRefresherIntermediate.Java8;

import java.util.concurrent.*;

/*
===============================================================================
J32_ConcurrentHashMapMaster.java

Topics
------
ConcurrentHashMap
putIfAbsent()
computeIfAbsent()
merge()
Thread Safety
===============================================================================
*/
public class J32_ConcurrentHashMapMaster {

    public static void main(String[] args){

        ConcurrentHashMap<String,Integer> map =
                new ConcurrentHashMap<>();

        map.put("Java",1);

        map.putIfAbsent("Java",10);
        map.putIfAbsent("Spring",2);

        System.out.println(map);

        map.computeIfAbsent("SQL",k->3);

        System.out.println(map);

        map.merge("Java",5,Integer::sum);

        System.out.println(map);

        /*
        Why ConcurrentHashMap?

        HashMap

            NOT thread-safe.

        Hashtable

            Entire table locked.

        ConcurrentHashMap

            Fine-grained locking
            Better scalability.

        Interview

        Null keys?
            Not allowed

        Null values?
            Not allowed
        */
    }
}
