
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;

/*
===============================================================================
J33_GenericsMaster.java

Topics
------
Generic Class
Generic Method
Wildcards
Upper Bound
Lower Bound
PECS
===============================================================================
*/
public class J33_GenericsMaster {

    static class Box<T>{
        private T value;
        void set(T value){ this.value=value; }
        T get(){ return value; }
    }

    static <T> void print(T value){
        System.out.println(value);
    }

    static void upper(List<? extends Number> list){
        System.out.println(list);
    }

    static void lower(List<? super Integer> list){
        list.add(100);
        System.out.println(list);
    }

    public static void main(String[] args){

        Box<String> b = new Box<>();
        b.set("Java");
        System.out.println(b.get());

        print(10);
        print("Spring");

        upper(List.of(1,2,3));
        upper(List.of(1.5,2.5));

        List<Number> nums = new ArrayList<>();
        lower(nums);

        /*
        PECS

        Producer Extends

            ? extends T

        Consumer Super

            ? super T

        Memory

        Read only?

            extends

        Write?

            super
        */
    }
}
