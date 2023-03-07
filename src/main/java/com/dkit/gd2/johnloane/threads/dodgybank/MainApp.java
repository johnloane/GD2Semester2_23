package com.dkit.gd2.johnloane.threads.dodgybank;

public class MainApp
{
    public static void main(String[] args)
    {
        Account account = new Account(500);
        AccountThread accountThread = new AccountThread(account);
        Thread t1 = new Thread(accountThread);
        Thread t2 = new Thread(accountThread);
        Thread t3 = new Thread(accountThread);
        t1.start();
        t2.start();
        t3.start();
        try
        {
            t1.join();
            t2.join();
            t3.join();
        }
        catch(InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Final balance is " + account.getBalance());
    }
}

