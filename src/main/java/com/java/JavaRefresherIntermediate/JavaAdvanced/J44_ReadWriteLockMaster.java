
package com.java.JavaRefresherIntermediate.JavaAdvanced;

import java.util.concurrent.locks.*;

/*
===============================================================================
J44_ReadWriteLockMaster

Read Lock
Write Lock
ReentrantReadWriteLock

Interview Rating : ★★★★★
===============================================================================
*/
public class J44_ReadWriteLockMaster {

    public static void main(String[] args){

        ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

        Lock read = rw.readLock();
        Lock write = rw.writeLock();

        read.lock();
        try{
            System.out.println("Reading...");
        }finally{
            read.unlock();
        }

        write.lock();
        try{
            System.out.println("Writing...");
        }finally{
            write.unlock();
        }

        /*
        Many Readers -> Allowed

        Reader Reader Reader

              ✓

        Writer

              waits

        Only ONE writer at a time.

        Use when reads >> writes.

        Complexity

        lock() O(1)

        Interview

        synchronized
            one lock

        ReadWriteLock
            separate read/write locks
        */
    }
}
