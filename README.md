# Inventory Management System for Albert Heijn
#### By: Ihor Novikov and Ana Rivera Faraco.

## About the Program
The inventory is based on 6 categories or types of items: Vegetables/fruits, Bakery, Meat, House, Drinks, and Prepared meals. It is a console interface. The interface allows to create items, add items to categories, delete them, update them and add discounts.

## Cooperation Between Team Members:
As a team we chose to do an Inventory Management System for Albert Heijn. The way we collaborated was dividing the tasks equally. Each member implemented 3 design patterns. 
- Ana implemented Singleton, Command and Observer.
- Ihor implemented Builder, Decorator and Composite.

Then, together we polished the program and added the user inputs to be able to interact with the system and its functionality :))

## Design patterns Implemented

### Creational
- Singleton: This pattern was used to create an instance of the builder, since it ensures that the setup is done only once, reducing the overall instantiation overhead in the application.
![SingletonItemBuilder.png](src%2Fimg%2FSingletonItemBuilder.png)
- Builder: This pattern was used to create the items of the inventory, since it allows the creation of complex items. Therefore, it provides more flexibility for items' creation. We have different builders for the type of object it creates.
![itemBuilder.png](src%2Fimg%2FitemBuilder.png)![builderDiagram.png](src%2Fimg%2FbuilderDiagram.png)
### Behavioral
- Command: This pattern was used for communication with application, in order to add an item, remove an item or update an item from a category.
![command.png](src%2Fimg%2Fcommand.png)
- Observer: This pattern is used for notifying about changes in application. Therefore if there is any change in the inventory, the observer will let the user know.
![observer.png](src%2Fimg%2Fobserver.png)
### Structural
- Composite: This pattern was used for handling item hierarchies.
![compositeDiagram.png](src%2Fimg%2FcompositeDiagram.png)
- Decorator: This pattern was used for flexible item modification, such as a discount for the price of an item.
![decoratorBuilder.png](src%2Fimg%2FdecoratorBuilder.png)