package be.howest.ti.monopoly.logic;

import be.howest.ti.monopoly.logic.implementation.Game;
import be.howest.ti.monopoly.logic.implementation.Player;
import be.howest.ti.monopoly.logic.implementation.tiles.Tile;

import java.util.List;
import java.util.SortedSet;

public interface IService {
    String getVersion();
    
    Game createGame(String prefix, int numberOfPlayers);
    List<String> getChance();
    List<Tile> getTiles();
    List<String> getCommunityChest();
    Tile getTile(int position);
    Tile getTile(String name);

    SortedSet<Game> getGames();
    Game getGame(String gameId);

    Object joinGame(String gameId, String playerToken, Player player);
}
