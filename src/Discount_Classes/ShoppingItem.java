package Discount_Classes;

import java.util.ArrayList;

public class ShoppingItem
{
    private String itemType;
    private double itemPrice;
    private double delivery;
    public String knowntypes[] = {"A", "B", "C", "D", "E"};

    /*Default constructor if no arguments are passed*/
    public ShoppingItem()
    {
        this.itemType = "A";
        this.itemPrice = 8.00;
        this.delivery = 7.00;
    }

    /*Constructor for arguments getting passed in, allow this to throw exception if illegal argument is passed*/
    public ShoppingItem(String iType, double iPrice) throws IllegalArgumentException
    {
        for(int i = 0; i < knowntypes.length; i++)
        {
            /*Ensure that a known item type is passed into the constructor*/
            if(iType.equals(knowntypes[i]))
            {
                this.itemType = iType;
                break;
            }
            /*Throw exception if illegal argument is passed*/
            else if(!iType.equals(knowntypes[i]) && i == knowntypes.length-1)
            {
                System.out.println("Error: Item of type '" + iType + "' is unknown.");
                throw new IllegalArgumentException();
            }
        }

        this.itemPrice = iPrice;
        this.delivery = 7.00;
    }


    public String getItemType()
    {
        return this.itemType;
    }

    public void setItemType(String itemType)
    {
        this.itemType = itemType;
    }


    public double getItemPrice()
    {
        return this.itemPrice;
    }

    public void setItemPrice(double itemPrice)
    {
        this.itemPrice = itemPrice;
    }


    public double getDelivery()
    {
        return this.delivery;
    }

    public void setDelivery(double delivery)
    {
        this.delivery = delivery;
    }
}

