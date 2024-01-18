package observers;

import items.Item;
import items.PreparedMealItem;

public class PreparedMealItemObserver implements InventoryObserver {
    @Override
    public void update(Item item) {
        if (item instanceof PreparedMealItem) {
            PreparedMealItem preparedMealItem = (PreparedMealItem) item;
            System.out.println("Notification: Prepared Meal Item updated: " + preparedMealItem.getName());
            // Implement logic to handle the update of electronic items
        } else {
            System.out.println("Notification: Observer received a change/update for a prepared meal item.");
        }
    }
}