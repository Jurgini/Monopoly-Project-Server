package be.howest.ti.monopoly.web.views;

import be.howest.ti.monopoly.logic.implementation.tiles.Property;
import be.howest.ti.monopoly.logic.implementation.tiles.Tile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PropertyView {
    private final Property property;

    public PropertyView(Property property)
    {
        this.property = property;
    }

    @JsonProperty("property")
    public String getPropertyName()
    {
        return property.getName();
    }

    @JsonProperty("mortgage")
    public boolean checkIfThereIsMortgage()
    {
        return false;
    }

    @JsonProperty("houseCount")
    public int getHouses()
    {
        return 0;
    }

    @JsonProperty("hotelCount")
    public int getHotels()
    {
        return 0;
    }

    @JsonIgnore()
    public String getType() {
        return ((Tile)property).getType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyView that = (PropertyView) o;
        return Objects.equals(property, that.property);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property);
    }
}
