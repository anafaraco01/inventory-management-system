package builders;
import items.Item;

// Singleton ItemBuilder
public interface ItemBuilder {
    ItemBuilder setName(String name);
    ItemBuilder setPrice(double price);
    Item build();
}

