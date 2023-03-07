package com.dkit.gd2.johnloane.threads.lidlqueue;

public class QueueUp implements Runnable
{
    private CustomerQueue queue;

    public QueueUp(CustomerQueue queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep((long) (Math.random() * 1000 + 1500));
            } catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
            Customer customer = generateNewCustomer();
            queue.addCustomer(customer);
        }
    }

    private Customer generateNewCustomer()
    {
        Customer newCustomer = new Customer();
        newCustomer.addToBasket("Bread");
        newCustomer.addToBasket("Milk");
        newCustomer.addToBasket("Eggs");
        return newCustomer;
    }
}
