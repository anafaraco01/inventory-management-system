package commands;

import items.Item;

public class UpdateItemCommand implements Command {
    private Item item;
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public UpdateItemCommand(Item item) {
        this.item = item;
    }

    @Override
    public void execute() {
        // Implement logic to update the item in the inventory
        System.out.println(GREEN + "Updating item: " + item.getName() + " with new price €" + item.getPrice() +
                (item.getColor() != null ? " and new color " + item.getColor() + RESET: "."+ RESET));
        // Update the item in the inventory
    }

    @Override
    public void undo() {
        // Implement logic to undo the update of the item
        System.out.println(GREEN + "Undoing update of item: " + item.getName() + RESET);
        // Revert the item to its previous state
    }
}
