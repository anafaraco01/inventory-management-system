import builders.BakeryItemBuilder;
import builders.HouseItemBuilder;
import builders.ItemBuilder;
import builders.SingletonItemBuilder;
import items.HouseItem;
import items.Item;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Using the Singleton ItemBuilder
        SingletonItemBuilder itemBuilder = SingletonItemBuilder.getInstance();

        // Building an Item
        ItemBuilder houseItemBuilder = new BakeryItemBuilder();
        Item genericItem = houseItemBuilder
                .setName("Generic Item")
                .setPrice(0.0)
                .build();
        System.out.println("Created Item: " + genericItem.getName() + " " + genericItem.getColor());
    }
}