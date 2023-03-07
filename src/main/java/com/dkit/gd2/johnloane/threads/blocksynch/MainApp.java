package com.dkit.gd2.johnloane.threads.blocksynch;

public class MainApp
{
    public static void main(String[] args)
    {
        SynchBlock synchBlock = new SynchBlock();
        Thread t1 = new Thread(synchBlock);
        Thread t2 = new Thread(synchBlock);
        Thread t3 = new Thread(synchBlock);
        Thread t4 = new Thread(synchBlock);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try
        {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }
        catch(InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(synchBlock.getBuffer());
    }
}
