package observers;

import items.BakeryItem;
import items.Item;

public class BakeryItemObserver implements InventoryObserver {
    @Override
    public void update(Item item) {
        if (item instanceof BakeryItem) {
            BakeryItem bakeryItem = (BakeryItem) item;
            System.out.println("Notification: Bakery Item added: " + bakeryItem.getName());
            // Implement logic to handle the update of electronic items
        } else {
            System.out.println("Notification: Observer received a change/update for a bakery item.");
        }
    }
}