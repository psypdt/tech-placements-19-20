package Discount_Classes;
import java.util.ArrayList;

/**
 * @author Philipp Tiso
 */


/*This should be a singleton*/
public final class ShoppingBasket implements UnidaysDiscountChallenge
{
    private static ShoppingBasket single_instance = null;
    private ArrayList<ShoppingItem>items;


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
    public double CalculateTotalPrice()
    {
        int typeOccurrance = 0;
        double totalItemPrice = 0.00; /*After discount*/

        if(this.items.isEmpty())
        {
            return 0;
        }

        if(this.items.size() == 1)
        {
            return items.get(0).getDelivery() + items.get(0).getItemPrice();
        }

        sortItemAlph();

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
                else if(i + 1 < items.size() && !items.get(i + 1).getItemType().equals("B")
                        && typeOccurrance < 2)
                {
                    totalItemPrice += items.get(i).getItemPrice();
                    typeOccurrance = 0;
                }
                else if(i + 1 == items.size())
                {
                    totalItemPrice += items.get(i).getItemPrice();
                    /*End For loop*/
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
                    /*End For loop*/
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

        if(totalItemPrice >= 50)
        {
            return totalItemPrice;
        }

        return items.get(0).getDelivery() + totalItemPrice;
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
