package be.howest.ti.monopoly.logic.implementation.tiles;

public class Property extends Tile {

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

}
