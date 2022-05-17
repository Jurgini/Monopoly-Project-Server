package be.howest.ti.monopoly.logic.implementation.tiles;

public class Street extends Property {
    private int totalHouses;
    private int totalHotels;
    private final int housePrice;
    private final String streetColor;
    private final String color;
    private final int rent;
    private final int rentWithOneHouse;
    private final int rentWithTwoHouses;
    private final int rentWithThreeHouses;
    private final int rentWithFourHouses;
    private final int rentWithHotel;

    public Street(String name, int position, int cost, int mortgage, int housePrice, String streetColor, String color, int rent, int rentWithOneHouse, int rentWithTwoHouses, int rentWithThreeHouses, int rentWithFourHouses, int rentWithHotel) {
        super(name, position, "street", cost, mortgage);
        this.housePrice = housePrice;
        this.streetColor = streetColor;
        this.color = color;
        this.rent = rent;
        this.rentWithOneHouse = rentWithOneHouse;
        this.rentWithTwoHouses = rentWithTwoHouses;
        this.rentWithThreeHouses = rentWithThreeHouses;
        this.rentWithFourHouses = rentWithFourHouses;
        this.rentWithHotel = rentWithHotel;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public String getStreetColor() {
        return streetColor;
    }

    public String getColor()
    {
        return color;
    }

    public int getRent() {
        return rent;
    }

    public int getRentWithOneHouse() {
        return rentWithOneHouse;
    }

    public int getRentWithTwoHouses() {
        return rentWithTwoHouses;
    }

    public int getRentWithThreeHouses() {
        return rentWithThreeHouses;
    }

    public int getRentWithFourHouses() {
        return rentWithFourHouses;
    }

    public int getRentWithHotel() {
        return rentWithHotel;
    }

    public void computeHouses()
    {
    }

    public void computeHotels()
    {

    }
}
