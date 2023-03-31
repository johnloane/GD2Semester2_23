package com.dkit.gd2.johnloane.udpexample;

import java.io.IOException;
import java.net.*;

public class Sender
{
    public static void main(String[] args)
    {
        //Set up the socket object so it can be closed it in the finally section
        DatagramSocket senderSocket = null;
        try
        {
            //Set up the address informatopmn for the destination
            InetAddress receiverHost = InetAddress.getByName("localhost");
            //Create a port for the sender to listen and receive on
            int senderPort = 50000;
            int receiverPort = 50001;

            //Message to send
            String message = "Hello from John";
            //Create a datagram socket for sending the data
            senderSocket = new DatagramSocket(senderPort);

            //Get the information to send as a byte array
            byte buffer[] = message.getBytes();

            //Build the datagramPacket
            //REQUIRES:
            // buffer: Data to send
            // buffer.Length: size of data to send
            // receiverHost: where are we sending the packet
            // receiverPort: port number

            DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, receiverHost, receiverPort);

            //Send the message to the receiver
            senderSocket.send(datagram);
            System.out.println("Message sent");

            // Make a datagramPacket for the response - echo
            byte[] response = new byte[50];
            DatagramPacket echo = new DatagramPacket(response, response.length);

            //Receive
            senderSocket.receive(echo);

            //Get the content of the response
            String responseMessage = new String(echo.getData());

            //Display the message
            System.out.println("Reponse: " + responseMessage);

            Thread.sleep(3000);
        }
        catch(UnknownHostException e)
        {
            System.out.println(e.getMessage());
        }
        catch(SocketException e)
        {
            System.out.println(e.getMessage());
        }
        catch(InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            if(senderSocket != null)
            {
                senderSocket.close();
            }
        }

    }
}
