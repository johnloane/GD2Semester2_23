package com.dkit.gd2.johnloane.jsonwithgson;

public class User
{
    private String name;
    private String email;
    private int age;
    private boolean isDeveloper;
    private Address address;

    public User(String name, String email, int age, boolean isDeveloper, Address address)
    {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isDeveloper = isDeveloper;
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public int getAge()
    {
        return age;
    }

    public boolean isDeveloper()
    {
        return isDeveloper;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isDeveloper=" + isDeveloper +
                ", address=" + address +
                '}';
    }
}
