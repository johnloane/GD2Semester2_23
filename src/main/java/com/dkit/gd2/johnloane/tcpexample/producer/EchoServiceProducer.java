package com.dkit.gd2.johnloane.tcpexample.producer;

import com.dkit.gd2.johnloane.tcpexample.core.EchoServiceDetails;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServiceProducer
{
    public static void main(String[] args)
    {
        try
        {
            //Step21: Set up a connection socket to listen for connections
            ServerSocket listeningSocket = new ServerSocket(EchoServiceDetails.LISTENING_PORT);

            boolean continueRunning = true;

            while(continueRunning)
            {
                //Step 2: Wait for an incoming connection and build a communications link
                Socket dataSocket = listeningSocket.accept();

                //Step 3: Build input and output streams
                OutputStream out = dataSocket.getOutputStream();
                PrintWriter output = new PrintWriter(new OutputStreamWriter(out));

                InputStream in = dataSocket.getInputStream();
                Scanner input = new Scanner(new InputStreamReader(in));

                String incomingMessage = "";

                while(!incomingMessage.equals("."))
                {
                    //Step 4: Exchange messages
                    incomingMessage = input.nextLine();
                    System.out.println("Message received: " + incomingMessage);

                    //Step 5: Write to the output stream
                    output.println(incomingMessage);
                    output.flush();
                }
                dataSocket.close();
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
