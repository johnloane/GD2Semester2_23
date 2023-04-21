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

            while(continueRunning)
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

                while(!incomingMessage.equals(ComboServiceDetails.QUIT_COMMAND))
                {
                    response = null;
                    incomingMessage = input.nextLine();
                    System.out.println("Incoming message: " + incomingMessage);

                    //Break the incoming message into its components
                    String[] components = incomingMessage.split(ComboServiceDetails.BREAKING_CHARACTERS);

                    CommandFactory commandFactory = new CommandFactory();
                    output.println(response);
                    output.flush();
                }

            }

            /

            Scanner keyboard = new Scanner(System.in);
            String message = "";
            while(!message.equals(TCPComboServiceDetails.QUIT_COMMAND))
            {
                displayMenu();
                int choice = getNumber(keyboard);
                String response = "";
                if(choice >= 0 && choice < 4)
                {
                    switch(choice)
                    {
                        case 0:
                            message = TCPComboServiceDetails.QUIT_COMMAND;

                            //Send message
                            output.println(message);
                            output.flush();

                            response = input.nextLine();
                            if(response.equals(TCPComboServiceDetails.SESSION_TERMINATED))
                            {
                                System.out.println("Session ended");
                            }
                            break;
                        case 1:
                            message = generateEcho(keyboard);

                            //Send message to server
                            output.println(message);
                            output.flush();

                            //Get response from server
                            response = input.nextLine();
                            System.out.println(response);
                            break;
                        case 2:
                            message = TCPComboServiceDetails.DAYTIME_COMMAND;

                            //Send message to server
                            output.println(message);
                            output.flush();

                            //Get response from server
                            response = input.nextLine();
                            System.out.println(response);
                            break;
                        case 3:
                            message = TCPComboServiceDetails.STATS_COMMAND;

                            //Send message to server
                            output.println(message);
                            output.flush();

                            //Get response from server
                            response = input.nextLine();
                            System.out.println(response);
                            break;
                    }
                }
                else
                {
                    System.out.println("Invalid choice");
                }
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Error: " + ioe.getMessage());
        }
    }
}
