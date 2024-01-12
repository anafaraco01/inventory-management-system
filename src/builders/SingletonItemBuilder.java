package builders;

import items.Item;

public class SingletonItemBuilder implements ItemBuilder {
    private static SingletonItemBuilder instance;
    private String name;
    private double price;

    private SingletonItemBuilder() {
        // Private constructor to prevent instantiation
    }

    public static SingletonItemBuilder getInstance() {
        if (instance == null) {
            instance = new SingletonItemBuilder();
        }
        return instance;
    }

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
    public Item build() {
        // Implementation for building the item
        // Assuming the builder creates a generic Item for simplicity
        return new Item() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public double getPrice() {
                return price;
            }
        };
    }
}