/*
Jose Cartagena
202510 Object Oriented Programming COP-3330C-14319
10/4/2024

Problem Description
Write a Java program that accomplishes that demonstrates the use of the Collections framework and the Collection
interface.

Required Application Functionality
Your application must complete the following algorithm:

1. Create a List - Declare an ArrayList of Strings. Using a loop, and allow the user to add eight pieces of data
(just a single word) to the collection. Do not allow the user to enter duplicate entries, ignoring case.

2. Print the List - Print the list to the screen, using an enhanced for loop.  Also print the total number of entries,
the longest entry, and the shortest entry within the list.

3. Sort the List-  Using the method Collections.sort, sort the list and output it to the screen.  Include a header that
indicates that the list is now been sorted.

4. Custom Sort the List - sort the list by the number of characters in each string entered, from longest name to
shortest.  Include a header that indicates that the list is now been sorted by character length.

5. Shuffle the List - Using the shuffle method, shuffle the list and output it to the screen.  Include a header that
indicates that the list is now been sorted.

6. Search the List: Ask the user to provide a word to search for within the list.  If the data exists (ignoring case);
output the location where it was found. If the data does not exist, display a message to the user indicating this.

7. Implement at least 2 other static methods from the Collections class:  Research the documentation for the Collections
class and add at least 2 other static methods in your code.  You may pick which two methods to implement. Print the
results from each method call, and display a header that indicates what operation was just performed on the data.

8. Convert the List to an Array: Convert the list to an array using toArray. Output the elements of the array.

9. Convert the array back into a list. Output the elements of the list.  Include headers for both, indicating to the
user what output they see.

10. Comment on Collections vs. Collection:  In a // multi-line comment in your code //,  describe in your own words the
difference between Collections and Collection, and more broadly, the difference between a class and an interface. Please
be thorough yet succinct. Cite your sources.
*/

import java.util.*;


public class Collections_Project {
    public static void main(String[] args) {

// Using a loop, and allow the user to add eight pieces of data
//(just a single word) to the collection. Do not allow the user to enter duplicate entries, ignoring case.

//Declare an ArrayList of Strings.
        ArrayList<String> Color_List = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

//Using a loop, and allow the user to add eight pieces of data (just a single word) to the collection.
        System.out.println("Enter 8 colors (do not duplicate colors)");
        while (Color_List.size() < 8) {
            String input = sc.nextLine().trim();

//Do not allow the user to enter duplicate entries, ignoring case. (Cant use exception)
            boolean dup_Input = false;
            for (String word : Color_List) {
                if (word.equalsIgnoreCase(input)) {
                    dup_Input = true;
                    break;
                }
            }

            if (!dup_Input) {
                Color_List.add(input);
            } else {
                System.out.println("Word already exists. Please enter a different word.");
            }

        }//while

//Print the list to the screen , using an enhanced for loop.
        Collections.sort(Color_List);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Enhanced Loop(Sorted): ");
        for (String EnhancedList : Color_List){
            System.out.println(EnhancedList);
        }
        System.out.println("------------------------------------------------------------------------------");

//Also print the total number of entries, the longest entry, and the shortest entry within the list.
        System.out.println("Total number of entries: "+ Color_List.size());
        String Long = Collections.max(Color_List, (a, b) -> a.length() - b.length());
        String Short = Collections.min(Color_List, (a, b) -> a.length() - b.length());
        System.out.println("Longest Entry(max): " + Long + ", and shortest entry(min): " + Short);
        System.out.println("------------------------------------------------------------------------------");

//Custom Sort the List - sort the list by the number of characters in each string entered, from longest name to
//shortest.  Include a header that indicates that the list is now been sorted by character length.
        System.out.println("longest to shortest string name list(Sorted)");
        Collections.sort(Color_List, Comparator.comparingInt(String::length));
        System.out.println(Color_List.reversed());
        System.out.println("------------------------------------------------------------------------------");

//Shuffle the List - Using the shuffle method, shuffle the list and output it to the screen.  Include a header that
//indicates that the list is now been sorted.
        System.out.println("List has been shuffled(Shuffled)");
        Collections.shuffle(Color_List);
        System.out.println(Color_List);
        System.out.println("------------------------------------------------------------------------------");

//Search the List: Ask the user to provide a word to search for within the list.  If the data exists (ignoring case);
//output the location where it was found. If the data does not exist, display a message to the user indicating this.
        System.out.print("Please provide a word to search for within the list: ");
        String Word_Search = sc.nextLine().trim();
        System.out.println("Searching for: " + Word_Search);

        boolean dup_Input = false;
        for (String word : Color_List) {
            if (word.equalsIgnoreCase(Word_Search)) {
                dup_Input = true;
                System.out.println(Word_Search + " Found in " + Color_List.indexOf(word) + " colors.");
                break;
            }
        }

        if (!dup_Input) {
            System.out.println("Word does not exist. Please enter a different word.");
        }
        System.out.println("------------------------------------------------------------------------------");

//Implement at least 2 other static methods from the Collections class:  Research the documentation for the Collections
//class and add at least 2 other static methods in your code. You may pick which two methods to implement. Print the
//results from each method call, and display a header that indicates what operation was just performed on the data.
        System.out.println("\nConvert the List to an Array (Static Method 1)");
        String[] Color_to_Array = List_to_Array(Color_List);
        for (String word : Color_to_Array) {
            System.out.println(word);
        }

        System.out.println("\nConvert the Array to an List (Static Method 2)");
        List<String> Color_To_List = Array_To_List(Color_to_Array);
        for (String word : Color_To_List) {
            System.out.println(word);
        }

        System.out.println("------------------------------------------------------------------------------");
    }//main

//Convert the List to an Array: Convert the list to an array using toArray. Output the elements of the array.
    public static String[] List_to_Array(ArrayList<String> Color_List) {
        return Color_List.toArray(new String[0]);
    }

//Convert the array back into a list. Output the elements of the list.  Include headers for both, indicating to the
//user what output they see.
    public static List<String> Array_To_List(String[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

}//class

//Comment on Collections vs. Collection:  In a /* multi-line comment in your code, */ describe in your own words the
//difference between Collections and Collection, and more broadly, the difference between a class and an interface.
//Please be thorough yet succinct. Cite your sources.

/*                                      Collections vs. Collection
The easy to spot difference would be how collection itself is a interface while collections allows you to use
collections utilities like sort,max,min, etc. Collection can hold a static method while collections could be used for
static methods. Collection is more of a grander scale of use while collections can be used anytime within the class and
is easier to use with its multiple tools to deal with arrays and list. Collection represents the interface that can
only represent a group with a single unit while collections is a class of utility that can provide multiple utility
methods.

                                        Works cited
dishajindgar                                                                                                                                                                             Follow                                                                , et al. “Collection vs Collections in Java with Example.” GeeksforGeeks, 26 Feb. 2024, www.geeksforgeeks.org/collection-vs-collections-in-java-with-example/.
*/


/*                                      Code Comments: Class Purpose
The purpose of this class is to show thew many uses of array and collections can be used in, utilizing its many frame
works for many uses. This class used a basic list of 8 strings and shown many possible options to utilize the collection
and array functions.
*/

