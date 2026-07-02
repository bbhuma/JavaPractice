
package com.java.JavaRefresherIntermediate.JavaAdvanced;

import java.util.concurrent.*;

/*
===============================================================================
J41_ExecutorServiceMaster.java

Topics
------
Thread Pool
submit()
execute()
shutdown()
Callable
Future

Interview Rating : ★★★★★
===============================================================================
*/
public class J41_ExecutorServiceMaster{

    public static void main(String[]args)throws Exception{

        ExecutorService pool=Executors.newFixedThreadPool(2);

        /*
        execute()

        Runnable

        No return value.
        */

        pool.execute(()->System.out.println("Runnable"));

        /*
        submit()

        Callable

        Returns Future.
        */

        Future<Integer> future=pool.submit(()->100);

        System.out.println(future.get());

        /*
        shutdown()

        Graceful shutdown.

        shutdownNow()

        Attempts immediate stop.

        Interview

        Why thread pool?

        Thread creation is expensive.

        Reuse threads.
        */

        pool.shutdown();
    }
}
