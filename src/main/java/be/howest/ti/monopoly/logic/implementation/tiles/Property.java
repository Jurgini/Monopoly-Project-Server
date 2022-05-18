package be.howest.ti.monopoly.logic.implementation.tiles;

import be.howest.ti.monopoly.logic.implementation.Player;

import java.util.Objects;

public class Property extends Tile {

    private final int cost;
    private final int mortgage;

    private Player owner = null;

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

    public boolean ownerIsNull() {
        return Objects.isNull(owner);
    }

    public void setOwner(Player player) {
        owner = player;
    }
}
