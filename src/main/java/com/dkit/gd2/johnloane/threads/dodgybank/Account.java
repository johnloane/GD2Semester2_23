package com.dkit.gd2.johnloane.threads.dodgybank;

public class Account
{
    private int balance;

    public Account()
    {
        this.balance = 0;
    }

    public Account(int balance)
    {
        this.balance = balance;
    }

    public synchronized void deposit(int amount)
    {
        int temp;
//        synchronized (this)
//        {
            temp = this.balance;


            try
            {
                Thread.sleep(500);
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
            temp += amount;
            this.balance = temp;
        //}
    }

    public void withdraw(int amount)
    {
        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        this.balance -= amount;
    }

    public int getBalance()
    {
        return this.balance;
    }
}
