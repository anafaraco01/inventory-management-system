package observers;

import items.BakeryItem;
import items.Item;

public class BakeryItemObserver implements InventoryObserver {
    @Override
    public void update(Item item) {
        if (item instanceof BakeryItem) {
            BakeryItem bakeryItem = (BakeryItem) item;
            System.out.println("Bakery Item updated: " + bakeryItem.getName());
            // Implement logic to handle the update of electronic items
        } else {
            System.out.println("Observer received an update for a non-bakery item.");
        }
    }
}