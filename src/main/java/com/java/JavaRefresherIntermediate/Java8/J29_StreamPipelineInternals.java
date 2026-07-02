
package com.java.JavaRefresherIntermediate.Java8;
import java.util.*;import java.util.stream.*;
/*
J29_StreamPipelineInternals
- Lazy evaluation
- ReferencePipeline
- Spliterator
- AbstractPipeline
- Sink
*/
public class J29_StreamPipelineInternals{
public static void main(String[]args){
List<String> names=Arrays.asList("John","Alex","David","Bob");
/*
Pipeline

List
 |
stream()
 |
map()
 |
filter()
 |
toList()

map() and filter() DO NOT execute immediately.

Only the terminal operation (toList) starts iteration.

Simplified Flow

List
 |
Spliterator
 |
ReferencePipeline
 |
map.apply()
 |
filter.test()
 |
Sink.accept()
 |
Result

Dry Run

John -> 4 -> pass
Alex -> 4 -> pass
Bob  -> 3 -> fail
David-> 5 -> pass

Result = [4,4,5]

Interview:
Why Streams are lazy?
Answer:
To combine operations into one traversal.
*/
System.out.println(names.stream().map(String::length).filter(n->n>3).toList());
}
}
