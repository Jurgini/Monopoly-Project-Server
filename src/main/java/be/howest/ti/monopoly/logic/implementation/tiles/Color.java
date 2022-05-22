package be.howest.ti.monopoly.logic.implementation.tiles;

public enum Color {
    BROWN("BROWN"),
    LIGHTBLUE("LIGHTBLUE"),
    VIOLET("VIOLET"),
    ORANGE("ORANGE"),
    RED("RED"),
    YELLOW("YELLOW"),
    DARKGREEN("DARKGREEN"),
    DARKBLUE("DARKBLUE");

    private String color;

    Color(String color)
    {
        this.color = color;
    }

    public String getColor()
    {
        return color;
    }

}
