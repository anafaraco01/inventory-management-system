package observers;

import items.DrinkItem;
import items.Item;

public class DrinkItemObserver implements InventoryObserver {
    @Override
    public void update(Item item) {
        if (item instanceof DrinkItem) {
            DrinkItem drinkItem = (DrinkItem) item;
            System.out.println("Notification: Drink Item updated: " + drinkItem.getName());
            // Implement logic to handle the update of electronic items
        } else {
            System.out.println("Notification: Observer received a change/update for a drink item.");
        }
    }
}