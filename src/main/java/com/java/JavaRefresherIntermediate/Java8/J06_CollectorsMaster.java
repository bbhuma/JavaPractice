package com.java.JavaRefresherIntermediate.Java8;
import java.util.*;import java.util.stream.*;
public class J06_CollectorsMaster{
static class Employee{int id;String name,dept;int age;double salary;Employee(int i,String n,String d,int a,double s){id=i;name=n;dept=d;age=a;salary=s;}int getId(){return id;}String getName(){return name;}String getDept(){return dept;}int getAge(){return age;}double getSalary(){return salary;}public String toString(){return name;}}
public static void main(String[]args){
List<Employee> e=List.of(new Employee(1,"John","IT",30,70000),new Employee(2,"Alex","HR",24,45000),new Employee(3,"David","IT",35,95000),new Employee(4,"Mary","Finance",28,62000));
/* J06_CollectorsMaster
WHY collect()?
Stream is only a pipeline.
collect() is a TERMINAL operation that materializes the result.

groupingBy()
Employee -> Department -> Map<Department,List<Employee>>

partitioningBy()
Always two groups: true / false

toMap()
List -> Map<Key,Value>
Duplicate keys require a merge function.

mapping()
Used inside groupingBy() to transform values.

joining()
Creates one String.

summarizingInt()
Returns count,sum,min,max,average in one pass.
Interview: ★★★★★ */
System.out.println(e.stream().map(Employee::getName).collect(Collectors.toList()));
System.out.println(e.stream().map(Employee::getDept).collect(Collectors.toSet()));
System.out.println(e.stream().collect(Collectors.groupingBy(Employee::getDept)));
System.out.println(e.stream().collect(Collectors.partitioningBy(x->x.salary>60000)));
System.out.println(e.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.mapping(Employee::getName,Collectors.toList()))));
System.out.println(e.stream().map(Employee::getName).collect(Collectors.joining(", ")));
System.out.println(e.stream().collect(Collectors.summarizingInt(Employee::getAge)));
}}