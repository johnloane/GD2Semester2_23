package com.dkit.gd2.johnloane.jsonwithgson;

public class AmountWithCurrency
{
    private String currency;
    private int amount;

    public AmountWithCurrency(String currency, int amount)
    {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        return "AmountWithCurrency{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}
