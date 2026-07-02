
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;

/*
===============================================================================
J14_CollectionsMaster.java

Collections Utility Class

Interview Rating : ★★★★☆
===============================================================================
*/

public class J14_CollectionsMaster {

    public static void main(String[] args){

        List<Integer> list =
                new ArrayList<>(Arrays.asList(5,1,8,3));

        /*
        sort()

        Delegates to List.sort()
        */

        Collections.sort(list);
        System.out.println(list);

        /*
        reverse()
        */

        Collections.reverse(list);
        System.out.println(list);

        /*
        shuffle()
        */

        Collections.shuffle(list);
        System.out.println(list);

        /*
        max()
        */

        System.out.println(Collections.max(list));

        /*
        min()
        */

        System.out.println(Collections.min(list));

        /*
        frequency()

        Counts occurrences.
        */

        list.add(5);
        System.out.println(Collections.frequency(list,5));

        /*
        binarySearch()

        List MUST be sorted.
        */

        Collections.sort(list);
        System.out.println(Collections.binarySearch(list,5));

        /*
        Interview Tips

        sort()
        reverse()
        shuffle()
        binarySearch()
        max()
        min()
        frequency()

        are the most commonly asked.
        */
    }
}
