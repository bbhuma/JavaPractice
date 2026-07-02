
package com.java.JavaRefresherIntermediate.JavaAdvanced;

import java.util.concurrent.locks.*;

/*
===============================================================================
J43_ReentrantLockMaster

Topics
------
lock()
unlock()
tryLock()
lockInterruptibly()
Fair vs Non-fair
===============================================================================
*/
public class J43_ReentrantLockMaster {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        try {
            System.out.println("Critical Section");
        } finally {
            lock.unlock();
        }

        if(lock.tryLock()){
            try{
                System.out.println("Acquired using tryLock()");
            } finally{
                lock.unlock();
            }
        }

        /*
        Why ReentrantLock?

        synchronized

            automatic lock

        ReentrantLock

            explicit control

        Features

        tryLock()
        lockInterruptibly()
        fairness option
        Condition support

        Interview

        Always unlock()
        inside finally block.
        */
    }
}
