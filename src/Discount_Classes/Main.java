package Discount_Classes;

public class Main
{
    public static void main(String args[])
    {
        double res;
        ShoppingBasket example = new ShoppingBasket().getInstance();
        ShoppingItem item1 = new ShoppingItem("A", 8.00);
        ShoppingItem item2 = new ShoppingItem("A", 8.00);

        example.addToBasket(item1);
        example.addToBasket(item2);

        res = example.CalculateTotalPrice();

        System.out.println("Result is " + res);
    }
}
