package com.dkit.gd2.johnloane.collectionsrevision;

/* Create a class StockManager that has a single attribute stock, which is a Set of items (Item class).

Add a method, populateStock( filename, set, list)  that accepts the name of a text file as a parameter uses the data in the file to instantiate Item objects and add them to the stock Set.
The structure of records in the file is :
name, quantityInStock, unitPrice, supplierName
Note that you may assume that there is one record per line and that each line will contain 4 fields (tokens), separated by a comma, as shown above.

However, quantityInStock and/or unitPrice may be invalid i.e. be less than 0 or not numeric. If the program encounters invalid data, the item should not be added to stock, and should instead be added to a list of items called  invalidStock (with quantityInStock and unitPrice set to 0 ).

The name of an item may appear more than once in the text file. When this happens, then the quantityInStock value for each new matching name must be added to the quantityInStock for that name. (When a duplicate name occurs, then you must retrieve the current quantityInStock, add the next quantityInStock to it, and write the total back into the Set.)

Display two lists – the valid items and the invalid items.
These lists should be sorted on name.

displayStock();
displayInvalidStock();*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class StockManager
{
    private Set<Item> stock;
    private List<Item> invalidStock;

    public StockManager()
    {
        this.stock = new TreeSet<>();
        this.invalidStock = new ArrayList<>();
    }
    public static void main(String[] args)
    {
        StockManager sm = new StockManager();
        sm.launch();
    }

    private void launch()
    {
        // TODO Auto-generated method stub

    }
    private void populateStock(String filename)
    {
        String name = null;
        try(FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] tokens = line.split(",");
                name = tokens[0];
                int quantityInStock = Integer.parseInt(tokens[1]);
                double unitPrice = Double.parseDouble(tokens[2]);
                String supplierName = tokens[3];
                if(checkForInvalidData(name, quantityInStock, unitPrice, supplierName, invalidStock))
                {
                    continue;
                }

                Item item = new Item(name, quantityInStock, unitPrice);
                if(stock.contains(item))
                {
                    for(Item i : stock)
                    {
                        if(i.equals(item))
                        {
                            i.setQuantityInStock(i.getQuantityInStock() + item.getQuantityInStock());
                        }
                    }
                }
                else
                {
                    stock.add(item);
                }
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("Invalid data in file " + filename);
            Item item = new Item(name, 0, 0);
            invalidStock.add(item);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File " + filename + " not found");
        }
        catch(IOException e)
        {
            System.out.println("Error reading file " + filename);
        }
    }

    private boolean checkForInvalidData(String name, int quantityInStock, double unitPrice, String supplierName, List<Item> list)
    {
        if(quantityInStock < 0 || unitPrice < 0)
        {
            Item item = new Item(name, 0, 0);
            list.add(item);
            return true;
        }
        return false;
    }

    public void displayStock()
    {
        for(Item i : stock)
        {
            System.out.println(i);
        }
    }

    public void displayInvalidStock()
    {
        Collections.sort(invalidStock);
        for(Item i : invalidStock)
        {
            System.out.println(i);
        }
    }

}
