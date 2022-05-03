package be.howest.ti.monopoly.logic.implementation;

public class Street extends Property {
    private int totalHouses;
    private int totalHotels;
    private final int housePrice;
    private final String streetColor;
    private int rent;
    private int rentWithOneHouse;
    private int rentWithTwoHouses;
    private int rentWithThreeHouses;
    private int rentWithFourHouses;
    private int rentWithHotel;

    public Street(String name, int position, String type, int cost, int mortgage, int housePrice, String streetColor, int rent, int rentWithOneHouse, int rentWithTwoHouses, int rentWithThreeHouses, int rentWithFourHouses, int rentWithHotel) {
        super(name, position, type, cost, mortgage);
        this.housePrice = housePrice;
        this.streetColor = streetColor;
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
