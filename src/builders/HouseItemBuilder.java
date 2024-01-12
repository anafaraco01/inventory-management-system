package builders;

import items.HouseItem;
import items.Item;

public class HouseItemBuilder implements ItemBuilder {
    private String name;

    private double price;

    private String color;

    @Override
    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ItemBuilder setPrice(double price) {
        this.price = price;
        return this;
    }
    
    public ItemBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    @Override public Item build() {
        return new HouseItem(name, price, color);
    }
}
