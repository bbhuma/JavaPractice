
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;

/*
===============================================================================
J31_TreeMapInternals.java

Topics
------
- Why TreeMap?
- Red Black Tree
- put()
- get()
- remove()
- firstKey()
- lastKey()
- higherKey()
- lowerKey()
- ceilingKey()
- floorKey()
- Comparator vs Comparable
===============================================================================
*/
public class J31_TreeMapInternals {

    public static void main(String[] args){

        TreeMap<Integer,String> map = new TreeMap<>();

        map.put(30,"Thirty");
        map.put(10,"Ten");
        map.put(20,"Twenty");
        map.put(40,"Forty");

        System.out.println(map);

        /*
        WHY TreeMap?

        HashMap
            Fast lookup
            No ordering

        TreeMap
            Sorted keys

        Internal

            Red Black Tree

        Complexity

        put() O(log n)
        get() O(log n)
        remove() O(log n)

        Root
             20
            /  \
          10    30
                  \
                  40
        */

        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.higherKey(20));
        System.out.println(map.lowerKey(20));
        System.out.println(map.ceilingKey(21));
        System.out.println(map.floorKey(21));

        TreeMap<String,Integer> custom =
                new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        custom.put("java",1);
        custom.put("Spring",2);

        System.out.println(custom);

        /*
        Interview

        TreeMap uses

        Comparable

        OR

        Comparator

        Never both simultaneously.
        */
    }
}
