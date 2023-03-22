package com.dkit.gd2.johnloane.threads.producerconsumer;

public class Message
{
    private String message;
    private boolean empty = true;

    public synchronized String read()
    {
        while(empty)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message)
    {
        while(!empty)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}
