package Discount_Tests;

import Discount_Classes.ShoppingBasket;
import Discount_Classes.ShoppingItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingItemTest extends ShoppingItem
{

    @Test
    public void test_item_no_input_type()
    {
        ShoppingItem itemU = new ShoppingItem();
        assertEquals(itemU.getItemType(), "A");
    }

    @Test
    public void test_item_no_input_price()
    {
        ShoppingItem itemU = new ShoppingItem();
        assertTrue(itemU.getItemPrice() == 8.00); /*Use assertTrue because double assert is deprecated*/
    }

    @Test
    public void test_item_input_price()
    {
        int i;

        for(i = 0; i < 10; i++)
        {
            ShoppingItem itemU = new ShoppingItem("B", i);
            assertTrue(itemU.getItemPrice() == i);
        }
    }

    @Test
    public void test_item_input_correct_type()
    {
        String alph[] ={"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        int i;

        for(i = 0; i < 5; i++)
        {
            ShoppingItem itemU = new ShoppingItem(alph[i], i);
            assertTrue(itemU.getItemType() == alph[i]);
        }
    }

    @Test
    public void test_item_input_wrong_type()
    {
        String alph[] ={"F", "G", "H", "I", "J"};
        int i;

        for(i = 0; i < 5; i++)
        {
            ShoppingItem itemU = new ShoppingItem(alph[i], i);
            assertFalse(itemU.getItemType() == alph[i]);
        }
    }
}
