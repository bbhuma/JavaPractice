
package com.java.JavaRefresherIntermediate.Java8;

import java.util.function.*;

/*
===============================================================================
J35_BiFunction_BiPredicate_BiConsumerMaster

BiFunction<T,U,R>   -> 2 inputs, 1 output
BiPredicate<T,U>    -> 2 inputs, boolean
BiConsumer<T,U>     -> 2 inputs, no output

Interview Rating : ★★★★★
===============================================================================
*/
public class J35_BiFunction_BiPredicate_BiConsumerMaster {

    public static void main(String[] args){

        BiFunction<Integer,Integer,Integer> add = Integer::sum;
        System.out.println(add.apply(10,20));

        BiFunction<String,String,String> join =
                (a,b)->a+" "+b;
        System.out.println(join.apply("Hello","Java"));

        BiPredicate<Integer,Integer> greater =
                (a,b)->a>b;
        System.out.println(greater.test(10,5));

        BiConsumer<String,Integer> printer =
                (name,age)->System.out.println(name+" : "+age);
        printer.accept("John",30);

        /*
        MEMORY

        Function     -> 1 input
        BiFunction   -> 2 inputs

        Predicate    -> boolean
        BiPredicate  -> 2 inputs + boolean

        Consumer     -> void
        BiConsumer   -> 2 inputs + void
        */
    }
}
