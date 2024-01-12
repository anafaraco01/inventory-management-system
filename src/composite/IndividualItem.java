package composite;

public class IndividualItem implements ItemComponent {
    private String name;
    private double price;

    public IndividualItem(String name, double price) {
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
