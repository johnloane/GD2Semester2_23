package com.dkit.gd2.johnloane;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Collections
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Collections" );
        linkedListDemo();
        linkedListQuestion1();
        LinkedList<String> words = new LinkedList<>();
        populateLinkedList(words);
        linkedListQuestion2(words);
        linkedListQuestion3(words);
        setDemo();
    }

    private static void setDemo()
    {

    }

    private static void populateLinkedList(LinkedList<String> words)
    {
        words.add("Hello");
        words.add("World");
        words.add("I");
        words.add("Am");
        words.add("John");
        words.add("Loane");
        words.add("I");
        words.add("Am");
        words.add("A");
        words.add("Student");
    }

    private static void linkedListQuestion3(LinkedList<String> words)
    {
        //Write a loop that prints every second element of a lined list of strings called words
        ListIterator<String> iter = words.listIterator();
        while(iter.hasNext())
        {
            System.out.println(iter.next());
            if(iter.hasNext())
            {
                iter.next();
            }
        }


    }

    private static void linkedListQuestion2(LinkedList<String> words)
    {
        // Write a loop that removes all strings with length less a parameter n from a linked list of strings called words


        int minWordLength = 4;
        removeWorldsLessThanFour(words, minWordLength);
    }

    private static void removeWorldsLessThanFour(LinkedList<String> words, int minWordLength)
    {
        ListIterator<String> iter = words.listIterator();
        while(iter.hasNext())
        {
            String word = iter.next();
            if(word.length() < minWordLength)
            {
                iter.remove();
            }
        }
        System.out.println(words);
    }

    private static void linkedListQuestion1()
    {
        /*Suppose the list lst contains elements "A", "B", "C", and "D". Draw the contents of the list and the iterator position for the following operations:
         */
        LinkedList<String> letters = new LinkedList<>();
        ListIterator<String> iter = letters.listIterator();
        iter.add("A");
        iter.add("B");
        iter.add("C");
        iter.add("D");    // A B C D|
        //Reset the iterator to the beginning of the list
        iter = letters.listIterator(); // |A B C D
        iter.next(); // A |B C D
        iter.next(); // A B |C D
        iter.remove(); // A B |D
        iter.next(); // A B D |
        iter.add("E"); // A B D E |
        System.out.println(iter.next()); // A B D E |
        iter.next();
        iter.add("F"); // A B D E F |
    }

    private static void linkedListDemo()
    {
        LinkedList<String> oopClassNames = new LinkedList<>();
        oopClassNames.add("Daniel");
        oopClassNames.add("Dovydas");
        oopClassNames.add("Dzeraldas");
        oopClassNames.add("Marko");

        // | in the comments below indicates the current position of the iterator

        ListIterator<String> iterator = oopClassNames.listIterator(); // |Daniel Dovydas Dzeraldas Marko
        iterator.next(); // Daniel |Dovydas Dzeraldas Marko
        iterator.next(); // Daniel Dovydas |Dzeraldas Marko

        // Add more elements after the second element
        iterator.add("Dominik"); // Daniel Dovydas Dominik |Dzeraldas Marko
        iterator.add("Keven"); // Daniel Dovydas Dominik Kevin |Dzeraldas Marko

        iterator.next(); // Daniel Dovydas Dominik Kevin Dzeraldas |Marko

        // Remove the last traversed element
        iterator.remove(); // Daniel Dovydas Dominik Kevin |Marko

        //Print all elements
        System.out.println(oopClassNames);
        System.out.println("Expected: [Daniel, Dovydas, Dominik, Kevin, Marko]");

    }
}
