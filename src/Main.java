import builders.ItemBuilder;
import builders.SingletonItemBuilder;
import commands.AddItemCommand;
import commands.Command;
import commands.RemoveItemCommand;
import commands.UpdateItemCommand;
import items.Item;
import observers.HouseItemObserver;
import observers.Inventory;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Using the Singleton ItemBuilder
        Item electronicItem = SingletonItemBuilder.getInstance()
                .setName("Smartphone")
                .setPrice(499.99)
                .build();

        ItemBuilder clothingItemBuilder = new ClothingItemBuilder();
        Item clothingItem = clothingItemBuilder
                .setName("Jeans")
                .setPrice(49.99)
                .build();

        // Create command instances
        Command addItemCommand = new AddItemCommand(electronicItem);
        Command updateItemCommand = new UpdateItemCommand(clothingItem);
        Command removeItemCommand = new RemoveItemCommand(electronicItem);

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
        inventory.notifyObservers(electronicItem);
    }
}