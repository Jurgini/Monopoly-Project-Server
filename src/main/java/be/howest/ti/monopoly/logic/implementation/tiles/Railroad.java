package be.howest.ti.monopoly.logic.implementation.tiles;

import be.howest.ti.monopoly.web.views.PropertyView;

import java.util.List;

public class Railroad extends Property {
    public static final int COST = 2000;
    private final int rent;
    private final String color;

    public Railroad(String name, int position) {
        super(name, position, "railroad", COST, 1000);
        this.rent = 250;
        this.color = "BLACK";
    }

    @Override
    public int computeRent(List<PropertyView> properties, int totalValueDice) {
        return rent * (int) properties.stream().filter(property -> (property).getType().equals("railroad")).count();
    }

    public String getColor() {
        return color;
    }
}
