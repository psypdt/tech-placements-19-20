package Discount_Classes;

public class Main
{
    public static void main(String args[])
    {
        ShoppingBasket myB = new ShoppingBasket().getInstance();
        ShoppingBasket.MyResult res;
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

        res = myB.CalculateTotalPrice();

        System.out.println("The total item cost is: " + res.totalPrice);
        System.out.println("The total delivery cost is: " + res.deliveryCharge);

        System.out.println("The total charge is: " + (res.deliveryCharge + res.totalPrice));
    }
}
