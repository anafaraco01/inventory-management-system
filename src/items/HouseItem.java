package items;

public class HouseItem implements Item {
    private String name;
    private double price;
    private String color;

    public HouseItem(String name, double price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getColor() { return color; }
}
