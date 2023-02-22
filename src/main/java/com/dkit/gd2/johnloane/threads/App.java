package com.dkit.gd2.johnloane.threads;

public class App
{
    public static void main(String[] args)
    {
        //Create threads
        Thread printA = new Thread(new PrintChar('a', 100));
        Thread printB = new Thread(new PrintChar('b', 100));
        Thread print100 = new Thread(new PrintNum(100));

        //Start threads
        printA.start();
        printB.start();
        print100.start();
    }
}
