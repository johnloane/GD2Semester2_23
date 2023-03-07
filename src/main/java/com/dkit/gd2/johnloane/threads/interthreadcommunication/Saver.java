package com.dkit.gd2.johnloane.threads.interthreadcommunication;

//This class should run as a thread and deposit 100 euro to the account and then sleep for 1 second. You can only deposit to the account if the account is open.
public class Saver implements Runnable
{
    private BankAccount account;

    public Saver(BankAccount account)
    {
        this.account = account;
    }

    @Override
    public void run()
    {
        while(account.isOpen())
        {
            try
            {
                if(account.deposit(100))
                {
                    System.out.println("100 Deposit successful");
                }
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
