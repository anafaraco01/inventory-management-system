package decorators;

import composite.ItemComponent;

public class DiscountDecorator implements ItemComponent {
    private ItemComponent item;
    private double discountPercentage;

    public DiscountDecorator(ItemComponent item, double discountPercentage) {
        this.item = item;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String getName() {
        return item.getName() + "(Discounted)";
    }

    @Override
    public double getPrice() {
        double discountedPrice = item.getPrice() * (1 - discountPercentage / 100);
        return Math.round(discountedPrice * 100.0) / 100.0; //round to 2 decimals
    }
}
