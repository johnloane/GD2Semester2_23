package com.dkit.gd2.johnloane.threads.sharedresources;

public class AccessResource implements Runnable
{
    private Resource resource;
    private String name;

    public AccessResource(Resource resource, String name)
    {
        this.resource = resource;
        this.name = name;
    }

    @Override
    public void run()
    {
        resource.getConnection(name);
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        resource.freeConnection(name);
    }
}

