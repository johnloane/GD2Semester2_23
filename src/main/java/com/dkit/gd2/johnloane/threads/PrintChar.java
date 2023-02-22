package com.dkit.gd2.johnloane.threads;

//Define a thread using the Thread class
//PrintChar will print a character a certain number of times
public class PrintChar implements Runnable
{
    private char charToPrint; //The character to print
    private int times; //The number of times to repeat

    //Construct a thread with a specified character to print and the number of times to print the character
    public PrintChar(char c, int t)
    {
        charToPrint = c;
        times = t;
    }

    //Override the run() method to tell the system what the task is for the thread
    @Override
    public void run()
    {
        for(int i=0; i<times; i++)
        {
            System.out.print(charToPrint);
        }
    }
}

