package com.dkit.gd2.johnloane.threads.stopthreads;

public class RepeatedMessage implements Runnable
{
    private static Object sharedLock = new Object();
    private String message;
    private int pauseTime;

    //Field stopFlag tells the thread when to stop. Declared volatile to ensure that the value of stopFlag is always read from main memory
    private volatile boolean stopFlag;

    /* Construct a repeating message thread
     * @param inputMessage the message to display
     * @param inputPauseTime the time, in ms,  to pause between each letter of the message
     */
    public RepeatedMessage(String inputMessage, int inputPauseTime)
    {
        message = inputMessage;
        pauseTime = inputPauseTime;
    }

    public static void displayMessage(RepeatedMessage rm)
    {
        synchronized (sharedLock)
        {
            for(int i=0; i< rm.message.length(); i++)
            {
                System.out.print(rm.message.charAt(i));
                try
                {
                    Thread.sleep(50);
                }
                catch (InterruptedException e)
                {
                    System.out.println("I was asleep but got interrupted");
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }

    @Override
    public void run()
    {
        stopFlag = false;
        try
        {
            while (!stopFlag)
            {
                displayMessage(this);
                Thread.currentThread().sleep(pauseTime);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("I was asleep but got interrupted");
            e.printStackTrace();
        }
    }

    public void finish()
    {
        stopFlag = true;
        return;
    }
}
