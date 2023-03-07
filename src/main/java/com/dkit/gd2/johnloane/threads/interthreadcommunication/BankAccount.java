package com.dkit.gd2.johnloane.threads.interthreadcommunication;

public class BankAccount
{
    private int balance = 0;
    private boolean isOpen = true;

    /* The method withdraws and amount from the account
     * If the account is empty, the thread will wait until
     * the account is refilled
     * @param amount the amount to withdraw
     * @return true if the withdrawal was successful, false otherwise
     * @exception InterruptedException if the thread is interrupted
     */
    public synchronized boolean withdraw(int amount) throws InterruptedException
    {
        while(this.balance < amount && this.isOpen)
        {
            System.out.println("Waiting for deposit ...");
            wait();
        }
        boolean result = false;
        if(this.isOpen)
        {
            this.balance -= amount;
            result = true;
        }
        return result;
    }

/* The method deposits an amount into the account provided that the account is open
     When the deposit is successful the thread will notify any waiting threads that there is now more money in the account
     * @param amount the amount to deposit
     * @return true if the deposit was successful, false otherwise
     */
    public synchronized boolean deposit(int amount)
    {
        boolean result = false;
        if(this.isOpen)
        {
            this.balance += amount;
            result = true;
            notifyAll();
        }
        return result;
    }

    public synchronized boolean isOpen()
    {
        return this.isOpen;
    }

    public synchronized void close()
    {
        this.isOpen = false;
        notifyAll();
    }
}
