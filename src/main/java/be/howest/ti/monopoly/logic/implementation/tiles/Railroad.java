package be.howest.ti.monopoly.logic.implementation.tiles;

public class Railroad extends Property {
    public static final int COST = 2000;
    private final int rent;
    private final String color;

    public Railroad(String name, int position) {
        super(name, position, "railroad", COST, 1000);
        this.rent = 250;
        this.color = "BLACK";
    }

    public int getRent(int ownedRailroadCards) {
        return rent*ownedRailroadCards;
    }

    public String getColor() {
        return color;
    }
}
