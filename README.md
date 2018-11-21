# tech-placements-19-20
UNiDAYS Discounts Programming Challenge



## Running the .jar

#### Run the .jar directly:
Inside the src folder there is a .jar that can be run. Download the .jar file, move it into a directory that can be accessed via the command line. Run the .jar using the command ```java -jar jarFile.jar ``` on a UNIX or LINUX shell (Works the same way on MacOS).


#### Alternatively:
If the .jar doesn't run then please follow the following steps:

- Download this project (You may exclude the README and .gitignore files if you wish)
- Create a new java project in IntelliJ (prefferably, but eclipse should work as well)
- You can now import the source folder
- You can run the Main class (Make sure that you are using Java 10 for this project), or alternatively you can compile the project
- Should you want to run the JUnit tests, please ensure that you have JUnit 4 installed


###### Please note that this is a ```command line application```



## Java Version
Built on: `Java 10.0.2`

Testing dependency: `JUnit4`

IDE: `IntelliJ, July 24th 2018, 2018.2 Build`

JAR: The .jar was compiled on a `Macbook running High Sierra 10.13.6`

## Approaching the problem

The first step for me was to read through the problem and determine what actors are invlolved in this task. Uppon doing this I came up with the following objects that interact with eachother:
 - `ShoppingBasket`: This can be a class that is responsible for keeping track of it's items
 - `ShoppingItems`: This can also be a class, whos responsibility it is to set up what an `Item` actually is
 
After having found the 2 major classes that I will be working with, I started to wonder how these two classes would interact. This entailed that I establish the properties of the two classes. 
I knew that the `ShoppingItems` class would have to keep creating objects multiple times. For the `ShoppingBasket` class this is not the case due to the fact that we typically only have a single shopping basket where we place our `ShoppingItems`, hence why I opted to make `ShoppingBasket` a singleton.

I decided to take a test driven approach which entailed that I create an extensive set of unit tests which must be passed. After writing my unit tests I started to work on the classes, running the tests every time a feature was developed and amended. 

The reason why I did this was mainly due to the fact that using a test driven approach would make it a lot easier to find out where and why my program is failing, before moving onto a new part. Hence allowing me to establish total correctness before moving on to a new feature of the code.
