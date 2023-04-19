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

            boolean continueRunning = true;

            while(continueRunning)
            {
                System.out.println("Server is up and listening for connections....");
                //Wait for an incoming connection and build a communications link
                Socket dataSocket = listeningSocket.accept();

                //Build input and output streams
                OutputStream out = dataSocket.getOutputStream();
                PrintWriter output = new PrintWriter(new OutputStreamWriter(out));

                InputStream in = dataSocket.getInputStream();
                Scanner input = new Scanner(new InputStreamReader(in));

                String incomingMessage = "";
                String response;

                while(!incomingMessage.equals(TCPComboServiceDetails.QUIT_COMMAND))
                {
                    response = null;
                    //See what the client wants to do
                    incomingMessage = input.nextLine();
                    System.out.println("Message received: " + incomingMessage);

                    //Break the message into its components
                    String[] components = incomingMessage.split(TCPComboServiceDetails.BREAKING_CHARACTERS);

                    if(components[0].equals(TCPComboServiceDetails.ECHO_COMMAND))
                    {
                        //Take the remaining text that the client sent and echo it back
                        StringBuffer echoMessage = new StringBuffer("");
                        if(components.length > 1)
                        {
                            echoMessage.append(components[1]);
                            //What is the user used %% with their message?
                            for(int i = 2; i < components.length; i++)
                            {
                                echoMessage.append(TCPComboServiceDetails.BREAKING_CHARACTERS);
                                echoMessage.append(components[i]);
                            }
                        }
                        response = echoMessage.toString();
                    }
                    else if(components[0].equals(TCPComboServiceDetails.DAYTIME_COMMAND))
                    {
                        response = new Date().toString();
                    }
                    else if(components[0].equals(TCPComboServiceDetails.STATS_COMMAND))
                    {
                        response = "7";
                    }
                    else
                    {
                        response = TCPComboServiceDetails.UNRECOGNISED;
                    }

                    //Send the response back to the client
                    output.println(response);
                    output.flush();
                }
                dataSocket.close();

            }
            listeningSocket.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
