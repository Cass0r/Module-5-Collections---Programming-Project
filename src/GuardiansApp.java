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

}//class
