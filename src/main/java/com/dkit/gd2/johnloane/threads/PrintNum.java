package com.dkit.gd2.johnloane.threads;

//Print numbers from 1 to n for a given n
public class PrintNum implements Runnable
{
    private int lastNum;

    public PrintNum(int n)
    {
        lastNum = n;
    }

    @Override
    public void run()
    {
        for(int i=1; i<=lastNum; i++)
        {
            System.out.print(" " + i);
        }
    }
}

