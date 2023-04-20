package com.dkit.gd2.johnloane.tcpcomboserviceserver;

import com.dkit.gd2.johnloane.tcpcomboservicecore.TCPComboServiceDetails;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
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

    //run method. This is called when .start() is called on an instance of teh Thread class. The run method should contain the logic for
    //a) receiving a message from the client
    //b) processing the message
    //c) sending a response to the client
    @Override
    public void run()
    {
        String incomingMessage = "";
        String response = "";
        try
        {
            //While the client doesn't want to quit
            while (!incomingMessage.equals(TCPComboServiceDetails.QUIT_COMMAND))
            {
                //Wipe the respinse to make sure we don't send old values
                response = null;
                //Read a message from the client
                incomingMessage = input.nextLine();
                System.out.println("Server received: " + incomingMessage);

                //Break up the message into its components
                String[] messageParts = incomingMessage.split(TCPComboServiceDetails.BREAKING_CHARACTERS);

                //Process the message
                if (messageParts[0].equals(TCPComboServiceDetails.ECHO_COMMAND))
                {
                    System.out.println("Echo" + incomingMessage);
                    StringBuffer echoMessage = new StringBuffer("");
                    if(messageParts.length > 1)
                    {
                        echoMessage.append(messageParts[1]);
                        for(int i = 2; i < messageParts.length; i++)
                        {
                            echoMessage.append(TCPComboServiceDetails.BREAKING_CHARACTERS);
                            echoMessage.append(messageParts[i]);
                        }
                    }
                    response = echoMessage.toString();
                }
                else if (messageParts[0].equals(TCPComboServiceDetails.DAYTIME_COMMAND))
                {
                    response = new Date().toString();
                }
                else if (incomingMessage.equals(TCPComboServiceDetails.STATS_COMMAND))
                {
                    response = "7";
                }
                else if (incomingMessage.equals(TCPComboServiceDetails.QUIT_COMMAND))
                {
                    response = TCPComboServiceDetails.SESSION_TERMINATED;
                }
                else
                {
                    response = TCPComboServiceDetails.UNRECOGNISED;
                }

                //Send a response to the client
                output.println(response);
                System.out.println("Server sent: " + response);
            }
        }
        catch(Exception e)
        {
            System.out.println(incomingMessage);
            System.out.println("An exception occurred with client number #" + number +": " + e.getMessage());
        }
        finally
        {
            try
            {
                //Shut down the connection
                System.out.println("Closing the connecting with client number #" + number);
                dataSocket.close();
            }
            catch(IOException e)
            {
                System.out.println("Unable to disconnect with client number #" + number);
                System.exit(1);
            }
        }

    }
}
