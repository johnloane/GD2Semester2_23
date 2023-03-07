package com.dkit.gd2.johnloane.threads.lidlqueue;

import static com.dkit.gd2.johnloane.threads.lidlqueue.Colours.ANSI_RED;
import static com.dkit.gd2.johnloane.threads.lidlqueue.Colours.ANSI_RESET;

public class Monitor implements Runnable
{
    private CustomerQueue queue;
    private int maxQueueSize;

    public Monitor(CustomerQueue queue, int maxQueueSize)
    {
        this.queue = queue;
        this.maxQueueSize = maxQueueSize;
    }

    @Override
    public void run()
    {
        boolean secondCheckoutOpen = false;
        while(true)
        {
            synchronized(queue)
            {
                if(queue.getQueueSize() > maxQueueSize && !secondCheckoutOpen)
                {
                    System.out.println(ANSI_RED+"Opening second checkout"+ANSI_RESET);
                    secondCheckoutOpen = true;
                    Thread checkOut2 = new Thread(new CheckOut(queue));
                    checkOut2.start();
                }
                else if(queue.getQueueSize() < maxQueueSize && secondCheckoutOpen)
                {
                    System.out.println(ANSI_RED+"Closing second checkout"+ANSI_RESET);
                    secondCheckoutOpen = false;
                }
                else {
                    try
                    {
                        queue.wait();
                    }
                    catch(InterruptedException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
