package com.scaler.JavaRefresherIntermediate.Session8.ArrayLists;
import java.util.*;

/**
 * A reference class to illustrate most commonly used methods of ArrayList,
 * compare Arrays vs ArrayList, and cover typical interview questions.
 */
public class ArrayListConceptsDemo {

    public static void main(String[] args) {
        // Demonstrating differences between arrays and ArrayLists
        arraysVsArrayList();

        // Basic operations
        addElements();
        accessElements();
        updateElements();
        removeElements();

        // Searching
        linearSearch();
        binarySearchOnSortedList();

        // Iteration examples
        iterateWithForEach();
        iterateWithIterator();

        // Conversion
        convertArrayListToArray();
        convertArrayToArrayList();

        // Copying
        copyArrayList();

        // Interview style problems
        rotateArrayList();
        reverseArrayList();
        findFrequency();
        checkContainsElement();
        subListExample();
    }

    /** -------------------------------
     * Arrays vs ArrayList differences
     * ------------------------------- */
    static void arraysVsArrayList() {
        System.out.println("=== Arrays vs ArrayList ===");

        // Array (fixed size)
        String[] arr = new String[3];
        arr[0] = "Apple";
        arr[1] = "Banana";
        arr[2] = "Mango";
        System.out.println("Array: " + Arrays.toString(arr));

        // ArrayList (dynamic size, flexible)
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");
        list.add("Orange"); // can grow dynamically
        System.out.println("ArrayList: " + list);

        System.out.println("Advantages of ArrayList over Array:");
        System.out.println("1. Dynamic size (no need to predefine size).");
        System.out.println("2. Built-in methods for add, remove, search, sort.");
        System.out.println("3. Easier to iterate (enhanced for-loop, streams).");
        System.out.println("4. Can store null values and duplicates.");
        System.out.println();
    }

    /** Adding elements to ArrayList */
    static void addElements() {
        System.out.println("=== Adding Elements ===");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); // add at end
        list.add(20);
        list.add(30);
        list.add(1, 15); // add at index
        System.out.println("List after additions: " + list);
    }

    /** Accessing elements in ArrayList */
    static void accessElements() {
        System.out.println("=== Accessing Elements ===");
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        System.out.println("Element at index 1: " + list.get(1)); // random access O(1)
    }

    /** Updating elements */
    static void updateElements() {
        System.out.println("=== Updating Elements ===");
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Red", "Blue", "Green"));
        list.set(1, "Yellow"); // update index 1
        System.out.println("After update: " + list);
    }

    /** Removing elements */
    static void removeElements() {
        System.out.println("=== Removing Elements ===");
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Dog", "Cat", "Cow"));
        list.remove("Cat"); // remove by value
        list.remove(1);     // remove by index
        System.out.println("After removals: " + list);
    }

    /** Linear search in ArrayList */
    static void linearSearch() {
        System.out.println("=== Linear Search ===");
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        int key = 30;
        int index = list.indexOf(key); // returns -1 if not found
        System.out.println("Index of " + key + ": " + index);
    }

    /** Binary search (only on sorted list) */
    static void binarySearchOnSortedList() {
        System.out.println("=== Binary Search ===");
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        Collections.sort(list);
        int index = Collections.binarySearch(list, 30);
        System.out.println("Binary search index of 30: " + index);
    }

    /** Iterating using for-each loop */
    static void iterateWithForEach() {
        System.out.println("=== Iterating with For-Each ===");
        ArrayList<String> list = new ArrayList<>(Arrays.asList("One", "Two", "Three"));
        for (String s : list) {
            System.out.println(s);
        }
    }

    /** Iterating using Iterator */
    static void iterateWithIterator() {
        System.out.println("=== Iterating with Iterator ===");
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Alpha", "Beta", "Gamma"));
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /** Convert ArrayList to Array */
    static void convertArrayListToArray() {
        System.out.println("=== Convert ArrayList to Array ===");
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Red", "Blue", "Green"));
        String[] arr = list.toArray(new String[0]); // recommended way
        System.out.println("Converted array: " + Arrays.toString(arr));
    }

    /** Convert Array to ArrayList */
    static void convertArrayToArrayList() {
        System.out.println("=== Convert Array to ArrayList ===");
        String[] arr = {"Sun", "Moon", "Star"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println("Converted ArrayList: " + list);
    }

    /** Copy ArrayList into another */
    static void copyArrayList() {
        System.out.println("=== Copy ArrayList ===");
        ArrayList<Integer> original = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> copy = new ArrayList<>(original); // copy constructor
        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);
    }

    /** Rotate elements using Collections.rotate() */
    static void rotateArrayList() {
        System.out.println("=== Rotate ArrayList ===");
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.rotate(list, 2); // right shift by 2
        System.out.println("After rotation: " + list);
    }

    /** Reverse ArrayList */
    static void reverseArrayList() {
        System.out.println("=== Reverse ArrayList ===");
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        Collections.reverse(list);
        System.out.println("Reversed: " + list);
    }

    /** Find frequency of element */
    static void findFrequency() {
        System.out.println("=== Frequency of Element ===");
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "A", "C", "A"));
        int freq = Collections.frequency(list, "A");
        System.out.println("Frequency of 'A': " + freq);
    }

    /** Check if ArrayList contains an element */
    static void checkContainsElement() {
        System.out.println("=== Check Contains ===");
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));
        System.out.println("List contains 20? " + list.contains(20));
    }

    /** Demonstrating subList (view of part of list) */
    static void subListExample() {
        System.out.println("=== SubList Example ===");
        ArrayList<String> list = new ArrayList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        List<String> sub = list.subList(1, 4); // from index 1 to 3
        System.out.println("Sublist: " + sub);
    }
}
