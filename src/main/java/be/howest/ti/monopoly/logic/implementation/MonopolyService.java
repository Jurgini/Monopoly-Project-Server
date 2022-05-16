package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.implementation.tiles.*;
import be.howest.ti.monopoly.logic.exceptions.MonopolyResourceNotFoundException;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;


public class MonopolyService extends ServiceAdapter {

    private final SortedSet<Game> gameSet= new TreeSet<>();

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public List<String> getChance() {
        return List.of(
                "Advance to Boardwalk",
                "Advance to Go (Collect $200)",
                "Advance to Illinois Avenue. If you pass Go, collect $200",
                "Advance to St. Charles Place. If you pass Go, collect $200",
                "Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental to which they are otherwise entitled",
                "Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown.",
                "Bank pays you dividend of $50",
                "Get Out of Jail Free",
                "Go Back 3 Spaces",
                "Go to Jail. Go directly to Jail, do not pass Go, do not collect $200",
                "Make general repairs on all your property. For each house pay $25. For each hotel pay $100",
                "Speeding fine $15",
                "Take a trip to Reading Railroad. If you pass Go, collect $200",
                "You have been elected Chairman of the Board. Pay each player $50",
                "Your building loan matures. Collect $150"
        );
    }

    @Override
    public List<Tile> getTiles() {
        return List.of(
                // todo: change the tiles to good version
                new Tile("Go", 0, "Go"),
                new Street("Marksesteenweg", 1, "street", 600, 300, 500, "PURPLE", "PURPLE", 20, 100, 300, 900, 1600, 2500),
                new Tile("Community Chest I", 2, "community chest"),
                new Street("Etienne Sabbelaan", 3, "street", 600, 300, 500, "PURPLE", "PURPLE", 40, 200, 600, 1800, 3200, 4500),
                new Tile("Tax Income", 4, "Tax Income"),
                new Railroad("Station Gent-Sint-Pieters", 5, "railroad"),
                new Street("Martelarenlaan", 6, "street", 1000, 500, 500, "LIGHTBLUE", "LIGHTBLUE", 60, 300, 900, 2700, 4000, 5500),
                new Tile("Chance I", 7, "chance"),
                new Street("Demerstraat", 8, "street", 1000, 500, 500, "LIGHTBLUE", "LIGHTBLUE", 60, 300, 900, 2700, 4000, 5500),
                new Street("Grote Markt", 9, "street", 1200, 600, 50, "LIGHTBLUE", "LIGHTBLUE", 80, 400, 1000, 3000, 4500, 6000),
                new Tile("Jail", 10, "Jail"),
                new Street("Rijsselstraat", 11, "street", 1400, 700, 1000, "VIOLET", "VIOLET", 100, 500, 1500, 4500, 6250, 7500),
                new Utility("Electric Company", 12, "utility"),
                new Street("'t Zand", 13, "street", 1400, 700, 1000, "VIOLET", "VIOLET", 100, 500, 1500, 4500, 6250, 7500),
                new Street("Eiermarkt", 14, "street", 1600, 800, 1000, "VIOLET", "VIOLET", 120, 600, 1800, 5000, 7000, 9000),
                new Railroad("Station Antwerp-Central", 15, "railroad"),
                new Street("Sint-Pietersplein", 16, "street", 1800, 900, 1000, "ORANGE", "ORANGE", 140, 700, 2000, 5500, 7500, 9500),
                new Tile("Community Chest II", 17, "community chest"),
                new Street("Korenmarkt", 18, "street", 1800, 900, 1000, "ORANGE", "ORANGE", 140, 700, 2000, 5500, 7500, 9500),
                new Street("Overpoortstraat", 19, "street", 2000, 1000, 1000, "ORANGE", "ORANGE", 160, 800, 2200, 6000, 8000, 10000),
                new Tile("Free Parking", 20, "Free Parking"),
                new Street("Rue Saint-Gilles", 21, "street", 2200, 1100, 1500, "RED", "RED", 180, 900, 2500, 7000, 8750, 10500),
                new Tile("Chance II", 22, "chance"),
                new Street("Rue des Célestines", 23, "street", 2200, 1100, 1500, "RED", "RED", 180, 900, 2500, 7000, 8750, 10500),
                new Street("Boulevard d'Avroy", 24, "street", 2400, 1200, 1500, "RED", "RED", 200, 1000, 3000, 7500, 9250, 1100),
                new Railroad("Station Brussels", 25, "railroad"),
                new Street("Vrijwilligerslaan", 26, "street", 2600, 1300, 1500, "YELLOW", "YELLOW", 220, 1100, 3300, 8000, 9750, 11500),
                new Street("Kroonlaan", 27, "street", 2600, 130, 1500, "YELLOW", "YELLOW", 220, 1100, 3300, 8000, 9750, 11500),
                new Utility("Water Works", 28, "utility"),
                new Street("Grote Markt", 29, "street", 2800, 1400, 1500, "YELLOW", "YELLOW", 240, 1200, 3600, 8500, 10250, 12000),
                new Tile("Go to Jail", 30, "Go to Jail"),
                new Street("Grote Pieter Potstraat", 31, "street", 3000, 1500, 2000, "DARKGREEN", "DARKGREEN", 260, 1300, 3900, 9000, 11000, 12750),
                new Street("Groenplaats", 32, "street", 3000, 1500, 2000, "DARKGREEN", "DARKGREEN", 260, 1300, 3900, 9000, 11000, 12750),
                new Tile("Community Chest III", 33, "community chest"),
                new Street("Meir", 34, "street", 3200, 1600, 2000, "DARKGREEN", "DARKGREEN", 280, 1500, 4500, 10000, 12000, 14000),
                new Railroad("Station Leuven", 35, "railroad"),
                new Tile("Chance III", 36, "chance"),
                new Street("Naamsestraat", 37, "street", 3500, 1750, 2000, "DARKBLUE", "DARKBLUE", 350, 1750, 5000, 11000, 13000, 15000),
                new Tile("Luxury Tax", 38, "Luxury Tax"),
                new Street("Oude Markt", 39, "street", 4000, 2000, 2000, "DARKBLUE", "DARKBLUE", 500, 2000, 6000, 14000, 17000, 20000));
    }

    @Override
    public List<String> getCommunityChest() {
        return List.of(
                "Advance to Go (Collect $200)",
                "Bank error in your favor-Collect $200",
                "Doctor's fee-Pay $50",
                "From sale of stock you get $50",
                "Get Out of Jail Free",
                "Go to Jail-Go directly to jail-Do not pass Go-Do not collect $200",
                "Grand Opera Night-Collect $50 from every player for opening night seats",
                "Holiday Fund matures-Receive $100",
                "Income tax refund-Collect $20",
                "It is your birthday-Collect $10",
                "Life insurance matures-Collect $100",
                "Pay hospital fees of $100",
                "Pay school fees of $150",
                "Receive $25 consultancy fee",
                "You are assessed for street repairs-$40 per house-$115 per hotel",
                "You have won second prize in a beauty contest-Collect $10",
                "You inherit $100"
        );
    }

    @Override
    public Game createGame(String prefix, int numberOfPlayers) {
        Game game = new Game(prefix, numberOfPlayers);
        gameSet.add(game);
        return game;
    }


    public Tile getTileByPosition(int position) {
       for (Tile tile : getTiles()){
           if (tile.getPosition() == position){
               return tile;
           }
       }
       throw new MonopolyResourceNotFoundException("Tile not found");
    }

    @Override
    public Tile getTile(String name) {
        for (Tile tile : getTiles())
        {
            if (tile.getName().equals(name))
            {
                return tile;
            }
        }
        throw new MonopolyResourceNotFoundException("Tile not found");
    }

    @Override
    public SortedSet<Game> getGames() {
        return gameSet;
    }

    @Override
    public Game getGame(String gameId) {
        return gameSet.stream().filter(game -> game.getId().equals(gameId)).findFirst().orElse(null);
    }
}
