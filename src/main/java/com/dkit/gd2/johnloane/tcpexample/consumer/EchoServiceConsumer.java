package com.dkit.gd2.johnloane.tcpexample.consumer;

import com.dkit.gd2.johnloane.tcpexample.core.EchoServiceDetails;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoServiceConsumer
{
    public static void main(String[] args)
    {
        //Step 1: Establish a channel of communication
        try
        {
            Socket dataSocket = new Socket("localhost", EchoServiceDetails.LISTENING_PORT);

            //Step2: Build input and output streams
            OutputStream out = dataSocket.getOutputStream();
            PrintWriter output = new PrintWriter(new OutputStreamWriter(out));

            InputStream in = dataSocket.getInputStream();
            Scanner input = new Scanner(new InputStreamReader(in));

            Scanner keyboard = new Scanner(System.in);
            String message = "";

            while(!message.equals("."))
            {
                System.out.println("Enter a message to send to the server");
                message = keyboard.nextLine();
                output.println(message);
                output.flush();

                String response = input.nextLine();
                System.out.println("Response from server: " + response);
            }
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
}
