package items;

import observers.InventoryObserver;

public class HouseItem implements Item, InventoryObserver {
    private String name;
    private double price;
    private String color;

    public HouseItem(String name, double price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getColor() { return color; }
    public void update(Item item) {
        System.out.println("House Item updated: " + item.getName());
        // Implement logic to handle the update of electronic items
    }
}
