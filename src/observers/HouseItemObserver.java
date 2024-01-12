package observers;

import items.HouseItem;
import items.Item;

public class HouseItemObserver implements InventoryObserver {
    @Override
    public void update(Item item) {
        if (item instanceof HouseItem) {
            HouseItem houseItem = (HouseItem) item;
            System.out.println("Electronic Item updated: " + houseItem.getName());
            // Implement logic to handle the update of electronic items
        } else {
            System.out.println("Observer received an update for a non-electronic item.");
        }
    }
}