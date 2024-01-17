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

import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("         ^           ");
        System.out.println("       /   \\        ");
        System.out.println("     /       \\     ");
        System.out.println("   /      #    \\  ");
        System.out.println(" /  ## #  # ###  \\        Welcome to Albert Heijn's");
        System.out.println("|  #   #  ##  ##  |             Inventory Management System!");
        System.out.println("|  #   #  #    #  |");
        System.out.println("|   ## #  #    #  |");
        System.out.println("|_________________|");
        Scanner scanner = new Scanner(System.in);

        // Using the Singleton ItemBuilder
        SingletonItemBuilder itemBuilder = SingletonItemBuilder.getInstance();
        boolean createAnotherItem = true;

        System.out.print("Do you want to add an item? (yes/no): ");
        String userInput = scanner.nextLine().toLowerCase();

        // Item creation using singleton instance of the builder
        while (createAnotherItem) {

            if (userInput.equals("yes")) {
                System.out.print("Enter the name of the item: ");
                String name = scanner.nextLine();

                System.out.print("Enter the price of the item: €");
                double price = Double.parseDouble(scanner.nextLine());

                System.out.print("Do you want to include a color for the item? (yes/no): ");
                String hasSpecialColor = scanner.nextLine().toLowerCase();

                String color = null;
                if (hasSpecialColor.equals("yes")) {
                    System.out.print("Enter the color of the item: ");
                    color = scanner.nextLine();
                }

                Item newItem = itemBuilder
                        .setName(name)
                        .setPrice(price)
                        .setColor(color)
                        .build();

                System.out.println("Created Item: " + newItem.getName());
                System.out.println("Price: €" + newItem.getPrice());
                if (newItem.getColor() != null) {
                    System.out.println("Color: " + newItem.getColor());
                }

                System.out.print("Do you want to create another item? (yes/no): ");
                userInput = scanner.nextLine().toLowerCase();
                createAnotherItem = userInput.equals("yes");
            } else {
                createAnotherItem = false;
            }
        }

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
        System.out.println("Table is created");
        ItemComponent chair = new IndividualItem("chair", 10.00);
        System.out.println("Chair is created");
        ItemCategory houseCategory = new ItemCategory("House");
        System.out.println("House category is created");
        houseCategory.addItem(table);
        System.out.println("Table is added to House category");

        System.out.println("Do you want to add a discount to a chair?");
        Scanner scannerForDiscount = new Scanner(System.in);
        String input = scannerForDiscount.nextLine();
        if (Objects.equals(input, "yes") || Objects.equals(input, "Yes")) {
            System.out.println("How much in percents do you want the discount to be?");
            Scanner scannerForDiscountAmount = new Scanner(System.in);
            double inputAmount = scannerForDiscountAmount.nextDouble();
            // Add chair in category with discount
            houseCategory.addItem(new DiscountDecorator(chair, inputAmount));
            System.out.println("Total price of House items: $" + houseCategory.getPrice());
        }
    }
}