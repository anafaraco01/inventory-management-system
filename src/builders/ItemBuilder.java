package builders;

import items.Item;

public interface ItemBuilder {
    ItemBuilder setName(String name);

    ItemBuilder setPrice(double price);

    Item build();
}
