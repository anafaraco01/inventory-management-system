package builders;

import items.HouseItem;
import items.Item;

public class HouseItemBuilder implements ItemBuilder {
    private String name;

    private double price;

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

    @Override public Item build() {
        return new HouseItem(name, price);
    }
}
