package com.java.JavaRefresherIntermediate.Java8;
import java.util.*;
public class J07_OptionalMaster{
public static void main(String[]args){
/* WHY Optional?
Avoid NullPointerException.
Represents:
Value Present
or
Value Missing.

of() - value must exist
ofNullable() - value may be null
empty() - no value
orElse() - eager default
orElseGet() - lazy default
orElseThrow() - exception if absent
map() - transform Optional value
filter() - keep matching value
Interview: ★★★★★ */
Optional<String> name=Optional.of("John");
Optional<String> missing=Optional.ofNullable(null);
System.out.println(name.isPresent());
name.ifPresent(System.out::println);
System.out.println(missing.orElse("Default"));
System.out.println(missing.orElseGet(()->"Generated"));
System.out.println(name.map(String::length));
System.out.println(name.filter(s->s.startsWith("J")));
}}