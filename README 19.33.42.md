# UNiDAYS Discounts Programming Challenge

## Introduction

This challenge is for you to make use of your problem solving skills as well as demonstrate your understanding of good object-oriented programming and SOLID design principles.

At UNiDAYS our business is built on providing discounts to students. Your challenge is to build a basic discount system that applies discounts to an online shopping order and calculates the total price based on a set of pricing rules.

You may complete the challenge in any programming language you wish.

## Pricing Rules

| Item | Price  | Discount |
| ---- | ------ | -------- |
| A    | £8.00  | None |
| B    | £12.00 | 2 for £20.00 |
| C    | £4.00  | 3 for £10.00 |
| D    | £7.00  | Buy 1 get 1 free |
| E    | £5.00  | 3 for the price of 2 |

## Delivery Charges

Delivery charge £7.00

Free delivery on orders over £50.00 (inclusive)

## Interface

Implement a `Discount_Classes.UnidaysDiscountChallenge` class with two public methods.

1. `AddToBasket` - Pass in an item
2. `CalculateTotalPrice` - Calculate and return the total price, result should include the following
    - `Total` - Total price of all items after applying any discounts
    - `DeliveryCharge` - The delivery charge for the order

It should be possible to initialise your `Discount_Classes.UnidaysDiscountChallenge` class with the pricing rules. The example below shows how the interface might be used.

```
example = new Discount_Classes.UnidaysDiscountChallenge(pricingRules);

example.AddToBasket(itemOne);
example.AddToBasket(itemTwo);

result = example.CalculateTotalPrice();

totalPrice = result.Total;
deliveryCharge = result.DeliveryCharge;
overallTotal = totalPrice + deliveryCharge;
```

## Example Test Cases

| Items          | Total  | Delivery Charge |
| -------------- | ------ | --------------- |
| _None_         | £0.00  | £0.00 |
| A              | £8.00  | £7.00 |
| B              | £12.00 | £7.00 |
| C              | £4.00  | £7.00 |
| D              | £7.00  | £7.00 |
| E              | £5.00  | £7.00 |
| BB             | £20.00 | £7.00 |
| BBB            | £32.00 | £7.00 |
| BBBB           | £40.00 | £7.00 |
| CCC            | £10.00 | £7.00 |
| CCCC           | £14.00 | £7.00 |
| DD             | £7.00  | £7.00 |
| DDD            | £14.00 | £7.00 |
| EE             | £10.00 | £7.00 |
| EEE            | £10.00 | £7.00 |
| EEEE           | £15.00 | £7.00 |
| DDDDDDDDDDDDDD | £49.00 | £7.00 |
| BBBBCCC        | £50.00 | £0.00 |
| ABBCCCDDEE     | £55.00 | £0.00 |
| EDCBAEDCBC     | £55.00 | £0.00 |

## Deliverables

You should provide a copy of your code and include a readme detailing how to run your code as well as how you approached the problem. 

Please supply us with the URL to your solution as part of your application - you may choose to host your solution however you like, so long as we are able to access it.

We're not too fussy about what platform your program runs on, but we do require that we're able to build and run your code ourselves.


## Runable

Inside the src folder there is a .jar that can be run. Download the .jar file, move it into a directory that can be accessed via the command line. Run the .jar using the command ```java -jar jarFile.jar ``` on a UNIX or LINUX shell (Works the same way on MacOS).

## Java Version
Built on: `Java 10.0.2`

Testing dependency: `JUnit4`

IDE: `IntelliJ, July 24th 2018, 2018.2 Build`

JAR: The .jar was compiled on a `Macbook running High Sierra 10.13.6`

## Approaching the problem

I approached this problem with an OO mindset, first of all I read through the problem and highlited what actors partake in this task. 
 - `ShoppingBasket`: This can be a class that is responsible for keeping track of it's items
 - `ShoppingItems`: This can also be a class, whos responsibility it is to set up what an `Item` actually is
 
After having found the 2 major classes that I will be working with, I started to wonder how these two classes would interact. This entailed that I establish the properties of the two classes. I knew that the `ShoppingItems` class would have to keep creating objects multiple times. For the `ShoppingBasket` class this is not the case due to the fact that we typically only have a single shopping basket where we place our `ShoppingItems`, hence why I opted to make `ShoppingBasket` a singleton.
