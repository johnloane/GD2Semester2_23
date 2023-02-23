package com.dkit.gd2.johnloane.threads.twothreads;

public class AddNToM implements Runnable
{
    private Calculator calculator;
    private int start;
    private int end;

    public AddNToM(Calculator calc, int start, int end)
    {
        this.calculator = calc;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run()
    {
        calculator.add(start, end);
    }
}
