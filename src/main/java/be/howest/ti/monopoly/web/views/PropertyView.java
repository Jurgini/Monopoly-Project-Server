package be.howest.ti.monopoly.web.views;

import be.howest.ti.monopoly.logic.implementation.tiles.Property;
import be.howest.ti.monopoly.logic.implementation.tiles.Street;
import com.fasterxml.jackson.annotation.JsonProperty;

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
}