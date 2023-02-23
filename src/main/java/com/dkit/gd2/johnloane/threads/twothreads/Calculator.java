package com.dkit.gd2.johnloane.threads.twothreads;

public class Calculator
{
    private long total = 0;

    public synchronized void add(int n, int m)
    {
        long localTotal = 0;
        for(int i=n; i<=m; i++)
        {
            localTotal += i;
        }

        total += localTotal;

    }

    public long getTotal()
    {
        return total;
    }
}
