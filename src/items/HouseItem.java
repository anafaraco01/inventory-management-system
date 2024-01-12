package items;

import observers.InventoryObserver;

public class HouseItem implements Item, InventoryObserver {
    private String name;
    private double price;

    public HouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
    public void update(Item item) {
        System.out.println("House Item updated: " + item.getName());
        // Implement logic to handle the update of electronic items
    }
}
