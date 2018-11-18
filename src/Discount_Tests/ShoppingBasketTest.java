package Discount_Tests;

import Discount_Classes.ShoppingBasket;
import Discount_Classes.ShoppingItem;
import org.junit.Test;


import static org.junit.Assert.*;

public class ShoppingBasketTest extends ShoppingItem
{

    @Test
    public void shoppingBasket()
    {
        ShoppingBasket myB1 = new ShoppingBasket().getInstance();
        ShoppingBasket myB2 = new ShoppingBasket().getInstance();

        assertSame(myB1, myB2);
        myB1.RemoveAllItems();
        myB2.RemoveAllItems();
    }

    @Test
    public void removeAllItems()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingItem item1 = new ShoppingItem("E", 5.00);
        ShoppingItem item2 = new ShoppingItem("E", 5.00);
        ShoppingItem item3 = new ShoppingItem("E", 5.00);
        ShoppingItem item4 = new ShoppingItem("E", 5.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);
        myB.addToBasket(item3);
        myB.addToBasket(item4);

        myB.RemoveAllItems();

        assertTrue("Basket Is empty", myB.getItems().isEmpty());
    }

    @Test
    public void addToBasket()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingItem item1 = new ShoppingItem();

        myB.addToBasket(item1);

        System.out.println("Basket size is: " + myB.getItems().size());

        assertEquals(1, myB.getItems().size(), 0);
        myB.RemoveAllItems();
    }

    @Test
    public void sortItemAlph()
    {
        String arr[] = {"A", "B", "C", "D", "E"};
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingItem item1 = new ShoppingItem("D", 7.00);
        ShoppingItem item2 = new ShoppingItem("B", 7.00);
        ShoppingItem item3 = new ShoppingItem("C", 7.00);
        ShoppingItem item4 = new ShoppingItem("E", 7.00);
        ShoppingItem item5 = new ShoppingItem("A", 7.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);
        myB.addToBasket(item3);
        myB.addToBasket(item4);
        myB.addToBasket(item5);

        myB.sortItemAlph();

        for(int i = 0; i < arr.length; i++)
        {
            System.out.println("Cart is " + myB.getItems().get(i).getItemType() + " Array is " + arr[i]);
            assertEquals(myB.getItems().get(i).getItemType(), arr[i]);
        }
        myB.RemoveAllItems();
    }

    @Test
    public void test_adding_A()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("A", 8.00);

        myB.addToBasket(item1);

        System.out.println("A");
        result = myB.CalculateTotalPrice();

        assertEquals(result.totalPrice, 8.00, 0.0);

        myB.RemoveAllItems();
    }

    @Test
    public void test_adding_2A()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("A", 8.00);
        ShoppingItem item2 = new ShoppingItem("A", 8.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);

        System.out.println("2A");

        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 16.00, 0.0);

        myB.RemoveAllItems();
    }

    @Test
    public void test_adding_3A()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("A", 8.00);
        ShoppingItem item2 = new ShoppingItem("A", 8.00);
        ShoppingItem item3 = new ShoppingItem("A", 8.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);
        myB.addToBasket(item3);

        System.out.println("3A");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 24.00, 0.0);

        myB.RemoveAllItems();
    }


    @Test
    public void test_adding_B()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("B", 12.00);

        myB.addToBasket(item1);

        System.out.println("B");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 12.00, 0.0);

        myB.RemoveAllItems();
    }

    @Test
    public void test_adding_2B()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("B", 12.00);
        ShoppingItem item2 = new ShoppingItem("B", 12.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);

        System.out.println("2B");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 20.00, 0.0);

        myB.RemoveAllItems();
    }

    @Test
    public void test_adding_3B()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("B", 12.00);
        ShoppingItem item2 = new ShoppingItem("B", 12.00);
        ShoppingItem item3 = new ShoppingItem("B", 12.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);
        myB.addToBasket(item3);

        System.out.println("3B");

        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 20.00 + 12.00, 0.0);

        myB.RemoveAllItems();
    }



    @Test
    public void test_adding_C()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("C", 4.00);

        myB.addToBasket(item1);

        System.out.println("C");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 4.00, 0.0);

        myB.RemoveAllItems();
    }

    @Test
    public void test_adding_2C()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("C", 4.00);
        ShoppingItem item2 = new ShoppingItem("C", 4.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);

        System.out.println("2C");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 8.00, 0.0);

        myB.RemoveAllItems();
    }


    @Test
    public void test_adding_3C()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("C", 4.00);
        ShoppingItem item2 = new ShoppingItem("C", 4.00);
        ShoppingItem item3 = new ShoppingItem("C", 4.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);
        myB.addToBasket(item3);

        System.out.println("3C");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 10.00, 0.0);

        myB.RemoveAllItems();
    }


    @Test
    public void test_adding_D()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("D", 7.00);

        myB.addToBasket(item1);

        System.out.println("D");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 7.00, 0.0);

        myB.RemoveAllItems();
    }

    @Test
    public void test_adding_2D()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("D", 7.00);
        ShoppingItem item2 = new ShoppingItem("D", 7.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);

        System.out.println("2D");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 7.00, 0.0);

        myB.RemoveAllItems();
    }


    @Test
    public void test_adding_3D()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("D", 7.00);
        ShoppingItem item2 = new ShoppingItem("D", 7.00);
        ShoppingItem item3 = new ShoppingItem("D", 7.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);
        myB.addToBasket(item3);

        System.out.println("3D");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 7.00 + 7.00, 0.0);

        myB.RemoveAllItems();
    }



    @Test
    public void test_adding_E()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("E", 5.00);

        myB.addToBasket(item1);

        System.out.println("E");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 5.00, 0.0);

        myB.RemoveAllItems();
    }

    @Test
    public void test_adding_2E()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("E", 5.00);
        ShoppingItem item2 = new ShoppingItem("E", 5.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);

        System.out.println("2E");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 10.00, 0.0);

        myB.RemoveAllItems();
    }


    @Test
    public void test_adding_3E()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("E", 5.00);
        ShoppingItem item2 = new ShoppingItem("E", 5.00);
        ShoppingItem item3 = new ShoppingItem("E", 5.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);
        myB.addToBasket(item3);

        System.out.println("3E");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 10.00, 0.0);

        myB.RemoveAllItems();
    }


    @Test
    public void test_adding_4E()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("E", 5.00);
        ShoppingItem item2 = new ShoppingItem("E", 5.00);
        ShoppingItem item3 = new ShoppingItem("E", 5.00);
        ShoppingItem item4 = new ShoppingItem("E", 5.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);
        myB.addToBasket(item3);
        myB.addToBasket(item4);

        System.out.println("4E");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 10.00 + 5.00, 0.0);

        myB.RemoveAllItems();
    }



    @Test
    public void test_adding_14D()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("D", 7.00);
        ShoppingItem item2 = new ShoppingItem("D", 7.00);
        ShoppingItem item3 = new ShoppingItem("D", 7.00);
        ShoppingItem item4 = new ShoppingItem("D", 7.00);
        ShoppingItem item5 = new ShoppingItem("D", 7.00);
        ShoppingItem item6 = new ShoppingItem("D", 7.00);
        ShoppingItem item7 = new ShoppingItem("D", 7.00);
        ShoppingItem item8 = new ShoppingItem("D", 7.00);
        ShoppingItem item9 = new ShoppingItem("D", 7.00);
        ShoppingItem item10 = new ShoppingItem("D", 7.00);
        ShoppingItem item11 = new ShoppingItem("D", 7.00);
        ShoppingItem item12 = new ShoppingItem("D", 7.00);
        ShoppingItem item13 = new ShoppingItem("D", 7.00);
        ShoppingItem item14 = new ShoppingItem("D", 7.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);
        myB.addToBasket(item3);
        myB.addToBasket(item4);
        myB.addToBasket(item5);
        myB.addToBasket(item6);
        myB.addToBasket(item7);
        myB.addToBasket(item8);
        myB.addToBasket(item9);
        myB.addToBasket(item10);
        myB.addToBasket(item11);
        myB.addToBasket(item12);
        myB.addToBasket(item13);
        myB.addToBasket(item14);

        System.out.println("14D");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 49.00, 0.0);

        myB.RemoveAllItems();
    }


    @Test
    public void test_adding_4B_3C()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("B", 12.00);
        ShoppingItem item2 = new ShoppingItem("B", 12.00);
        ShoppingItem item3 = new ShoppingItem("B", 12.00);
        ShoppingItem item4 = new ShoppingItem("B", 12.00);
        ShoppingItem item5 = new ShoppingItem("C", 4.00);
        ShoppingItem item6 = new ShoppingItem("C", 4.00);
        ShoppingItem item7 = new ShoppingItem("C", 4.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);
        myB.addToBasket(item3);
        myB.addToBasket(item4);
        myB.addToBasket(item5);
        myB.addToBasket(item6);
        myB.addToBasket(item7);

        System.out.println("4B_3C");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 50.00, 0.0);

        myB.RemoveAllItems();
    }


    @Test
    public void test_adding_A_2B_3C_2D_2E()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("A", 8.00);
        ShoppingItem item2 = new ShoppingItem("B", 12.00);
        ShoppingItem item3 = new ShoppingItem("B", 12.00);
        ShoppingItem item4 = new ShoppingItem("C", 4.00);
        ShoppingItem item5 = new ShoppingItem("C", 4.00);
        ShoppingItem item6 = new ShoppingItem("C", 4.00);
        ShoppingItem item7 = new ShoppingItem("D", 7.00);
        ShoppingItem item8 = new ShoppingItem("D", 7.00);
        ShoppingItem item9 = new ShoppingItem("E", 5.00);
        ShoppingItem item10 = new ShoppingItem("E", 5.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);
        myB.addToBasket(item3);
        myB.addToBasket(item4);
        myB.addToBasket(item5);
        myB.addToBasket(item6);
        myB.addToBasket(item7);
        myB.addToBasket(item8);
        myB.addToBasket(item9);
        myB.addToBasket(item10);

        System.out.println("A_2B_3C_2D_2E");
        result = myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 55.00, 0.0);

        myB.RemoveAllItems();
    }

    @Test
    public void test_adding_E_D_C_B_A_E_D_C_B_C()
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult result;
        ShoppingItem item1 = new ShoppingItem("E", 5.00);
        ShoppingItem item2 = new ShoppingItem("D", 7.00);
        ShoppingItem item3 = new ShoppingItem("C", 4.00);
        ShoppingItem item4 = new ShoppingItem("B", 12.00);
        ShoppingItem item5 = new ShoppingItem("A", 8.00);
        ShoppingItem item6 = new ShoppingItem("E", 5.00);
        ShoppingItem item7 = new ShoppingItem("D", 7.00);
        ShoppingItem item8 = new ShoppingItem("C", 4.00);
        ShoppingItem item9 = new ShoppingItem("B", 12.00);
        ShoppingItem item10 = new ShoppingItem("C", 4.00);

        myB.addToBasket(item1);
        myB.addToBasket(item2);
        myB.addToBasket(item3);
        myB.addToBasket(item4);
        myB.addToBasket(item5);
        myB.addToBasket(item6);
        myB.addToBasket(item7);
        myB.addToBasket(item8);
        myB.addToBasket(item9);
        myB.addToBasket(item10);

        System.out.println("E_D_C_B_A_E_D_C_B_C");
        result =  myB.CalculateTotalPrice();
        assertEquals(result.totalPrice, 55.00, 0.0);

        myB.RemoveAllItems();
    }
}