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
        else if(command.equals(ComboServiceDetails.STATS_COMMAND))
        {
            c = new StatsCommand();
        }
        return c;
    }
}
