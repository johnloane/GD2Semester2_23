package com.dkit.gd2.johnloane.threads.sharedresources;

public class Resource
{
    private boolean conFree;

    public Resource()
    {
        this.conFree = true;
    }

    public synchronized void getConnection(String name)
    {
        System.out.println(name + " Entered getConnection()");
        while(!conFree)
        {
            try
            {
                System.out.println(name + " Waiting for connection");
                wait();
                System.out.println(name + " notified in getConnection()");
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
        conFree = false;
        System.out.println(name + " got the Connection");
        notifyAll();
    }

    public synchronized void freeConnection(String name)
    {
        System.out.println(name + " Entered freeConnection()");
        while(conFree)
        {
            try
            {
                System.out.println(name + " Waiting for connection to be released");
                wait();
                System.out.println(name + " notified in freeConnection()");
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
        conFree = true;
        notifyAll();
    }
}
