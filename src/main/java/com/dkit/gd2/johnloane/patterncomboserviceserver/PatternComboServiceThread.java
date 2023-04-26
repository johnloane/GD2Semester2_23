package com.dkit.gd2.johnloane.patterncomboserviceserver;

import com.dkit.gd2.johnloane.patterncomboservicecore.ComboServiceDetails;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PatternComboServiceThread extends Thread
{
    private Socket dataSocket;
    private Scanner input;
    private PrintWriter output;
    private int number;

    public PatternComboServiceThread(ThreadGroup group, String name, Socket dataSocket, int number)
    {
        super(group, name);
        try
        {
            this.dataSocket = dataSocket;
            this.number = number;
            input = new Scanner(new InputStreamReader(dataSocket.getInputStream()));
            output = new PrintWriter(dataSocket.getOutputStream(), true);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run()
    {
        String incomingMessage = "";
        String response;
        try
        {
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
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
