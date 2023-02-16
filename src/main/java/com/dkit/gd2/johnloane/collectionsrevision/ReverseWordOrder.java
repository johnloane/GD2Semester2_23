package com.dkit.gd2.johnloane.collectionsrevision;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;

//Write a program that reads text from a (whitespace-delimited) file and outputs it in reverse word order.
public class ReverseWordOrder
{
    private Stack<String> words;

    public ReverseWordOrder()
    {
        words = new Stack<>();
    }
    public static void main(String[] args)
    {
        ReverseWordOrder rwo = new ReverseWordOrder();
        rwo.readWordsFromFile();
        rwo.printWordsInReverseOrder();
    }

    private void printWordsInReverseOrder()
    {
        while(!words.isEmpty())
        {
            System.out.println(words.pop());
        }
    }

    private void readWordsFromFile()
    {
        try(FileReader fr = new FileReader("words.txt");
            BufferedReader br = new BufferedReader(fr))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] wordsFromFile = line.split(" ");
                for(String word : wordsFromFile)
                {
                    words.add(word);
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found: " + e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println("Problem reading file: " + e.getMessage());
        }
    }
}
