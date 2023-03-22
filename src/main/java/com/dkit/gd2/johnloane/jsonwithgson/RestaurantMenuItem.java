package com.dkit.gd2.johnloane.jsonwithgson;

public class RestaurantMenuItem
{
    private String description;
    private double price;

    public RestaurantMenuItem(String description, double price)
    {
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "RestaurantMenuItem{" +
                "description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
