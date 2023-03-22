package com.dkit.gd2.johnloane.threads.scheduledtasks;

import java.util.TimerTask;

public class ScheduledTask extends TimerTask
{
    private String message;

    public ScheduledTask(String taskName)
    {
        this.message = taskName;
    }

    @Override
    public void run()
    {
        System.out.println(message);
    }
}
