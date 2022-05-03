package be.howest.ti.monopoly.logic.implementation.tiles;

public class Railroad extends Property {
    private final int rent;
    private final String color;

    public Railroad(String name, int position, String type) {
        super(name, position, type, 2000, 1000);
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
