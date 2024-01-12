package builders;

import items.Item;

public interface ItemBuilder {
    ItemBuilder setName(String name);

    ItemBuilder setPrice(double price);

    ItemBuilder setColor(String color);

    Item build();
}
