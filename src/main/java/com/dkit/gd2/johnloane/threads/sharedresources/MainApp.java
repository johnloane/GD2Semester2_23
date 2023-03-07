package com.dkit.gd2.johnloane.threads.sharedresources;

public class MainApp
{
    public static void main(String[] args)
    {
        Resource resource = new Resource();
        Thread t1 = new Thread(new AccessResource(resource, "Thread 1"));
        Thread t2 = new Thread(new AccessResource(resource, "Thread 2"));
        Thread t3 = new Thread(new AccessResource(resource, "Thread 3"));
        t1.start();
        t2.start();
        t3.start();
    }
}
