
package com.java.JavaRefresherIntermediate.Java8;

import java.util.function.Function;

/*
===============================================================================
J08_FunctionMaster.java

INTERVIEW MASTER CHAPTER
===============================================================================

WHAT IS Function<T,R> ?

T = Input Type
R = Return Type

Function transforms ONE object into ANOTHER object.

Employee  -----> Salary
String    -----> Integer(length)
Integer   -----> String

Method

    R apply(T t)

Used heavily by

- Stream.map()
- Optional.map()
- Collectors.toMap()

-------------------------------------------------------------------------------
WHY WAS Function INTRODUCED?

Before Java 8 we passed objects.

Java 8 introduced the idea of passing BEHAVIOR.

Instead of saying

    "Here is the value."

we can say

    "Here is the logic."

-------------------------------------------------------------------------------
*/

public class J08_FunctionMaster {

    public static void main(String[] args) {

        Function<String,Integer> lengthFunction = String::length;

        System.out.println(lengthFunction.apply("Interview"));

        /*
        apply()

        Input

            "Java"

                |

        Function

                |

        Output

            4
        */

        Function<Integer,Integer> square = x -> x * x;

        System.out.println(square.apply(7));

        /*
        compose()

        Executes RIGHT function first.

        square.compose(addOne)

        addOne
            ↓
        square
        */

        Function<Integer,Integer> addOne = x -> x + 1;

        System.out.println(square.compose(addOne).apply(5));

        /*
        andThen()

        Executes LEFT function first.

        square
            ↓
        addOne
        */

        System.out.println(square.andThen(addOne).apply(5));

        /*
        identity()

        Returns input unchanged.

        x -> x
        */

        Function<String,String> identity = Function.identity();

        System.out.println(identity.apply("Java"));

        /*
        INTERVIEW

        compose()

            right to left

        andThen()

            left to right

        apply()

            execute function

        identity()

            no change

        Stream.map()

            expects Function<T,R>

        Equivalent custom interface

        interface MyFunction<T,R>{

            R apply(T t);

        }
        */
    }
}
