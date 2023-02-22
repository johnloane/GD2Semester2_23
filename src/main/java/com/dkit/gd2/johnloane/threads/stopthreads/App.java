package com.dkit.gd2.johnloane.threads.stopthreads;

public class App
{
    public static void main(String[] args)
    {
        RepeatedMessage m1 = new RepeatedMessage("Hello", 1000);
        Thread m1t = new Thread(m1);
        m1t.start();
        RepeatedMessage m2 = new RepeatedMessage("Hola", 1000);
        Thread m2t = new Thread(m2);
        RepeatedMessage m3 = new RepeatedMessage("Bonjour", 1000);
        Thread m3t = new Thread(m3);
        m3t.start();
        RepeatedMessage m4 = new RepeatedMessage("Kamusta", 1000);
        Thread m4t = new Thread(m4);
        m4t.start();
        RepeatedMessage m5 = new RepeatedMessage("Salam", 1000);
        Thread m5t = new Thread(m5);
        m5t.start();
        RepeatedMessage m6 = new RepeatedMessage("Ahoj", 1000);
        Thread m6t = new Thread(m6);
        m6t.start();
        RepeatedMessage m7 = new RepeatedMessage("Labas", 1000);
        Thread m7t = new Thread(m7);
        m7t.start();

        try
        {
            Thread.currentThread().sleep(10000);
            m1.finish();
            m2.finish();
            m3.finish();
            m4.finish();
            m5.finish();
            m6.finish();
            m7.finish();
        }
        catch(InterruptedException e)
        {
            System.out.println("I was asleep but got interrupted");
            e.printStackTrace();
        }
        finally
        {
            //Flush the output buffer
            System.out.println();
        }

    }

}
