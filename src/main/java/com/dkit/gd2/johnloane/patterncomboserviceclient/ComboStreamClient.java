package com.dkit.gd2.johnloane.patterncomboserviceclient;

import com.dkit.gd2.johnloane.patterncomboservicecore.ComboServiceDetails;

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
            Socket dataSocket = new Socket("localhost", ComboServiceDetails.SERVER_PORT);

            //Step 2: Build input and output streams
            OutputStream out = dataSocket.getOutputStream();
            PrintWriter output = new PrintWriter(new OutputStreamWriter(out));

            InputStream in = dataSocket.getInputStream();
            Scanner input = new Scanner(new InputStreamReader(in));

            Scanner keyboard = new Scanner(System.in);
            String message = "";
            while(!message.equals(ComboServiceDetails.QUIT_COMMAND))
            {
                displayMenu();
                int choice = getNumber(keyboard);
                String response = "";
                if(choice >= 0 && choice < 4)
                {
                    switch(choice)
                    {
                        case 0:
                            message = ComboServiceDetails.QUIT_COMMAND;

                            //Send message
                            output.println(message);
                            output.flush();

                            response = input.nextLine();
                            if(response.equals(ComboServiceDetails.SESSION_TERMINATED))
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
                            System.out.println("Server response: " + response);
                            break;
                        case 2:
                            message = ComboServiceDetails.DAYTIME_COMMAND;

                            //Send message to server
                            output.println(message);
                            output.flush();

                            //Get response from server
                            response = input.nextLine();
                            System.out.println("The date and time on the server is: " + response);
                            break;
                        case 3:
                            message = ComboServiceDetails.STATS_COMMAND;

                            //Send message to server
                            output.println(message);
                            output.flush();

                            //Get response from server
                            response = input.nextLine();
                            System.out.println("Stats from server: " + response);
                            break;
                    }
                    if(response.equals(ComboServiceDetails.UNRECOGNISED))
                    {
                        System.out.println("Unrecognised command");
                    }
                }
                else
                {
                    System.out.println("Invalid choice");
                }
            }
            System.out.println("Thank you for using our amazing service");
            dataSocket.close();
        }
        catch (UnknownHostException e)
        {
            System.out.println("Unknown host: " + e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }

    private static String generateEcho(Scanner keyboard)
    {
        //Single threaded immutable string using String
        //Single threaded mutable string using StringBuilder
        //Multi-threaded immutable string using StringBuffer
        StringBuilder message = new StringBuilder(ComboServiceDetails.ECHO_COMMAND);
        message.append(ComboServiceDetails.BREAKING_CHARACTERS);
        System.out.println("Enter message to echo");
        String echoMessage = keyboard.nextLine();
        message.append(echoMessage);
        return message.toString();
    }

    private static int getNumber(Scanner keyboard)
    {
        int number = -1;
        boolean valid = false;
        while(!valid)
        {
            try
            {
                number = keyboard.nextInt();
                valid = true;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input");
                keyboard.nextLine();
            }
        }
        keyboard.nextLine();
        return number;
    }

    private static void displayMenu()
    {
        System.out.println("0. Quit");
        System.out.println("1. Echo");
        System.out.println("2. Daytime");
        System.out.println("3. Stats");
    }
}
