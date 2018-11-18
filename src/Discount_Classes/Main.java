package Discount_Classes;

import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner myscan = new Scanner(System.in);
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult res;

        while(true)
        {
            System.out.println("Press 'a' to add a new element....... \tPress 'r' to clear the entire basket");
            System.out.println("Press 'p' to calculate item price.... \tPress 'd' to calculate the delivery cost");
            System.out.println("Press 'e' to close the program....... \tPress 't' to calculate the total cost");

            String select = myscan.next();

            if(select.equals("a"))
            {
                System.out.println("Enter the item type: ");
                String itype = myscan.next();
                System.out.println("Enter the item price: ");
                double iprice = myscan.nextDouble();

                try
                {
                    myB.addToBasket(new ShoppingItem(itype.toUpperCase(), iprice));
                    System.out.println("Item of type " + itype +" and price " + iprice + " has been added");
                }catch (IllegalArgumentException e)
                {
                    System.out.println("Unable to add Element.");
                }

            }
            else if(select.equals("r"))
            {
                myB.RemoveAllItems();
                System.out.println("All items have been removed. ");
            }
            else if(select.equals("p"))
            {
                try {
                    res = myB.CalculateTotalPrice();
                    System.out.println("The total item cost is: " + res.totalPrice);
                }catch (IllegalArgumentException e)
                {
                    System.out.println("Empty basket.");
                }
            }
            else if(select.equals("d"))
            {
                try
                {
                    res = myB.CalculateTotalPrice();
                    System.out.println("The total delivery cost is: " + res.deliveryCharge);
                }catch (IllegalArgumentException e)
                {
                    System.out.println("Empty basket.");
                }

            }
            else if(select.equals("t"))
            {
                try
                {
                    res = myB.CalculateTotalPrice();
                    System.out.println("The total charge is: " + (res.deliveryCharge + res.totalPrice));
                }catch (IllegalArgumentException e)
                {
                    System.out.println("Empty basket.");
                }
            }
            else if(select.equals("e"))
            {
                System.out.println("Exiting program. ");
                System.exit(0);
            }
        }
    }
}
