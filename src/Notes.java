public class Notes {
}
/*

Collections is an object that represents a group of objects(Data structure). Java collections framework includes the
interface like list, set, and a map, and classes like arraylist, linkedlist, hashset, and hashmap.

Collections class is a utility class in java.util package. Provides static methods for common task on collections
such as sorting and searching.

facts:
1.	A Set is an ordered collection. -false
2.	All Java core collection interfaces are generic. -true
3.	A List is an ordered collection. -true
4.	This type of collection allows insertions and removals to be performed only at the front of the list. -stack
5.	A collection represents a group of objects known as its _______________. -elements
6.	A(n) _______________ is a collection used to hold multiple elements prior to processing. -queue
7.	A HashMap is a sorted list. -false
8.	A List is a collection that can contain duplicate elements. -true
9.	A Set is a collection that can contain duplicate elements. -false
10.	Each element in a LinkedList is known as a(n) _______________. -node

------------------------------------------Example-----------------------------------------------------------------------
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsExample {
    public static void main(String[] args) {
        List<Interger> numbers = Arrays.asList(5,3,7,1,4);
        Collections.sort(numbers);                                  //Sort is a static method
        System.out.println(numbers);
    }
}
------------------------------------------------------------------------------------------------------------------------
Best to look up the collections list like how sort is used here

Array is a simple fixed size data structure that holds elements of the same type while a collection is more flexible.
it can grow and shrink in size dynamically and can hold objects of different types(if no generally specified).
Collections also come with more utility methods.

List is ordered collections that can contain duplicated elements, while array list is implementation of the interface,
backed by a dynamic array, providing fast access and insertion operations.


Now for a large example code that uses Collections
------------------------------------------Example Code------------------------------------------------------------------
//The guardians will creat a collection of characters from guardians of the galaxy, and showcase some features of the
//java collection framework.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GuardiansApp {
    public static void main(String[] args) {

        //list is a interface represents an ordered collection
        //ArrayList is an implementation of the list interface that uses a dynamic array
        List<String> guardians = new ArrayList<>();

        //add som elements to the list
        guardians.add("Star Lord");
        guardians.add("Gamora");
        guardians.add("Drax");
        guardians.add("Rocket");
        guardians.add("Groot");
        //guardians.. it'll show you more elements

        //sort the list using static method from collections class
        //reminder - static methods mean we don't have to instantiate an object to use them
        Collections.sort(guardians);

        System.out.println("Here is the list of the Guardians: " + guardians);
        //using the  Collections.sort(); sorts them in alphabetical order

        //Convert list to array
        String [] guardiansArray = guardians.toArray(new String[0]);
        System.out.println("Here is the Array of the Guardians: ");
        for (String s: guardiansArray) {
            System.out.println(s.toString()); }
        //Array list up to down

        //Custom sort: sort the collection by number of vowels in each time(before the sort., options will appear, use comparator

        //Comparator is a interface that defines a compare method for custom sorting of objects. In this implementation we
        //override the compare method to return the difference in the number of vowels between two strings objects. The
        //Collections.sort method uses this compare method to determine the sorting order.For each pair of elements in the
        //list, it compares their vowel counts using the overridden compare method. The list is then sorted based on this
        //comparison; a negative result indicates the first string has fewer vowels than the second, a positive result
        //indicates it has more, and zero indicates equal vowel counts. This process iterates through the entire list,
        //using our comparator to determine the final sorted order based on vowel count.

        Collections.sort(guardians, new Comparator<String>()  {  //import comparator class to use

            @Override
            public int compare(String o1,String o2) {
                return countVowels(o1) - countVowels(o2);
            }
        });// for the parentheses in line 82 next to sort

        //print results of custom
        System.out.println("Guardians sorted by number of vowels: " +  guardians);

    } //from main




    //Static method to count number of vowels in a string
    private static int countVowels(String name){
        int count = 0;
        //use an enhanced for loop to iterate through the name, converted to an array of characters
        for (char c: name.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o'); {
                count++;
            }
        }
        return count;
    }

}

*/