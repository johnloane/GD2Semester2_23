package com.dkit.gd2.johnloane.udpexample;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receiver
{
    public static void main(String[] args)
    {
        int receiverPort = 50001;
        int senderPort = 50000;

        boolean continueRunning = true;

        final int MAX_LEN = 50;
        DatagramSocket receiverSocket = null;

        try
        {
            //Create a datagram for receiving data
            receiverSocket = new DatagramSocket(receiverPort);

            System.out.println("Waiting for a message on port " + receiverPort + "....");
            while(continueRunning)
            {
                byte buffer[] = new byte[MAX_LEN];
                DatagramPacket datagram = new DatagramPacket(buffer, MAX_LEN);

                receiverSocket.receive(datagram);
                //Convert buffer into a string
                String message = new String(buffer);

                System.out.println("Message received : " + message);

                //Figure out where the datagram came from
                InetAddress sender = datagram.getAddress();
                System.out.println("Sender:  " + sender);

                //Respond
                String responseMessage = "Message received, thank you";

                byte[] responseArray = responseMessage.getBytes();
                DatagramPacket response = new DatagramPacket(responseArray, responseArray.length, sender, senderPort);
                receiverSocket.send(response);
            }
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
