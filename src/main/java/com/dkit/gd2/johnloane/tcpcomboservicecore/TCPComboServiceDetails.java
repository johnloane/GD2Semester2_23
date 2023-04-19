package com.dkit.gd2.johnloane.tcpcomboservicecore;

public class TCPComboServiceDetails
{
    //Create variables that hold information on how this protocol works
    //By providing this information in variables, you can change it easily
    //and you need to change it here, not on both the client and server

    public static final int SERVER_PORT = 50000;
    public static final String BREAKING_CHARACTERS = "%%";
    //Command strings
    public static final String ECHO_COMMAND = "ECHO";
    public static final String DAYTIME_COMMAND = "DAYTIME";
    public static final String STATS_COMMAND = "STATS";
    public static final String QUIT_COMMAND = "QUIT";

    //Response strings
    public static final String UNRECOGNISED = "UNKNOWN COMMAND";
    public static final String SESSION_TERMINATED = "GOODBYE";
}
