package com.java.JavaRefresherIntermediate.Java8;
/*
====================================================================
03_Collectors.java
Java Interview Handbook
====================================================================

This chapter focuses on Collectors.

Interview Importance : ★★★★★

Most Frequently Asked

✓ collect()
✓ toList()
✓ toSet()
✓ toMap()
✓ groupingBy()
✓ partitioningBy()
✓ mapping()
✓ counting()
✓ joining()
✓ summingInt()
✓ averagingInt()
✓ summarizingInt()
✓ maxBy()
✓ minBy()

Think of Collectors as:

      Stream
         │
         ▼
  "How do you want the final result?"

====================================================================
*/

import java.util.*;
import java.util.stream.*;

public class J03CollectorsMaster {

    static class Employee {

        int id;
        String name;
        String department;
        int age;
        double salary;

        Employee(int id,String name,String department,int age,double salary){
            this.id=id;
            this.name=name;
            this.department=department;
            this.age=age;
            this.salary=salary;
        }

        public int getId(){ return id; }
        public String getName(){ return name; }
        public String getDepartment(){ return department; }
        public int getAge(){ return age; }
        public double getSalary(){ return salary; }

        public String toString(){
            return name+"("+department+","+salary+")";
        }
    }

    public static void main(String[] args){

        List<Employee> employees = List.of(
            new Employee(1,"John","IT",30,70000),
            new Employee(2,"Alex","HR",24,45000),
            new Employee(3,"David","IT",35,95000),
            new Employee(4,"Bob","Finance",31,65000),
            new Employee(5,"Mary","HR",29,55000)
        );

        /*
        ============================================================
        collect()

        collect() is TERMINAL OPERATION.

        All intermediate operations are lazy.

        Nothing executes until collect() (or another terminal
        operation) is reached.

        Stream
             ↓
        filter()
             ↓
        map()
             ↓
        collect()

        Think:
        "Bring the pipeline result back into Java."
        ============================================================
        */

        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println(names);

        /*
        ============================================================
        Collectors.toList()

        Returns List.

        Equivalent for-loop

        List<String> list = new ArrayList<>();

        for(Employee e:employees)
            list.add(e.getName());

        Interview:
        toList() is the collector version.
        Stream.toList() is the newer convenience method.

        Prefer Stream.toList() when possible.
        ============================================================
        */

        List<String> list = employees.stream()
                .map(Employee::getName)
                .toList();

        System.out.println(list);

        /*
        ============================================================
        Collectors.toSet()

        Removes duplicates naturally because Set
        cannot contain duplicate values.

        Stream
           ↓
        Set

        Use when uniqueness matters.
        ============================================================
        */

        Set<String> departments =
                employees.stream()
                        .map(Employee::getDepartment)
                        .collect(Collectors.toSet());

        System.out.println(departments);

        /*
        ============================================================
        Collectors.toMap()

        PURPOSE

        Convert Stream into Map.

        Employee

             ↓

        id -> Employee

        Result

        Map<Integer,Employee>

        Equivalent loop

        Map<Integer,Employee> map = new HashMap<>();

        for(Employee e:employees){
            map.put(e.getId(),e);
        }

        Common Interview Question

        What happens if duplicate keys exist?

        Answer

        IllegalStateException

        Solution

        Provide merge function.

        toMap(key,value,(old,new)->old)
        ============================================================
        */

        Map<Integer,Employee> employeeMap =
                employees.stream()
                        .collect(Collectors.toMap(
                                Employee::getId,
                                e->e
                        ));

        System.out.println(employeeMap);

        /*
        ============================================================
        groupingBy()

        MOST IMPORTANT COLLECTOR

        Employee List

             ↓

        Department

             ↓

        Map<Department,List<Employee>>

        Result

        IT

            John
            David

        HR

            Alex
            Mary

        Finance

            Bob

        Equivalent Loop

        for(Employee e:employees){

            map.computeIfAbsent(
                e.department,
                k->new ArrayList<>());

            map.get(e.department).add(e);

        }

        Interview Frequency

        ★★★★★
        ============================================================
        */

        Map<String,List<Employee>> grouped =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment));

        System.out.println(grouped);

        /*
        ============================================================
        partitioningBy()

        Difference

        groupingBy()

            Many Groups

        partitioningBy()

            ONLY TWO GROUPS

            true
            false

        Example

        Salary > 60000

        true

        false

        Returns

        Map<Boolean,List<Employee>>
        ============================================================
        */

        Map<Boolean,List<Employee>> partition =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                e->e.salary>60000));

        System.out.println(partition);

        /*
        ============================================================
        mapping()

        Used INSIDE groupingBy()

        Without mapping

        Department

            ↓

        Employees

        With mapping

        Department

            ↓

        Employee Names

        Result

        IT -> [John, David]

        Instead of

        IT -> Employee Objects
        ============================================================
        */

        Map<String,List<String>> namesByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )));

        System.out.println(namesByDept);

        /*
        ============================================================
        joining()

        Join strings.

        John,Alex,David

        Equivalent

        StringBuilder
        ============================================================
        */

        String joined =
                employees.stream()
                        .map(Employee::getName)
                        .collect(Collectors.joining(", "));

        System.out.println(joined);

        /*
        ============================================================
        counting()

        Count after grouping.

        IT -> 2

        HR -> 2

        Finance ->1
        ============================================================
        */

        Map<String,Long> counts =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()));

        System.out.println(counts);

        /*
        ============================================================
        summingInt()

        Sum integer property.

        Equivalent

        int sum=0;

        for(...)

        ============================================================
        */

        int totalAge =
                employees.stream()
                        .collect(Collectors.summingInt(
                                Employee::getAge));

        System.out.println(totalAge);

        /*
        ============================================================
        averagingInt()

        Average integer property.
        ============================================================
        */

        double avgAge =
                employees.stream()
                        .collect(Collectors.averagingInt(
                                Employee::getAge));

        System.out.println(avgAge);

        /*
        ============================================================
        summarizingInt()

        One pass statistics.

        count

        sum

        average

        max

        min

        Returns

        IntSummaryStatistics

        Very common interview API.
        ============================================================
        */

        IntSummaryStatistics stats =
                employees.stream()
                        .collect(Collectors.summarizingInt(
                                Employee::getAge));

        System.out.println(stats);

        /*
        ============================================================
        maxBy()

        Highest salary employee.
        ============================================================
        */

        Optional<Employee> highest =
                employees.stream()
                        .collect(Collectors.maxBy(
                                Comparator.comparingDouble(
                                        Employee::getSalary)));

        System.out.println(highest);

        /*
        ============================================================
        minBy()

        Lowest salary employee.
        ============================================================
        */

        Optional<Employee> lowest =
                employees.stream()
                        .collect(Collectors.minBy(
                                Comparator.comparingDouble(
                                        Employee::getSalary)));

        System.out.println(lowest);

        /*
        ============================================================

        INTERVIEW THINKING PROCESS

        Need unique values?

            toSet()

        Need HashMap?

            toMap()

        Need group by department?

            groupingBy()

        Need TRUE/FALSE split?

            partitioningBy()

        Need only names after grouping?

            mapping()

        Need comma separated string?

            joining()

        Need total?

            summingInt()

        Need average?

            averagingInt()

        Need complete statistics?

            summarizingInt()

        Need highest?

            maxBy()

        Need lowest?

            minBy()

        ============================================================

        TOP 10 STREAM QUESTIONS

        1. Group employees by department
        2. Count employees per department
        3. Highest salary by department
        4. Average salary by department
        5. Convert List to Map
        6. Duplicate key in toMap?
        7. Difference between groupingBy and partitioningBy
        8. summarizingInt vs averagingInt
        9. Stream.toList vs Collectors.toList
        10. When does stream actually execute?
           (Terminal operation)

        ============================================================
        */
    }
}
