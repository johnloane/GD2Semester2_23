package com.dkit.gd2.johnloane.threads.lidlqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class MainApp
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Lidl");
        Queue queue = new ArrayDeque();
        CustomerQueue customerQueue = new CustomerQueue(queue);
        Thread queueUp = new Thread(new QueueUp(customerQueue));
        Thread checkOut = new Thread(new CheckOut(customerQueue));
        Thread monitor = new Thread(new Monitor(customerQueue, 10));
        queueUp.start();
        checkOut.start();
        monitor.start();
    }
}
