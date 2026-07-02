package com.java.JavaRefresherIntermediate.Sessionn39;
import java.util.*;

public class ComparatorReference {

    public static void main(String[] args) {

        //=========================================================
        // 1. Integer Sorting (Ascending)
        //=========================================================
        Integer[] nums = {5, 2, 8, 1, 9};

        Arrays.sort(nums);

        System.out.println("Ascending Integer : " + Arrays.toString(nums));



        //=========================================================
        // 2. Integer Sorting (Descending)
        //=========================================================
        Arrays.sort(nums, Collections.reverseOrder());

        System.out.println("Descending Integer : " + Arrays.toString(nums));



        //=========================================================
        // 3. String Alphabetical Order
        //=========================================================
        String[] names = {"Banana", "Apple", "Orange", "Mango"};

        Arrays.sort(names);

        System.out.println(Arrays.toString(names));



        //=========================================================
        // 4. String Reverse Alphabetical Order
        //=========================================================
        Arrays.sort(names, Collections.reverseOrder());

        System.out.println(Arrays.toString(names));



        //=========================================================
        // 5. Sort String by Length
        //=========================================================
        Arrays.sort(names,
                (a, b) -> Integer.compare(a.length(), b.length()));

        System.out.println(Arrays.toString(names));



        //=========================================================
        // 6. int[][] Sort by First Column
        //=========================================================
        int[][] arr = {
                {5, 100},
                {2, 90},
                {8, 40},
                {1, 70}
        };

        Arrays.sort(arr,
                (a, b) -> Integer.compare(a[0], b[0]));

        System.out.println("\nSort by First Column");

        print2D(arr);



        //=========================================================
        // 7. int[][] Sort by Second Column
        //=========================================================
        Arrays.sort(arr,
                (a, b) -> Integer.compare(a[1], b[1]));

        System.out.println("\nSort by Second Column");

        print2D(arr);



        //=========================================================
        // 8. K Closest Points to Origin
        //=========================================================
        int[][] points = {
                {1, 3},
                {-2, 2},
                {5, 8},
                {0, 1}
        };

        Arrays.sort(points,
                (a, b) -> Integer.compare(
                        a[0] * a[0] + a[1] * a[1],
                        b[0] * b[0] + b[1] * b[1]
                ));

        System.out.println("\nClosest Points");

        print2D(points);



        //=========================================================
        // 9. Largest Number Problem
        //=========================================================
        String[] largest = {"3", "30", "34", "5", "9"};

        Arrays.sort(largest,
                (a, b) -> (b + a).compareTo(a + b));

        System.out.println(Arrays.toString(largest));



        //=========================================================
        //10. Smallest Number Problem
        //=========================================================
        Arrays.sort(largest,
                (a, b) -> (a + b).compareTo(b + a));

        System.out.println(Arrays.toString(largest));



        //=========================================================
        //11. Custom Object Sorting
        //=========================================================
        Employee[] employees = {

                new Employee("Ram", 50000),
                new Employee("Sita", 35000),
                new Employee("Krishna", 90000)
        };



        // Salary Ascending
        Arrays.sort(employees,
                (a, b) -> Integer.compare(a.salary, b.salary));

        System.out.println("\nSalary Asc");

        printEmployee(employees);



        // Salary Descending
        Arrays.sort(employees,
                (a, b) -> Integer.compare(b.salary, a.salary));

        System.out.println("\nSalary Desc");

        printEmployee(employees);



        // Name Ascending
        Arrays.sort(employees,
                (a, b) -> a.name.compareTo(b.name));

        System.out.println("\nName Asc");

        printEmployee(employees);



        //=========================================================
        //12. PriorityQueue Min Heap
        //=========================================================
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();



        //=========================================================
        //13. PriorityQueue Max Heap
        //=========================================================
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(
                        (a, b) -> Integer.compare(b, a));



        //=========================================================
        //14. PriorityQueue Custom Object
        //=========================================================
        PriorityQueue<Employee> pq =
                new PriorityQueue<>(
                        (a, b) -> Integer.compare(a.salary, b.salary));

    }






    static void print2D(int[][] arr) {

        for (int[] row : arr) {

            System.out.println(Arrays.toString(row));
        }
    }



    static void printEmployee(Employee[] arr) {

        for (Employee e : arr) {

            System.out.println(e.name + " " + e.salary);
        }
    }




    static class Employee {

        String name;
        int salary;

        Employee(String name, int salary) {

            this.name = name;
            this.salary = salary;
        }
    }

}