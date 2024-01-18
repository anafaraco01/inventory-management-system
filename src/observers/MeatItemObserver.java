package observers;

import items.Item;
import items.MeatItem;

public class MeatItemObserver implements InventoryObserver {
    @Override
    public void update(Item item) {
        if (item instanceof MeatItem) {
            MeatItem meatItem = (MeatItem) item;
            System.out.println("Notification: Meat Item removed: " + meatItem.getName());
            // Implement logic to handle the update of electronic items
        } else {
            System.out.println("Notification: Observer received a change/update for a meat item.");
        }
    }
}