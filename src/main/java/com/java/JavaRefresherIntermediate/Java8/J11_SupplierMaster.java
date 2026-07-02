
package com.java.JavaRefresherIntermediate.Java8;

import java.time.LocalDateTime;
import java.util.function.Supplier;

/*
===============================================================================
J11_SupplierMaster.java

Supplier<T>

Input  : NONE
Output : T

Produces values on demand.

Interview Rating : ★★★★★

Used by

Optional.orElseGet()
Stream.generate()
Factories
Dependency Injection
===============================================================================
*/

public class J11_SupplierMaster {

    public static void main(String[] args){

        Supplier<String> message =
                () -> "Generated Value";

        System.out.println(message.get());

        /*
        get()

        No input.

        Generates output.

        Useful when object creation
        is expensive.

        Difference

        orElse()

            object created immediately.

        orElseGet()

            Supplier executes ONLY if needed.
        */

        Supplier<LocalDateTime> now =
                LocalDateTime::now;

        System.out.println(now.get());

        /*
        Stream.generate()

        Infinite Stream.

        Stream.generate(Math::random)

        limit()

        is usually required.

        Interview Memory

        Function

            input -> output

        Supplier

            no input -> output
        */
    }
}
