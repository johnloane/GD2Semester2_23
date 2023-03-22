package com.dkit.gd2.johnloane.jsonwithgson;

import java.util.List;

public class RestaurantWithMenu
{
    private String name;
    private List<RestaurantMenuItem> menu;

    public RestaurantWithMenu(String name, List<RestaurantMenuItem> menu)
    {
        this.name = name;
        this.menu = menu;
    }

    @Override
    public String toString()
    {
        return "RestaurantWithMenu{" +
                "name='" + name + '\'' +
                ", menu=" + menu +
                '}';
    }
}
