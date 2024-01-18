import builders.*;
import commands.AddItemCommand;
import commands.Command;
import commands.RemoveItemCommand;
import commands.UpdateItemCommand;
import composite.IndividualItem;
import composite.ItemCategory;
import composite.ItemComponent;
import decorators.DiscountDecorator;
import items.Item;
import observers.BakeryItemObserver;
import observers.HouseItemObserver;
import observers.Inventory;
import observers.MeatItemObserver;

import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
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

        System.out.print(BLUE + "Do you want to create an item? (yes/no): " + RESET);
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

                System.out.println(GREEN + "Created Item: " + newItem.getName());
                System.out.println("Price: €" + newItem.getPrice()+ RESET);
                if (newItem.getColor() != null) {
                    System.out.println(GREEN + "Color: " + newItem.getColor()+ RESET);
                }

                System.out.print(BLUE + "Do you want to create another item? (yes/no): " + RESET);
                userInput = scanner.nextLine().toLowerCase();
                createAnotherItem = userInput.equals("yes");
            } else {
                createAnotherItem = false;
            }
        }

        // Building a Bakery Item
        ItemBuilder bakeryItemBuilder = new BakeryItemBuilder();
        Item bakeryItem = bakeryItemBuilder
                .setName("Vanilla Muffins")
                .build();

        // Building a House Item
        ItemBuilder houseItemBuilder = new HouseItemBuilder();
        Item houseItem = houseItemBuilder
                .setName("Blender")
                .setPrice(49.99)
                .setColor("yellow")
                .build();

        // Building a Meat Item
        ItemBuilder meatItemBuilder = new MeatItemBuilder();
        Item meatItem = meatItemBuilder
                .setName("Salmon")
                .setPrice(8.29)
                .build();

        // Create predetermined command instances to show functionality
        Command addItemCommand = new AddItemCommand(bakeryItem);
        Command updateItemCommand = new UpdateItemCommand(houseItem);
        Command removeItemCommand = new RemoveItemCommand(meatItem);

        // Create observers to notify update changes
        HouseItemObserver houseItemObserver = new HouseItemObserver();
        BakeryItemObserver bakeryItemObserver = new BakeryItemObserver();
        MeatItemObserver meatItemObserver = new MeatItemObserver();
        Inventory inventory = new Inventory();
    }
}