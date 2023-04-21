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

            boolean continueRunning = true;

            while (continueRunning)
            {
                System.out.println("Server is up and listening for connections....");
                //Wait for an incoming connection and build a communications link
                Socket dataSocket = listeningSocket.accept();

                //Step 2: Build input and output streams
                OutputStream out = dataSocket.getOutputStream();
                PrintWriter output = new PrintWriter(new OutputStreamWriter(out));

                InputStream in = dataSocket.getInputStream();
                Scanner input = new Scanner(new InputStreamReader(in));

                String incomingMessage = "";
                String response;

                while (!incomingMessage.equals(ComboServiceDetails.QUIT_COMMAND))
                {
                    response = null;
                    incomingMessage = input.nextLine();
                    System.out.println("Incoming message: " + incomingMessage);

                    //Break the incoming message into its components
                    String[] components = incomingMessage.split(ComboServiceDetails.BREAKING_CHARACTERS);

                    CommandFactory commandFactory = new CommandFactory();

                    //Figure out what command to send back to the client
                    Command command = commandFactory.createCommand(components[0]);

                    //If we get a command back from the factory, then the command is an accepted action
                    //If not then the command is unrecognised

                    if (command != null)
                    {
                        response = command.createResponse(components);
                    } else if (components[0].equals(ComboServiceDetails.QUIT_COMMAND))
                    {
                        response = ComboServiceDetails.SESSION_TERMINATED;
                    } else
                    {
                        response = ComboServiceDetails.UNRECOGNISED;
                    }
                    output.println(response);
                    output.flush();
                }
                dataSocket.close();

            }
            listeningSocket.close();
        } catch (IOException ioe)
        {
            System.out.println("We have a problem: " + ioe.getMessage());
        }
    }
}
