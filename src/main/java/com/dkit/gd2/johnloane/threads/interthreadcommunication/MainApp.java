package com.dkit.gd2.johnloane.threads.interthreadcommunication;

//Run the main thread for a specified number of seconds. The default will be 10 seconds but the user can pass in a command line argument for the number of seconds. Start two threads, a spender and a saver and let it run for the duration. Close the bank account before the program finishes
public class MainApp
{
    public static void main(String[] args)
    {
        BankAccount acc = new BankAccount();
        //Create a spender thread
        Spender spender = new Spender(acc);
        //Create a saver thread
        Saver saver = new Saver(acc);
        Thread saverThread = new Thread(saver);

        spender.start();
        saverThread.start();

        int time;
        if(args.length == 0)
        {
            time = 10000;
        }
        else
        {
            time = Integer.parseInt(args[0]) * 1000;
        }
        try
        {
            Thread.currentThread().sleep(time);
        }
        catch(InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        acc.close();
    }
}
