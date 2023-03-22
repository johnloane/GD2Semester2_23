package com.dkit.gd2.johnloane.threads.scheduledtasks;

public class MainApp
{
    public static void main(String[] args)
    {
        ScheduledTask hello1 = new ScheduledTask("Hello there");
        ScheduledTask hello2 = new ScheduledTask("Hello again");
        ScheduledTask hello3 = new ScheduledTask("How are you?");
        ScheduledTask hello4 = new ScheduledTask("I am great thanks, and you?");
        ScheduledTask hello5 = new ScheduledTask("I am good thanks");
        ScheduledTask hello6 = new ScheduledTask("Goodbye");

        java.util.Timer timer = new java.util.Timer();
        timer.schedule(hello1, 1000);
        timer.schedule(hello2, 2000);
        timer.schedule(hello3, 3000);
        timer.schedule(hello4, 4000);
        timer.schedule(hello5, 5000);
        timer.schedule(hello6, 6000);

        try
        {
            Thread.currentThread().sleep(7000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Main thread interrupted");
        }
        System.out.println("All done");

    }
}
