package com.dkit.gd2.johnloane.threads.twothreads;

public class App
{
    public static void main(String[] args)
    {
        Calculator million = new Calculator();
        AddNToM a1 = new AddNToM(million, 1,500000);
        Thread a1T = new Thread(a1);
        long start = System.currentTimeMillis();
        a1T.start();
        AddNToM a2 = new AddNToM(million, 500001, 1000000);
        Thread a2T = new Thread(a2);
        a2T.start();
        //Wait for a1T and a2T to finish
        try
        {
            a1T.join();
            a2T.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(million.getTotal());
        long end = System.currentTimeMillis();
        System.out.println("Time taken = " + (end - start) + "ms");
    }
}
