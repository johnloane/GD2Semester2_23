package com.dkit.gd2.johnloane.udpcomboserviceclient;

import java.io.IOException;
import java.net.*;
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

            //Create a datagram for sending data
            clientSocket = new DatagramSocket(clientPort);

            boolean continueRunning = true;

            //Repeat until the user chooses to quit
            while(continueRunning)
            {
                displayMenu();
                int choice = getChoice(keyboard);
                String message = null;
                boolean sendMessage = true;
                switch(choice)
                {
                    case 1:
                        System.out.println("Please enter a message to be echoed: ");
                        message = "echo" + breakingCharacters+keyboard.nextLine();
                        break;
                    case 2:
                        message = "daytime";
                        break;
                    case 3:
                        message = "stats";
                        break;
                    case 0:
                        continueRunning = false;
                        sendMessage = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 0 and 3");
                        sendMessage = false;
                        break;
                }
                //If the sendMessage flag is true, the user chosen has chosen a valid option that is not quit
                if(sendMessage)
                {
                    byte[] outgoingMessageBuffer = message.getBytes();
                    //Create a datagram for sending data
                    DatagramPacket outgoingPacket = new DatagramPacket(outgoingMessageBuffer, outgoingMessageBuffer.length, serverAddress, serverPort);
                    //Send the packet
                    clientSocket.send(outgoingPacket);
                    System.out.println("Message sent " + message);

                    //Deal with the response
                    byte[] responseBuffer = new byte[MAX_LEN];
                    DatagramPacket incomingPacket = new DatagramPacket(responseBuffer, responseBuffer.length);
                    //Wait for a response and store it in incomingPacket
                    clientSocket.receive(incomingPacket);
                    //Convert buffer into a string
                    String response = new String(incomingPacket.getData());
                    System.out.println("Response received: " + response.trim() + ".");
                }
            }
            System.out.println("Thank you for using the UDP Combo Service");
            Thread.sleep(3000);
        }
        catch(SocketException e)
        {
            System.out.println("Socket: " + e.getMessage());
        }
        catch(UnknownHostException e)
        {
            System.out.println("Unknown host: " + e.getMessage());
        }
        catch(InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println("IO: " + e.getMessage());
        }
        finally
        {
            if(clientSocket != null)
            {
                clientSocket.close();
            }
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
