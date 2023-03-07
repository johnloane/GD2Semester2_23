package com.dkit.gd2.johnloane.threads.lidlqueue;

import static com.dkit.gd2.johnloane.threads.lidlqueue.Colours.ANSI_GREEN;
import static com.dkit.gd2.johnloane.threads.lidlqueue.Colours.ANSI_RESET;

public class CheckOut implements Runnable
{
    private CustomerQueue queue;

    public CheckOut(CustomerQueue queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        while(true)
        {
            Customer customer = queue.removeCustomer();
            if(customer != null)
            {
                try
                {
                    Thread.sleep(customer.getShoppingBasket().size() * 1000);
                } catch (InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
                System.out.println(ANSI_GREEN + "Customer served" + ANSI_RESET);
            }
        }
    }
}
