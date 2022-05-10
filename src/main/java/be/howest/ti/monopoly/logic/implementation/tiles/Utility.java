package be.howest.ti.monopoly.logic.implementation.tiles;

public class Utility extends Property {
    private String rent;
    private String color;

    public Utility(String name, int position, String type) {
        super(name, position, type, 1500, 750);
        this.rent = "4 or 10 times the dice roll";
        this.color = "WHITE";
    }

    public String getRent() {
        return rent;
    }

    public String getColor() {
        return color;
    }
}
