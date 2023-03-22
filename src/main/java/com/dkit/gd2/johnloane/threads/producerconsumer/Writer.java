package com.dkit.gd2.johnloane.threads.producerconsumer;

import java.util.Random;

public class Writer implements Runnable
{
    private Message message;

    public Writer(Message message)
    {
        this.message = message;
    }

    @Override
    public void run()
    {
        String[] messages =
                {"Humpty dumpty sat on a wall", "Humpty dumpty had a great fall", "All the king's horses and all the kings men", "Couldn't put Humpty together again"};
        Random random = new Random();

        for(int i=0; i<messages.length; i++)
        {
            message.write(messages[i]);
            try
            {
                Thread.sleep(random.nextInt(2000));
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
        message.write("Finished");

    }

}
