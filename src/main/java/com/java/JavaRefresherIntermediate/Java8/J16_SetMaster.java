
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;

/*
===============================================================================
J16_SetMaster.java

Topics
------
HashSet
LinkedHashSet
TreeSet

Interview Rating : ★★★★★
===============================================================================
*/

public class J16_SetMaster {

    public static void main(String[] args){

        /*
        WHY Set?

        Unique values only.

        No duplicates.

        */

        Set<Integer> hashSet = new HashSet<>();

        hashSet.add(10);
        hashSet.add(5);
        hashSet.add(10);

        System.out.println(hashSet);

        /*
        HashSet

        Backed by HashMap.

        Order?

        No guarantee.

        Complexity

        add()

            O(1)

        contains()

            O(1)
        */

        Set<Integer> linked = new LinkedHashSet<>();

        linked.add(5);
        linked.add(1);
        linked.add(9);

        /*
        LinkedHashSet

        Maintains insertion order.

        Slightly slower than HashSet.
        */

        System.out.println(linked);

        TreeSet<Integer> tree = new TreeSet<>();

        tree.add(9);
        tree.add(2);
        tree.add(7);

        /*
        TreeSet

        Red Black Tree

        Sorted

        add()

            O(log n)

        first()

        last()

        higher()

        lower()

        Uses Comparable/Comparator.
        */

        System.out.println(tree);

        /*
        Interview Memory

        HashSet

            Fast

        LinkedHashSet

            Ordered

        TreeSet

            Sorted
        */
    }
}
