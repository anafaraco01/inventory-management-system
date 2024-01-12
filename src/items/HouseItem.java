package items;

public class HouseItem implements Item {
    private String name;
    private double price;

    public HouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
