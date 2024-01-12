package observers;

import items.Item;
import items.MeatItem;

public class MeatItemObserver implements InventoryObserver {
    @Override
    public void update(Item item) {
        if (item instanceof MeatItem) {
            MeatItem meatItem = (MeatItem) item;
            System.out.println("Meat Item updated: " + meatItem.getName());
            // Implement logic to handle the update of electronic items
        } else {
            System.out.println("Observer received an update for a non-meat item.");
        }
    }
}