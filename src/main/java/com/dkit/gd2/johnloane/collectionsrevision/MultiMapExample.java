package com.dkit.gd2.johnloane.collectionsrevision;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class MultiMapExample
{
    private Multimap<String, String> multiMap;

    public MultiMapExample()
    {
        multiMap = ArrayListMultimap.create();
    }

    public void add(String key, String value)
    {
        multiMap.put(key, value);
    }

    public static void main(String[] args)
    {
        MultiMapExample fordCars = new MultiMapExample();
        fordCars.add("Ford", "Fiesta");
        fordCars.add("Ford", "Focus");
        fordCars.add("Ford", "Mondeo");
        fordCars.add("Ford", "Fusion");
        fordCars.add("Ford", "Mustang");
    }


}
