package com.dkit.gd2.johnloane.threads.javaconcurrent;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;


public class MainApp
{
    private static final String EOF = "EOF";

    public static void main(String[] args)
    {
        //Note ArrayList is NOT thread safe
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_BLUE, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

    }
}
