
package com.java.JavaRefresherIntermediate.Java8;

import java.util.function.*;

/*
===============================================================================
J21_MethodReferenceMaster.java

Interview Rating : ★★★★★

Method Reference = Short form of Lambda

Lambda

    s -> s.length()

Method Reference

    String::length
===============================================================================
*/
public class J21_MethodReferenceMaster {

    public static void print(String s){
        System.out.println(s);
    }

    public static void main(String[] args){

        /*
        Static Method

        Class::method
        */

        Consumer<String> c =
                J21_MethodReferenceMaster::print;

        c.accept("Hello");

        /*
        Instance Method

        Class::instanceMethod
        */

        Function<String,Integer> f =
                String::length;

        System.out.println(f.apply("Interview"));

        /*
        Constructor Reference

        Class::new
        */

        Supplier<StringBuilder> sb =
                StringBuilder::new;

        System.out.println(sb.get());

        /*
        Interview Memory

        Lambda

            x -> x.length()

        Method Reference

            String::length

        Use when lambda only calls
        an existing method.
        */
    }
}
