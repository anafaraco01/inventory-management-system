package observers;

import items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<InventoryObserver> observers = new ArrayList<>();

    public void addObserver(InventoryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(InventoryObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Item item) {
        for (InventoryObserver observer : observers) {
            observer.update(item);
        }
    }
}
