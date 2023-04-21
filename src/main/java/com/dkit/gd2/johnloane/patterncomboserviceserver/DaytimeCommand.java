package com.dkit.gd2.johnloane.patterncomboserviceserver;

public class DaytimeCommand implements Command
{
    @Override
    public String createResponse(String[] components)
    {
        return new java.util.Date().toString();
    }
}
