package com.dkit.gd2.johnloane.tcpcomboserviceserver;

import com.dkit.gd2.johnloane.tcpcomboservicecore.TCPComboServiceDetails;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class ComboStreamServer
{
    public static void main(String[] args)
    {
        try
        {
            //Set up a connection socket to listen for connections
            ServerSocket listeningSocket = new ServerSocket(TCPComboServiceDetails.SERVER_PORT);

            //Set up a thread group to store all of the client threads together
            ThreadGroup clientThreads = new ThreadGroup("Client Threads");
            //Place more emphasis on accepting clients rather than processing
            clientThreads.setMaxPriority(Thread.currentThread().getPriority() - 1);

            boolean continueRunning = true;
            int numberClients = 0;

            while(continueRunning)
            {
                System.out.println("Server is up and listening for connections....");
                //Wait for an incoming connection and build a communications link
                Socket dataSocket = listeningSocket.accept();

                numberClients++;
                System.out.println("Server has now accepted " + numberClients + " clients");

                //Build the thread to handle the client
                //Thread needs:
                //1. A group to be stored in
                //2. A name to listed under
                //3. A socket to communicate through
                //4. Maybe other stuff
                ComboServiceThread newClient = new ComboServiceThread(clientThreads, dataSocket.getInetAddress() + "", dataSocket, numberClients);
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
