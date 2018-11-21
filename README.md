# tech-placements-19-20
UNiDAYS Discounts Programming Challenge



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
