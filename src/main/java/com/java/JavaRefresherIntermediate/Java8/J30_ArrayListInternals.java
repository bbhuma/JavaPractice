
package com.java.JavaRefresherIntermediate.Java8;
import java.util.*;
/*
J30_ArrayListInternals

Topics
- Object[]
- Capacity
- Resize
- ensureCapacity()
- trimToSize()
*/
public class J30_ArrayListInternals{
public static void main(String[]args){
ArrayList<Integer> list=new ArrayList<>();
list.add(10);list.add(20);list.add(30);
System.out.println(list);
/*
Internal

Object[]

0 1 2
10 20 30

get(index)

baseAddress + index

=> O(1)

add(end)

Usually O(1)

Resize occasionally.

Growth approximately 1.5x.

add(index)

Shift right.

O(n)

remove(index)

Shift left.

O(n)

ensureCapacity()

Avoid repeated resizing.

trimToSize()

Reduce unused memory.

Interview Memory

ArrayList
Fast Read
Slow Middle Insert/Delete
*/
}
}
