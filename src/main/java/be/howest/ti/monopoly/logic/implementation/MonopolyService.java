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

    @Override
    public Tile getTile(int position) {
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
    public Object getGames() {
        return gameSet;
    }

}
