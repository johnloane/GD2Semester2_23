package com.dkit.gd2.johnloane.patterncomboserviceserver;

import com.dkit.gd2.johnloane.patterncomboservicecore.ComboServiceDetails;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ComboStreamServer
{
    public static void main(String[] args)
    {
        try
        {
            //Step 1: Listen for incoming connections and build communications link
            ServerSocket listeningSocket = new ServerSocket(ComboServiceDetails.SERVER_PORT);

            //Set up ThreadGroup to store all of the client threads together
            ThreadGroup clientThreads = new ThreadGroup("Client Threads");
            //Place more emphasis on accepting than servicing
            clientThreads.setMaxPriority(Thread.currentThread().getPriority() - 1);


            boolean continueRunning = true;
            int threadCount = 0;

            while (continueRunning)
            {
                System.out.println("Server is up and listening for connections....");
                //Wait for an incoming connection and build a communications link
                Socket dataSocket = listeningSocket.accept();

                threadCount++;
                System.out.println("The server has now accepted " + threadCount + " connections");

                PatternComboServiceThread newClient = new PatternComboServiceThread(clientThreads, dataSocket.getInetAddress() + "", dataSocket, threadCount);
                newClient.start();
            }
            listeningSocket.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
