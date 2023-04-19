package com.dkit.gd2.johnloane.tcpcomboserviceclient;

import com.dkit.gd2.johnloane.tcpcomboservicecore.TCPComboServiceDetails;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ComboStreamClient
{
    public static void main(String[] args)
    {
        try
        {
            //Step 1: Establish a channel of communication
            Socket dataSocket = new Socket("localhost", TCPComboServiceDetails.SERVER_PORT);

            //Step 2: Build input and output streams
            OutputStream out = dataSocket.getOutputStream();
            PrintWriter output = new PrintWriter(new OutputStreamWriter(out));

            InputStream in = dataSocket.getInputStream();
            Scanner input = new Scanner(new InputStreamReader(in));

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
                            System.out.println("Response from server: " + response);
                            break;
                        case 2:
                            message = TCPComboServiceDetails.DAYTIME_COMMAND;
                            //Send message to server
                            output.println(message);
                            output.flush();

                            //Get response from server

                            response = input.nextLine();
                            System.out.println("The current date and time on the server is: " + response);
                            break;
                        case 3:
                            message = TCPComboServiceDetails.STATS_COMMAND;

                            //Send message to server
                            output.println(message);
                            output.flush();

                            //Get response from server

                            response = input.nextLine();
                            System.out.println("The server has served: " + response + " requests");
                            break;
                    }
                    if(response.equals(TCPComboServiceDetails.UNRECOGNISED))
                    {
                        System.out.println("Sorry, the server does not recognise this command");
                    }
                }
                else
                {
                    System.out.println("Please select and option from the menu");
                }
            }
            System.out.println("Thank you for using the Stream based Combo Service");
            dataSocket.close();
        }
        catch(UnknownHostException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static int getNumber(Scanner keyboard)
    {
        boolean numberEntered = false;
        int number = 0;
        while(!numberEntered)
        {
            try
            {
                number = keyboard.nextInt();
                numberEntered = true;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please enter a number");
                keyboard.nextLine();
            }
        }
        keyboard.nextLine();
        return number;
    }

    private static String generateEcho(Scanner keyboard)
    {
        StringBuffer message = new StringBuffer(TCPComboServiceDetails.ECHO_COMMAND);
        message.append(TCPComboServiceDetails.BREAKING_CHARACTERS);
        //Get the message to echo
        System.out.println("Enter a message to echo");
        String echoMessage = keyboard.nextLine();
        message.append(echoMessage);
        return message.toString();
    }

    private static void displayMenu()
    {
        System.out.println("Please select an option from the menu");
        System.out.println("0. Quit");
        System.out.println("1. Echo");
        System.out.println("2. Daytime");
        System.out.println("3. Stats");
    }

}
