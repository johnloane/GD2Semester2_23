package com.dkit.gd2.johnloane.threads.lidlqueue;

import java.util.ArrayList;
public class Customer
{
    private ArrayList<String> shoppingBasket;

    public Customer()
    {
        this.shoppingBasket = new ArrayList<>();
    }

    public void addToBasket(String item)
    {
        this.shoppingBasket.add(item);
    }

    public ArrayList<String> getShoppingBasket()
    {
        return shoppingBasket;
    }

}
