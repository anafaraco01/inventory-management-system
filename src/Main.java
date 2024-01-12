import builders.BakeryItemBuilder;
import builders.HouseItemBuilder;
import builders.ItemBuilder;
import builders.SingletonItemBuilder;
import commands.AddItemCommand;
import commands.Command;
import commands.RemoveItemCommand;
import commands.UpdateItemCommand;
import composite.IndividualItem;
import composite.ItemCategory;
import composite.ItemComponent;
import decorators.DiscountDecorator;
import items.Item;
import observers.HouseItemObserver;
import observers.Inventory;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Using the Singleton ItemBuilder
        SingletonItemBuilder itemBuilder = SingletonItemBuilder.getInstance();

        // Building an Item
        ItemBuilder backeryItemBuilder = new BakeryItemBuilder();
        Item backeryItem = backeryItemBuilder
                .setName("Generic Item")
                .setPrice(0.0)
                .build();
        System.out.println("Created Item: " + backeryItem.getName() + " " + backeryItem.getColor());

        ItemBuilder houseItemBuilder = new HouseItemBuilder();
        Item houseItem = houseItemBuilder
                .setName("Jeans")
                .setPrice(49.99)
                .build();

        // Create command instances
        Command addItemCommand = new AddItemCommand(backeryItem);
        Command updateItemCommand = new UpdateItemCommand(houseItem);
        Command removeItemCommand = new RemoveItemCommand(backeryItem);

        // Execute commands
        addItemCommand.execute();
        updateItemCommand.execute();
        removeItemCommand.execute();

        // Undo the remove command
        removeItemCommand.undo();

        // Create an electronic item observer
        HouseItemObserver electronicItemObserver = new HouseItemObserver();

        // Add the observer to the inventory
        Inventory inventory = new Inventory();
        inventory.addObserver(electronicItemObserver);

        // Notify observers when an item is updated
        inventory.notifyObservers(backeryItem);

        // Create items to add to category
        ItemComponent table = new IndividualItem("table", 50.00);
        ItemComponent chair = new IndividualItem("chair", 10.00);

        // Create a category and add items there (one with discount)
        ItemCategory houseCategory = new ItemCategory("House");
        houseCategory.addItem(table);
        houseCategory.addItem(new DiscountDecorator(chair, 10.0));

        System.out.println("Total price of House items: $" + houseCategory.getPrice());
    }
}