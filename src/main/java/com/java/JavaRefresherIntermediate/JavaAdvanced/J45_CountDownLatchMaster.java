
package com.java.JavaRefresherIntermediate.JavaAdvanced;

import java.util.concurrent.*;

/*
===============================================================================
J45_CountDownLatchMaster

CountDownLatch

One-time synchronization.

Interview Rating : ★★★★★
===============================================================================
*/
public class J45_CountDownLatchMaster {

    public static void main(String[] args) throws Exception{

        CountDownLatch latch = new CountDownLatch(3);

        Runnable worker = ()->{
            System.out.println(Thread.currentThread().getName()+" finished");
            latch.countDown();
        };

        new Thread(worker).start();
        new Thread(worker).start();
        new Thread(worker).start();

        System.out.println("Waiting...");
        latch.await();
        System.out.println("All workers completed");

        /*
        Methods

        countDown()
        await()
        getCount()

        Difference

        CountDownLatch

            One time use

        CyclicBarrier

            Reusable
        */
    }
}
