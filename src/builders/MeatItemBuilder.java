package builders;

import items.Item;
import items.MeatItem;

public class MeatItemBuilder implements ItemBuilder {
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
        return new MeatItem(name, price);
    }
}
