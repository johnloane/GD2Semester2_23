package com.dkit.gd2.johnloane.udpcomboserviceclient;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ComboServiceClient
{

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        //Set up port information
        int clientPort = 50001;
        int serverPort = 50000;

        //Set up breaking characters for information
        String breakingCharacters = "&&";

        //Set the maximum payload
        final int MAX_LEN = 150;

        DatagramSocket clientSocket = null;

        try
        {
            //Set up the address information for the destination
            InetAddress serverAddress = InetAddress.getByName("localhost");
        }
    }

    public static void displayMenu()
    {
        System.out.println("Please choose one of the following options: ");
        System.out.println("1. Echo a message");
        System.out.println("2. Get the current date and time");
        System.out.println("3. View the number of requests that the server has processed");
        System.out.println("0. Quit");
    }

    public static int getChoice(Scanner input)
    {
        int choice = 0;
        boolean validChoice = false;
        while(!validChoice)
        {
            try
            {
                choice = Integer.parseInt(input.nextLine());
                if(choice >= 0 && choice <= 3)
                {
                    validChoice = true;
                }
                else
                {
                    System.out.println("Invalid choice. Please enter a number between 0 and 3");
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("Invalid choice. Please enter a number between 0 and 3");
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid choice. Please enter a number between 0 and 3");
                System.out.println();
                //Clear the scanner's buffer
                input.nextLine();
                displayMenu();
            }
        }
        return choice;
    }
}
