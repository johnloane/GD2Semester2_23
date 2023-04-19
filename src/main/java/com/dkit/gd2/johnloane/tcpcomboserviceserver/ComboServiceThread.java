package com.dkit.gd2.johnloane.tcpcomboserviceserver;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ComboServiceThread extends Thread
{
    private Socket dataSocket;
    private Scanner input;
    private PrintWriter output;
    private int number;

    //Constructor needs:
    //1. A socket to communicate with the client
    public ComboServiceThread(ThreadGroup group, String name, Socket dataSocket, int number)
    {
        super(group, name);
        try
        {
            this.dataSocket = dataSocket;
            this.number = number;

            //Create stream for reading from the client
            input = new Scanner(new InputStreamReader(this.dataSocket.getInputStream()));
            output = new PrintWriter(this.dataSocket.getOutputStream(), true);

        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    
}
