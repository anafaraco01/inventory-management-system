package commands;

import items.Item;

public class UpdateItemCommand implements Command {
    private Item item;

    public UpdateItemCommand(Item item) {
        this.item = item;
    }

    @Override
    public void execute() {
        // Implement logic to update the item in the inventory
        System.out.println("Updating item: " + item.getName());
        // Update the item in the inventory
    }

    @Override
    public void undo() {
        // Implement logic to undo the update of the item
        System.out.println("Undoing update of item: " + item.getName());
        // Revert the item to its previous state
    }
}
