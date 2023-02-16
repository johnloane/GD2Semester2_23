package com.dkit.gd2.johnloane.collectionsrevision;

import java.util.Objects;

// Create a class Item with the following attributes:
//name, quantityInStock, unitPrice, and id – id to be unique and auto-assigned.
public class Item implements Comparable<Item>
{
    private String name;
    private int quantityInStock;
    private double unitPrice;
    private int id;
    private static int nextId = 1;

    public Item(String name, int quantityInStock, double unitPrice)
    {
        this.name = name;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
        this.id = nextId;
        nextId++;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantityInStock()
    {
        return quantityInStock;
    }

    public double getUnitPrice()
    {
        return unitPrice;
    }

    public int getId()
    {
        return id;
    }



    @Override
    public String toString()
    {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", unitPrice=" + unitPrice +
                ", id=" + id +
                '}';
    }

    public void setQuantityInStock(int i)
    {
        this.quantityInStock = i;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Item o)
    {
        return this.name.compareTo(o.name);
    }
}
