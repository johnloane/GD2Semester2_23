package com.dkit.gd2.johnloane.patterncomboserviceserver;

import com.dkit.gd2.johnloane.patterncomboservicecore.ComboServiceDetails;

public class CommandFactory
{
    public Command createCommand(String command)
    {
        Command c = null;
        if(command.equals(ComboServiceDetails.ECHO_COMMAND))
        {
            c = new EchoCommand();
        }
        else if(command.equals(ComboServiceDetails.DAYTIME_COMMAND))
        {
            c = new DaytimeCommand();
        }
        /*else if(command.equals(ComboServiceDetails.STATS_COMMAND))
        {
            command = new StatsCommand();
        }
        else if(command.equals(ComboServiceDetails.QUIT_COMMAND))
        {
            command = new QuitCommand();
        }
        else
        {
            command = new UnrecognisedCommand();
        }*/
        return c;
    }
}
