package commands;

import items.Item;

public class RemoveItemCommand implements Command {
    private Item item;
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public RemoveItemCommand(Item item) {
        this.item = item;
    }

    @Override
    public void execute() {
        // Implement logic to remove the item from the inventory
        System.out.println(GREEN + "Removing item: " + item.getName() + RESET);
        // Remove the item from the inventory
    }

    @Override
    public void undo() {
        // Implement logic to undo the removal of the item
        System.out.println(GREEN + "Undoing removal of item: " + item.getName() + RESET);
        // Add the item back to the inventory
    }
}
