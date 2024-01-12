package commands;

import items.Item;

public class RemoveItemCommand implements Command {
    private Item item;

    public RemoveItemCommand(Item item) {
        this.item = item;
    }

    @Override
    public void execute() {
        // Implement logic to remove the item from the inventory
        System.out.println("Removing item: " + item.getName());
        // Remove the item from the inventory
    }

    @Override
    public void undo() {
        // Implement logic to undo the removal of the item
        System.out.println("Undoing removal of item: " + item.getName());
        // Add the item back to the inventory
    }
}
