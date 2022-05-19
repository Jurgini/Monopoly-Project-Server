package be.howest.ti.monopoly.web.views;

import be.howest.ti.monopoly.logic.implementation.tiles.Property;
import be.howest.ti.monopoly.logic.implementation.tiles.Street;
import be.howest.ti.monopoly.logic.implementation.tiles.Tile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PropertyView {
    @Override
    public String toString() {
        return "PropertyView{" +
                "property=" + property +
                '}';
    }

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
        return false; //todo: this needs to be false if there are no houses and hotels on the property (street), for this i need the values of a street Class, I can't reach them bcs this is a list of Property's SOS;
    }

    @JsonProperty("houseCount")
    public int getHouses()
    {
        return 0; //todo: same problem
    }

    @JsonProperty("hotelCount")
    public int getHotels()
    {
        return 0; //todo: same problem
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
