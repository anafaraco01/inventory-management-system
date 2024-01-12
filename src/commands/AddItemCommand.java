package commands;

import items.Item;

public class AddItemCommand implements Command {
    private Item item;

    public AddItemCommand(Item item) {
        this.item = item;
    }

    @Override
    public void execute() {
        // Implement logic to add the item to the inventory
        System.out.println("Adding item: " + item.getName());
        // Add the item to the inventory
    }

    @Override
    public void undo() {
        // Implement logic to undo the addition of the item
        System.out.println("Undoing addition of item: " + item.getName());
        // Remove the item from the inventory
    }
}
