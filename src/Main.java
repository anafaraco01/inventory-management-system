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
                System.out.println("Price: €" + newItem.getPrice() + RESET);
                if (newItem.getColor() != null) {
                    System.out.println(GREEN + "Color: " + newItem.getColor() + RESET);
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

        System.out.print(BLUE + "Do you want to add a Vanilla Muffin to the Bakery Items? (yes/no): " + RESET);
        String addCommandInput = scanner.nextLine().toLowerCase();
        if (addCommandInput.equals("yes")) {
            addItemCommand.execute();
            inventory.addObserver(bakeryItemObserver);
        }

        System.out.print(BLUE + "Do you want to update the Blender Price of a House Items to €49.99 and the color to yellow? (yes/no): " + RESET);
        String updateCommandInput = scanner.nextLine().toLowerCase();
        if (updateCommandInput.equals("yes")) {
            updateItemCommand.execute();
            inventory.addObserver(houseItemObserver);
        }

        System.out.print(BLUE + "Do you want to remove the Salmon Item of the Meat Category? (yes/no): " + RESET);
        String removeCommandInput = scanner.nextLine().toLowerCase();
        if (removeCommandInput.equals("yes")) {
            removeItemCommand.execute();
            inventory.addObserver(meatItemObserver);
        }

        System.out.print(BLUE + "Do you want to see the notifications? (yes/no): " + RESET);
        String seeNotificationsInput = scanner.nextLine().toLowerCase();

        boolean anyNotificationSent = false;
        if (seeNotificationsInput.equals("yes")) {
            // Send Notifications
            if (addCommandInput.equals("yes")) {
                inventory.notifyObservers(bakeryItem);
                anyNotificationSent = true;
            }
            if (updateCommandInput.equals("yes")) {
                inventory.notifyObservers(houseItem);
                anyNotificationSent = true;
            }
            if (removeCommandInput.equals("yes")) {
                inventory.notifyObservers(meatItem);
                anyNotificationSent = true;
            }
            if (!anyNotificationSent) {
                System.out.println("There are no new notifications.");
            }
        }

        // Create items to add to category
        ItemComponent table = new IndividualItem("table", 50.00);
        ItemComponent chair = new IndividualItem("chair", 10.00);
        ItemCategory houseCategory = new ItemCategory("House");
        System.out.print(BLUE + "Do you want to add a table to House category? (yes/no): " + RESET);
        String scannerForTable = scanner.nextLine().toLowerCase();
        if (scannerForTable.equals("yes")) {
            houseCategory.addItem(table);
            System.out.println(GREEN + "Table was added to House category" + RESET);
            System.out.println("House category contains a Table of €50 and a Chair of €10. Total Price = €60");
        } else {
            System.out.println("House category contains a Chair of €10. Total Price = €10");
        }

        System.out.print(BLUE + "Do you want to add a discount to the chair? (yes/no): " + RESET);
        String scannerForDiscount = scanner.nextLine().toLowerCase();
        if (scannerForDiscount.equals("yes")) {
            System.out.println(BLUE + "How much in percentage do you want the discount to be?: " + RESET);
            Scanner scannerForDiscountAmount = new Scanner(System.in);
            double inputAmount = scannerForDiscountAmount.nextDouble();
            // Add chair in category with discount
            houseCategory.addItem(new DiscountDecorator(chair, inputAmount));
            System.out.println("New total price of all House items: $" + houseCategory.getPrice());
        }

        System.out.println(BLUE + "Well that's it for today! Thank you for choosing Albert Heijn's Inventory Management System" + RESET);
        System.out.println(BLUE + "Done by: Ana and Ihor" + RESET);
    }
}