package commands;

import items.Item;

public class AddItemCommand implements Command {
    private Item item;
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public AddItemCommand(Item item) {
        this.item = item;
    }

    @Override
    public void execute() {
        // Implement logic to add the item to the inventory
        System.out.println(GREEN + "Adding item: " + item.getName() + RESET);
        // Add the item to the inventory
    }

    @Override
    public void undo() {
        // Implement logic to undo the addition of the item
        System.out.println(GREEN + "Undoing addition of item: " + item.getName()+ RESET);
        // Remove the item from the inventory
    }
}
