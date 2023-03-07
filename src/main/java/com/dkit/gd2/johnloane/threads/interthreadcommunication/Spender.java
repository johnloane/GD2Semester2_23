package com.dkit.gd2.johnloane.threads.interthreadcommunication;

//The Spender should try to withdraw 500 euro from the account every 1 second. If the account is not open you can't spend
public class Spender extends Thread
{
    private BankAccount account;

    public Spender(BankAccount account)
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
                if(account.withdraw(500))
                {
                    System.out.println("500 Withdrawal successful");
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
