package Discount_Classes;


public class DiscountRules
{
    double delivery = 7.00; /*Constant delivery charge*/

    /**
     * @param basket Take in an array of product prices
     * @return the final price
     */
    public double calcDiscount(double basket[])
    {
        double totalItemCost = 0;

        if(basket.length == 0)
        {
            return 0;
        }

        if(totalItemCost >= 50)
        {
            return totalItemCost;
        }

        return 0;
    }

}
