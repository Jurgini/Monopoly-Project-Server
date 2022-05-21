package be.howest.ti.monopoly.logic.implementation.tiles;

import java.util.Objects;

public class Tile {
    private final String name;
    private final int position;
    private final String type;

    // Todo: make multiple type of the tiles (constructors?)
    public Tile(String name, int position, String type)
    {
        this.name = name;
        this.position = position;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return Objects.equals(getName(), tile.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
