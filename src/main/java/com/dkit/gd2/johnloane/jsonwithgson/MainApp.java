package com.dkit.gd2.johnloane.jsonwithgson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MainApp
{
    public static void main(String[] args)
    {
//        Address rossAddress = new Address("10", "Main Street", "Dundalk", "Louth","A61D2D3", "Ireland");
//        User ross = new User("Ross", "ross@dkit.ie", 20, true, rossAddress);
//        String rossJSON = serializeToJSON(ross);
//        System.out.println(rossJSON);
//
//        User rossD = deserialize(rossJSON);
//        System.out.println(rossD);
        //createRestaurant();
        deserializeList();
    }

    private static void deserializeList()
    {
        String gd2Students = "[{'name':'Ross','pets': 0},{'name':'Gracie','pets': 2},{'name':'Dovydas','pets': 3}]";
        Gson gson = new Gson();
        Type studentListType = new TypeToken<List<Student>>(){}.getType();
        List<Student> gd2StudentList = gson.fromJson(gd2Students, studentListType);
        System.out.println(gd2StudentList);
    }

    private static void createRestaurant()
    {
        List<RestaurantMenuItem> menu = new ArrayList<>();
        menu.add(new RestaurantMenuItem("Steak", 30.00));
        menu.add(new RestaurantMenuItem("Rajma Chawal", 10.00));
        menu.add(new RestaurantMenuItem("Milkshake", 5.00));

        RestaurantWithMenu restaurant = new RestaurantWithMenu("Gordon Ramsey's Kitchen", menu);
        Gson gson = new Gson();
        String restaurantJson = gson.toJson(restaurant);
        System.out.println(restaurantJson);
        String listOnly = "[{'description':'Steak','price':30.0},{'description':'Rajma Chawal','price':10.0},{'description':'Milkshake','price':5.0}]";
        deserializeList(listOnly);
    }

    private static void deserializeList(String listOnly)
    {
        Gson gson = new Gson();
        RestaurantMenuItem[] menu = gson.fromJson(listOnly, RestaurantMenuItem[].class);
        System.out.println(Arrays.toString(menu));
    }

    private static User deserialize(String rossJSON)
    {
        Gson gson = new Gson();
        User rossD = gson.fromJson(rossJSON, User.class);
        return rossD;
    }

    private static String serializeToJSON(User ross)
    {
        Gson gson = new Gson();
        return gson.toJson(ross);
    }
}
