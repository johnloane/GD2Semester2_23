package com.dkit.gd2.johnloane.collectionsrevision;

//Populate a LinkedList with 20 randomly generated integers in the range 1 to 17 (non-adult ages). Write a function display( List list) to display the elements.
        //Display the list, sort the list, then display the sorted list.

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;


public class ChildAges
{
    public static void main(String[] args)
    {
        LinkedList<Integer> childAges = new LinkedList<>();
        populateList(childAges);
        displayList(childAges);
    }

    private static void displayList(LinkedList<Integer> childAges)
    {
        System.out.println("Child ages: " + childAges);
        Collections.sort(childAges);
        System.out.println("Sorted child ages: " + childAges);
    }

    private static void populateList(LinkedList<Integer> childAges)
    {
        Random random = new Random();
        for(int i=0; i<20; i++)
        {
            childAges.add(random.nextInt(17)+1);
        }
    }


}
