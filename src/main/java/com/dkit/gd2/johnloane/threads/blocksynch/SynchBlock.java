package com.dkit.gd2.johnloane.threads.blocksynch;

public class SynchBlock implements Runnable
{
    private StringBuffer buffer;
    private int balance;

    public SynchBlock()
    {
        this.buffer = new StringBuffer();
        this.balance = 0;
    }

    public StringBuffer getBuffer()
    {
        return buffer;
    }

    @Override
    public void run()
    {
        synchronized(buffer)
        {
            this.balance += 100;
            String message = "Balance : " + this.balance + System.getProperty("line.separator");
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
            buffer.append(message);
        }
    }
}
