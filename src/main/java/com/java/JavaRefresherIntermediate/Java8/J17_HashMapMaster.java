
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;

/*
===============================================================================
J17_HashMapMaster.java

Interview Rating : ★★★★★

Topics
------
1. Why HashMap?
2. Hashing
3. hashCode()
4. equals()
5. put()
6. get()
7. remove()
8. containsKey()
9. computeIfAbsent()
10. merge()
11. keySet()
12. values()
13. entrySet()
14. HashMap vs LinkedHashMap
15. HashMap vs TreeMap
===============================================================================
*/

public class J17_HashMapMaster {

    static class Employee{
        int id;
        String name;

        Employee(int id,String name){
            this.id=id;
            this.name=name;
        }

        public String toString(){
            return id + " : " + name;
        }
    }

    public static void main(String[] args){

        /*
        ===========================================================================
        WHY HASHMAP?

        Suppose we have

            Employee Id

                ↓

            Employee Object

        Searching a List requires

            O(n)

        HashMap gives average

            O(1)

        lookup.

        Think

        Key

            ↓

        Hash Function

            ↓

        Bucket

            ↓

        Value
        ===========================================================================
        */

        Map<Integer,Employee> map = new HashMap<>();

        /*
        put()

        Adds or replaces value.

        If key already exists,
        old value is replaced.
        */

        map.put(101,new Employee(101,"John"));
        map.put(102,new Employee(102,"Alex"));
        map.put(103,new Employee(103,"David"));

        System.out.println(map);

        /*
        get()

        Returns value for key.

        Average Complexity

        O(1)
        */

        System.out.println(map.get(102));

        /*
        containsKey()

        Checks whether key exists.

        Better than

            get()!=null

        when null values are allowed.
        */

        System.out.println(map.containsKey(103));

        /*
        remove()

        Deletes key-value pair.
        */

        map.remove(102);

        System.out.println(map);

        /*
        computeIfAbsent()

        Creates value ONLY if key
        is missing.

        Common Interview Usage

        grouping

        frequency counting

        adjacency lists
        */

        map.computeIfAbsent(
                200,
                id -> new Employee(id,"New Employee")
        );

        System.out.println(map);

        /*
        merge()

        Very common for
        frequency counting.

        Word Count Example
        */

        Map<String,Integer> frequency = new HashMap<>();

        String[] words={
                "java","spring","java","sql","java"
        };

        for(String word:words){

            frequency.merge(
                    word,
                    1,
                    Integer::sum);

        }

        System.out.println(frequency);

        /*
        keySet()

        Iterate only keys.
        */

        for(Integer key : map.keySet()){

            System.out.println("Key = " + key);

        }

        /*
        values()

        Iterate only values.
        */

        for(Employee employee : map.values()){

            System.out.println(employee);

        }

        /*
        entrySet()

        Best way to iterate.

        Gives key and value together.
        */

        for(Map.Entry<Integer,Employee> entry
                : map.entrySet()){

            System.out.println(
                    entry.getKey()
                    + " -> "
                    + entry.getValue());

        }

        /*
        ===========================================================================
        HASHCODE + EQUALS

        HashMap first uses

            hashCode()

        to find bucket.

        Then uses

            equals()

        to compare keys inside bucket.

        Both should be implemented correctly
        for custom key classes.
        ===========================================================================
        */

        /*
        ===========================================================================
        HASHMAP vs LINKEDHASHMAP

        HashMap

            No order

        LinkedHashMap

            Insertion order maintained.

        ===========================================================================
        */

        Map<Integer,String> linked =
                new LinkedHashMap<>();

        linked.put(3,"C");
        linked.put(1,"A");
        linked.put(2,"B");

        System.out.println(linked);

        /*
        ===========================================================================
        HASHMAP vs TREEMAP

        HashMap

            Average O(1)

            Unordered

        TreeMap

            O(log n)

            Sorted

            Uses Comparator/Comparable
        ===========================================================================
        */

        Map<Integer,String> tree =
                new TreeMap<>();

        tree.put(30,"Thirty");
        tree.put(10,"Ten");
        tree.put(20,"Twenty");

        System.out.println(tree);

        /*
        ===========================================================================
        INTERVIEW MEMORY

        Need fastest lookup?

            HashMap

        Need insertion order?

            LinkedHashMap

        Need sorted keys?

            TreeMap

        Need grouping?

            computeIfAbsent()

        Need frequency count?

            merge()

        ===========================================================================
        TOP QUESTIONS

        1. Difference between HashMap and Hashtable?
        2. What is load factor?
        3. What is rehashing?
        4. What happens during collision?
        5. hashCode vs equals?
        6. Why TreeNode after Java 8?
        7. Why average O(1)?
        8. Best iteration method?
        ===========================================================================
        */
    }
}
