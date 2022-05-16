package be.howest.ti.monopoly.logic.implementation.tiles;

public class Railroad extends Property {
    public static final int COST = 2000;
    private final int rent;
    private final String color;

    public Railroad(String name, int position, String type) {
        super(name, position, type, COST, 1000);
        this.rent = 250;
        this.color = "BLACK";
    }

    public int getRent() {
        return rent;
    }

    public String getColor() {
        return color;
    }
}
