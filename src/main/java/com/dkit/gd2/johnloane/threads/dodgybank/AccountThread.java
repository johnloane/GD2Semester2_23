package com.dkit.gd2.johnloane.threads.dodgybank;

public class AccountThread implements Runnable
{
    private Account account;

    public AccountThread(Account account)
    {
        this.account = account;
    }

    @Override
    public void run()
    {
        for(int i=0; i < 10; i++)
        {
            long start = System.currentTimeMillis();
            account.deposit(100);
            long end = System.currentTimeMillis();
            System.out.println("Deposit took " + (end - start) + " milliseconds");
        }
    }
}

