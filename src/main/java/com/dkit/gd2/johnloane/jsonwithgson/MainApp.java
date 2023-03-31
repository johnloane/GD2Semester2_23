package com.dkit.gd2.johnloane.jsonwithgson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

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
        //deserializeList();
        //serializeMap();
        //deserializeMap();
        //serializeSet();
        //derserializeSet();
        serializeWithNullWithControl();
        //deserializeWithNullWithControl();
    }

    private static void serializeWithNullWithControl()
    {
        User ross = new User(null, "ross@dkit.ie", 20, true);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        Gson gson = gsonBuilder.create();

        String rossJSON = gson.toJson(ross);
        System.out.println(rossJSON);
    }

    private static void deserializeWithNull()
    {
        String rossJson = "{'email':'ross@dkit.ie'}";
        Gson gson = new Gson();
        User ross = gson.fromJson(rossJson, User.class);
        System.out.println(ross);
    }

    private static void serializeWithNull()
    {
        User ross = new User(null, "ross@dkit.ie", 20, true);
        Gson gson = new Gson();
        String rossJSON = gson.toJson(ross);
        System.out.println(rossJSON);
    }

    private static void derserializeSet()
    {
        String studentSetJson = "['Adam','Dovydas','Dawood','Craig','Dillon','Dominik','Albert','Daniel','Dzeraldas']";
        Gson gson = new Gson();
        //Type studentSetType = new TypeToken<HashSet<String>>(){}.getType();
        HashSet<String> studentSet = gson.fromJson(studentSetJson, HashSet.class);
        System.out.println(studentSet);
    }

    private static void serializeSet()
    {
        HashSet<String> students = new HashSet<>();
        students.add("Adam");
        students.add("Albert");
        students.add("Craig");
        students.add("Dillon");
        students.add("Dawood");
        students.add("Dovydas");
        students.add("Dzeraldas");
        students.add("Dominik");
        students.add("Daniel");
        Gson gson = new Gson();
        String studentsJSON = gson.toJson(students);
        System.out.println(studentsJSON);
    }

    private static void deserializeMap()
    {
        String moneyJson = "{'1$':{'amount':1, 'currency':'Dollar'}, '2$':{'amount':2, 'currency':'Dollar'}, '3€':{'amount':3, 'currency':'Euro'}}";

        Gson gson = new Gson();
        Type moneyMapType = new TypeToken<HashMap<String, AmountWithCurrency>>(){}.getType();
        HashMap<String, AmountWithCurrency> moneyMap = gson.fromJson(moneyJson, moneyMapType);
        System.out.println(moneyMap);
    }

    private static void serializeMap()
    {
        HashMap<String, List<String>> students = new HashMap<>();
        students.put("A", Arrays.asList("Adam", "Albert"));
        students.put("C", Arrays.asList("Craig"));
        students.put("D", Arrays.asList("Dillon", "Dawood", "Dovydas", "Dzeraldas", "Dominik", "Daniel"));

        Gson gson = new Gson();
        String studentsJSON = gson.toJson(students);
        System.out.println(studentsJSON);
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
