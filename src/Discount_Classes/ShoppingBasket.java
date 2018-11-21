package Discount_Classes;
import java.util.ArrayList;

/**
 * @author Philipp Tiso
 */


/*This should be a singleton because we want one centralized basket where all items will be placed*/
public final class ShoppingBasket implements UnidaysDiscountChallenge
{
    private static ShoppingBasket single_instance = null;
    private ArrayList<ShoppingItem>items;

    public class MyResult
    {
        public double totalPrice = 0.00;
        public double deliveryCharge = 0.00;
    }

    public ShoppingBasket()
    {
        items = new ArrayList<ShoppingItem>();
    }

    public static ShoppingBasket getInstance()
    {
        /*Ensure that there is only ever 1 basket*/
        if(single_instance == null)
        {
            single_instance = new ShoppingBasket();
        }
        return single_instance;
    }


    public void sortItemAlph()
    {
        /*Sort the list (via lambda) into alphabetical order to ease finding item types*/
        items.sort((o1, o2) -> {
            String type1 = o1.getItemType();
            String type2 = o2.getItemType();
            return type1.compareTo(type2);
        });
    }


    @Override
    public void addToBasket(ShoppingItem item)
    {
        items.add(item);
    }

    @Override
    public MyResult CalculateTotalPrice() throws IllegalArgumentException
    {
        int typeOccurrance = 0;
        double totalItemPrice = 0.00; /*After discount*/
        MyResult total = new MyResult();

        /*Throw exception if basket is empty*/
        if(this.items.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        /*Return single element*/
        if(this.items.size() == 1)
        {
            total.deliveryCharge = items.get(0).getDelivery();
            total.totalPrice = items.get(0).getItemPrice();
            return total;
        }

        sortItemAlph();

        /*Rule set that will decide if a discount will be issued*/
        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getItemType().equals("A"))
            {
                totalItemPrice += items.get(i).getItemPrice();
            }
            else if(items.get(i).getItemType().equals("B"))
            {
                typeOccurrance++;
                if(typeOccurrance == 2)
                {
                    totalItemPrice += 20.00;
                    typeOccurrance = 0; /*Reset #B's encountered*/
                }
                else if(i + 1 < items.size() && !items.get(i + 1).getItemType().equals("B") && typeOccurrance < 2)
                {
                    totalItemPrice += items.get(i).getItemPrice();
                    typeOccurrance = 0;
                }
                else if(i + 1 == items.size())
                {
                    totalItemPrice += items.get(i).getItemPrice();
                }
            }
            else if(this.items.get(i).getItemType().equals("C"))
            {
                typeOccurrance++;
                if(typeOccurrance == 3)
                {
                    totalItemPrice += 10.00;
                    typeOccurrance = 0;
                }
                else if(i+1 < items.size() && !items.get(i + 1).getItemType().equals("C"))
                {
                    totalItemPrice += typeOccurrance * items.get(i).getItemPrice();
                    typeOccurrance = 0;
                }
                else if(i + 1 == items.size())
                {
                    totalItemPrice += typeOccurrance * items.get(i).getItemPrice();
                    typeOccurrance = 0;
                }
            }
            else if(items.get(i).getItemType().equals("D"))
            {
                typeOccurrance++;
                if(typeOccurrance == 2 && i+1 < items.size())
                {
                    totalItemPrice += items.get(i).getItemPrice();
                    typeOccurrance = 0;
                }
                /*2 Ds at end of list*/
                else if(typeOccurrance == 2 && i+1 == items.size())
                {
                    totalItemPrice += items.get(i).getItemPrice();
                }
                /*No D after this one*/
                else if(typeOccurrance < 2 && i+1 < items.size() && !items.get(i+1).getItemType().equals("D"))
                {
                    totalItemPrice += items.get(i).getItemPrice();
                }
                /*single D at end of list*/
                else if(typeOccurrance < 2 && i+1 == items.size())
                {
                    totalItemPrice += items.get(i).getItemPrice();
                    typeOccurrance = 0;
                }
            }
            else if(this.items.get(i).getItemType().equals("E"))
            {
                typeOccurrance++;
                if(typeOccurrance == 3)
                {
                    totalItemPrice += 2 * items.get(i).getItemPrice();
                    typeOccurrance = 0;
                }
                else if(typeOccurrance < 3 && i+1 == items.size())
                {
                    totalItemPrice += typeOccurrance * items.get(i).getItemPrice();
                }
            }
        }

        /*Decide if delivery is free*/
        if(totalItemPrice >= 50)
        {
            total.deliveryCharge = 0;
            total.totalPrice = totalItemPrice;
            return total;
        }

        total.deliveryCharge = 7.00;
        total.totalPrice = totalItemPrice;

        return total;
    }


    public ArrayList<ShoppingItem> getItems()
    {
        return items;
    }

    public void RemoveAllItems()
    {
        items.clear();
    }
}
