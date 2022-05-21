package be.howest.ti.monopoly.logic.implementation.tiles;

public class Tax extends Tile {
    private final int COST = 1000;
    private int amount;
    private String description;

    public Tax(String name, int position, String type, String description, boolean luxury) {
        super(name, position, type);
        this.description = description;
        if (luxury)
        {
            this.amount = 2*COST;
        }
        else
        {
            this.amount = COST;
        }
    }

    public Tax(String name, int position, String type, String description) {
        this(name, position, type, description, false);
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
