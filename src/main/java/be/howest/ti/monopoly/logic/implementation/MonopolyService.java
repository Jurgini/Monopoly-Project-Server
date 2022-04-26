package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.ServiceAdapter;

import java.util.List;


public class MonopolyService extends ServiceAdapter {

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public List<Tile> getTiles() {
        return List.of(
                new Tile("Go", 0, "Go"),
                new Tile("Marksesteenweg", 1, "street"),
                new Tile("Community Chest I", 2, "community chest"),
                new Tile("Etienne Sabbelaan", 3, "street"),
                new Tile("Tax Income", 4, "Tax Income"),
                new Tile("Station Gent-Sint-Pieters", 5, "railroad"),
                new Tile("Martelarenlaan", 6, "street"),
                new Tile("Chance I", 7, "chance"),
                new Tile("Demerstraat", 8, "street"),
                new Tile("Grote Markt", 9, "street"),
                new Tile("Jail", 10, "Jail"),
                new Tile("Rijsselstraat", 11, "street"),
                new Tile("Electric Company", 12, "utility"),
                new Tile("'t Zand", 13, "street"),
                new Tile("Eiermarkt", 14, "street"),
                new Tile("Station Antwerp-Central", 15, "railroad"),
                new Tile("Sint-Pietersplein", 16, "street"),
                new Tile("Community Chest II", 17, "community chest"),
                new Tile("Korenmarkt", 18, "street"),
                new Tile("Overpoortstraat", 19, "street"),
                new Tile("Free Parking", 20, "Free Parking"),
                new Tile("Rue Saint-Gilles", 21, "street"),
                new Tile("Chance II", 22, "chance"),
                new Tile("Rue des Célestines", 23, "street"),
                new Tile("Boulevard d'Avroy", 24, "street"),
                new Tile("Station Brussels", 25, "railroad"),
                new Tile("Vrijwilligerslaan", 26, "street"),
                new Tile("Kroonlaan", 27, "street"),
                new Tile("Water Works", 28, "utility"),
                new Tile("Grote Markt", 29, "street"),
                new Tile("Go to Jail", 30, "Go to Jail"),
                new Tile("Grote Pieter Potstraat", 31, "street"),
                new Tile("Groenplaats", 32, "street"),
                new Tile("Community Chest III", 33, "community chest"),
                new Tile("Meir", 34, "street"),
                new Tile("Station Leuven", 35, "railroad"),
                new Tile("Chance III", 36, "chance"),
                new Tile("Naamsestraat", 37, "street"),
                new Tile("Luxury Tax", 38, "Luxury Tax"),
                new Tile("Oude Markt", 39, "street")
        );
    }
}
