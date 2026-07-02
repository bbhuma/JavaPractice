
package com.java.JavaRefresherIntermediate.Java8;

import java.util.function.*;

/*
===============================================================================
J36_UnaryBinaryOperatorMaster

UnaryOperator<T>  -> T -> T
BinaryOperator<T> -> (T,T) -> T

Interview Rating : ★★★★★
===============================================================================
*/
public class J36_UnaryBinaryOperatorMaster1 {

    public static void main(String[] args){

        UnaryOperator<Integer> square = x->x*x;
        System.out.println(square.apply(6));

        UnaryOperator<String> upper = String::toUpperCase;
        System.out.println(upper.apply("java"));

        BinaryOperator<Integer> max = Integer::max;
        BinaryOperator<Integer> min = Integer::min;
        BinaryOperator<Integer> sum = Integer::sum;

        System.out.println(max.apply(5,9));
        System.out.println(min.apply(5,9));
        System.out.println(sum.apply(5,9));

        /*
        BinaryOperator is a specialized
        BiFunction<T,T,T>.
        */
    }
}
