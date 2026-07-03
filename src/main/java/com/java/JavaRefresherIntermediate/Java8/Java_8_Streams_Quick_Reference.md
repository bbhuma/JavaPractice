# Java 8 Streams Quick Reference

  -------------------------------------------------------------------------------------------------------------
  Method                  Takes                        Example
  ----------------------- ---------------------------- --------------------------------------------------------
  map()                   Function\<T,R\>              `map(Employee::getSalary)`

  filter()                Predicate`<T>`{=html}        `filter(e -> e.getSalary()>50000)`

  sorted()                Comparator`<T>`{=html}       `sorted(Comparator.comparingInt(Employee::getSalary))`

  forEach()               Consumer`<T>`{=html}         `forEach(System.out::println)`

  reduce()                BinaryOperator`<T>`{=html}   `reduce(0,Integer::sum)`

  collect()               Collector                    `collect(Collectors.toList())`

  groupingBy()            Function\<T,K\>              `groupingBy(Employee::getDepartment)`

  partitioningBy()        Predicate`<T>`{=html}        `partitioningBy(e -> e.getSalary()>50000)`

  toMap()                 Key mapper + Value mapper    `toMap(Employee::getId, Employee::getName)`
  -------------------------------------------------------------------------------------------------------------

## Comparator

-   comparing()
-   comparingInt()
-   comparingLong()
-   comparingDouble()
-   thenComparing()
-   reversed()
-   naturalOrder()
-   reverseOrder()
-   nullsFirst()
-   nullsLast()

## Functional Interfaces

-   Function
-   Predicate
-   Consumer
-   Comparator
-   BinaryOperator
-   Collector
