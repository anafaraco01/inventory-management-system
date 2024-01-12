package builders;

import items.Item;
import items.PreparedMealItem;

public class PreparedMealItemBuilder implements ItemBuilder {
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

    @Override
    public ItemBuilder setColor(String color) {
        return this;
    }

    @Override public Item build() {
        return new PreparedMealItem(name, price);
    }
}
