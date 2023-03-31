package com.dkit.gd2.johnloane.udpcomboserviceserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class ComboServiceServer
{
    public static void main(String[] args)
    {
        //Set up breaking characters for information
        String breakingCharacters = "&&";

        //Set up the port information
        int serverPort = 50000;
        int clientPort = 50001;

        //Set the maximum payload
        final int MAX_LEN = 150;

        //Variable to track the number of requests that the server has dealt with
        int countRequests = 0;
        boolean continueRunning = true;

        DatagramSocket serverSocket = null;

        try
        {
            //Create a datagram for receiving data
            serverSocket = new DatagramSocket(serverPort);

            System.out.println("Waiting for a message on port " + serverPort + "....");
            // The server should run forever
            while(continueRunning)
            {
                byte[] incomingMessageBuffer = new byte[MAX_LEN];
                DatagramPacket incomingPacket = new DatagramPacket(incomingMessageBuffer, incomingMessageBuffer.length);

                //Wait for a request and store it in incomingPacket
                serverSocket.receive(incomingPacket);
                //Convert buffer into a string
                String data = new String(incomingPacket.getData());

                //Process the packet, trim excess whitespace
                data = data.trim();

                //Split the data into its components
                String[] dataComponents = data.split(breakingCharacters);
                countRequests++;

                String response = null;

                //Work out which command has been sent
                if(dataComponents[0].equalsIgnoreCase("echo"))
                {
                    //Strip the echo and breaking characters from the message and send it back
                    response = data.replace("echo"+breakingCharacters, "");
                }
                else if(dataComponents[0].equalsIgnoreCase("daytime"))
                {
                    response = new Date().toString();
                }
                else if(dataComponents[0].equalsIgnoreCase("stats"))
                {
                    response = "Number of requests dealt with is " + countRequests;
                }
                else
                {
                    response = "Unknown command";
                }

                //Figure out where the datagram came from
                InetAddress sender = incomingPacket.getAddress();
                System.out.println("Message received : " + data);
                System.out.println("Sender:  " + sender);

                //Respond

                byte[] responseBuffer = response.getBytes();
                //Create a packet to store the response
                DatagramPacket responsePacket= new DatagramPacket(responseBuffer, responseBuffer.length, sender, clientPort);
                //Send the response
                serverSocket.send(responsePacket);
            }
        }
        catch(SocketException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            if(serverSocket != null)
            {
                serverSocket.close();
            }
        }
    }
}
