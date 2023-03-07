package com.dkit.gd2.johnloane.threads.lidlqueue;

import java.util.Queue;

import static com.dkit.gd2.johnloane.threads.lidlqueue.Colours.*;

public class CustomerQueue
{
    private Queue<Customer> customerQueue;

    public CustomerQueue(Queue<Customer> customerQueue)
    {
        this.customerQueue = customerQueue;
    }

    public synchronized void addCustomer(Customer customer)
    {
        this.customerQueue.add(customer);
        notifyAll();
        System.out.println(ANSI_BLUE+"Customer added"+ANSI_RESET);
    }

    public synchronized Customer removeCustomer()
    {
        Customer customer =  this.customerQueue.poll();
        if(customer == null)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return customer;
    }

    public int getQueueSize()
    {
        return this.customerQueue.size();
    }

    public Queue<Customer> getQueue()
    {
        return customerQueue;
    }
}
