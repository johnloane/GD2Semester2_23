package com.dkit.gd2.johnloane.patterncomboserviceserver;

import com.dkit.gd2.johnloane.patterncomboservicecore.ComboServiceDetails;

public class EchoCommand implements Command
{
    @Override
    public String createResponse(String[] components)
    {
        StringBuffer response = new StringBuffer();
        if(components.length > 1)
        {
            response.append(components[1]);

            for(int i=2; i<components.length; i++)
            {
                response.append(ComboServiceDetails.BREAKING_CHARACTERS);
                response.append(components[i]);
            }
        }
        return response.toString();
    }
}
