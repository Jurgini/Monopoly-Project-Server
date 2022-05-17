package be.howest.ti.monopoly.logic.implementation.tiles;

public class Street extends Property {
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

    public String getColor() {
        return color;
    }

    public int getRent(Integer totalBuildings) {
        int calculatedRent;
        switch (totalBuildings) {
            case 0:
                calculatedRent = rent;
                break;
            case 1:
                calculatedRent = rentWithOneHouse;
                break;
            case 2:
                calculatedRent = rentWithTwoHouses;
                break;
            case 3:
                calculatedRent = rentWithThreeHouses;
                break;
            case 4:
                calculatedRent = rentWithFourHouses;
                break;
            case 5:
                calculatedRent = rentWithHotel;
                break;
            default:
                calculatedRent = 0;
        }
        return calculatedRent;
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

    public void computeHouses() {

    }

    public void computeHotels() {

    }
}
