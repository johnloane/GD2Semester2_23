package com.dkit.gd2.johnloane.jsonwithgson;

public class Address
{
    private String houseNumber;
    private String street;
    private String city;
    private String county;
    private String eircode;
    private String country;

    public Address(String houseNumber, String street, String city, String county, String eircode, String country)
    {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.county = county;
        this.eircode = eircode;
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "Address{" +
                "houseNumber='" + houseNumber + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", eircode='" + eircode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
