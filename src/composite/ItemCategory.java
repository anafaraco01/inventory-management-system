package composite;

import java.util.ArrayList;
import java.util.List;

public class ItemCategory implements ItemComponent {
    private String name;
    private List<ItemComponent> items = new ArrayList<>();

    public ItemCategory(String name) {
        this.name = name;
    }

    public void addItem(ItemComponent item) {
        items.add(item);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        double totalPrice = 0;
        for (ItemComponent item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
