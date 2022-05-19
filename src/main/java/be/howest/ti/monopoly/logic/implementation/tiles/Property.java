package be.howest.ti.monopoly.logic.implementation.tiles;

import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;
import be.howest.ti.monopoly.logic.implementation.Player;
import be.howest.ti.monopoly.web.views.PropertyView;

import java.util.List;
import java.util.Objects;

public abstract class Property extends Tile {

    private final int cost;
    private final int mortgage;

    public Property(String name, int position, String type, int cost, int mortgage) {
        super(name, position, type);
        this.cost = cost;
        this.mortgage = mortgage;
    }

    public int getCost() {
        return cost;
    }

    public int getMortgage() {
        return mortgage;
    }

    public int computeRent(List<PropertyView> properties, int totalValueDice) {
        int rent = 0;
        if (this instanceof Street) {
            rent = ((Street) this).computeRent(properties, totalValueDice);
        } else if (this instanceof Railroad) {
            rent = ((Railroad) this).computeRent(properties, totalValueDice);
        } else if (this instanceof Utility) {
            rent = ((Utility) this).computeRent(properties, totalValueDice);
        } else {
            throw new IllegalMonopolyActionException("Cannot compute rent of this tile!");
        }
        return rent;
    }


}
