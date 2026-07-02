
package com.java.JavaRefresherIntermediate.Java8;

import java.util.*;

/*
===============================================================================
J27_HashMapInternals.java

INTERVIEW EDITION

Goal:
Understand HOW HashMap works internally.

Interview Rating : ★★★★★
===============================================================================
*/
public class J27_HashMapInternals {

    static class Key{
        int id;
        Key(int id){this.id=id;}

        @Override
        public int hashCode(){
            return id % 4; // force collisions for demo
        }

        @Override
        public boolean equals(Object obj){
            if(this==obj) return true;
            if(!(obj instanceof Key)) return false;
            return id==((Key)obj).id;
        }

        public String toString(){ return "Key("+id+")"; }
    }

    public static void main(String[] args){

        /*
        ===========================================================================
        BIG PICTURE

                put(key,value)

                      |

                 hashCode()

                      |

                Bucket Index

                      |

          Empty? ---- Yes ----> Store Node

             |

            No

             |

         equals()

             |

        Same key?

        Yes -> Replace value

        No  -> Collision

        ===========================================================================
        */

        Map<Key,String> map = new HashMap<>();

        map.put(new Key(1),"John");
        map.put(new Key(5),"Alex");
        map.put(new Key(9),"David");

        System.out.println(map);

        /*
        WHY COLLISION?

        hashCode()

        1 % 4 = 1
        5 % 4 = 1
        9 % 4 = 1

        All go to SAME bucket.

        Java then uses equals()
        to distinguish keys.

        ===========================================================================
        LOAD FACTOR

        Default = 0.75

        Capacity = 16

        Resize after

            16 * 0.75 = 12 entries

        Resize

            16

              ↓

            32

        Rehash

            Recompute bucket indexes.

        ===========================================================================
        */

        /*
        JAVA 8

        Too many collisions?

        Linked List

              ↓

        Red Black Tree

        Called Treeification.

        Improves worst case.

        Before Java 8

            O(n)

        After Treeification

            O(log n)
        */

        /*
        INTERVIEW QUESTIONS

        1. Why power of 2 capacity?
        2. Why equals() and hashCode() together?
        3. What is load factor?
        4. What is rehashing?
        5. What is treeification?
        6. Why average O(1)?
        */
    }
}
