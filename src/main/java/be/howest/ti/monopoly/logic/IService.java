package be.howest.ti.monopoly.logic;

import be.howest.ti.monopoly.logic.implementation.Game;
import be.howest.ti.monopoly.logic.implementation.tiles.Executing;
import be.howest.ti.monopoly.logic.implementation.tiles.Tile;

import java.util.List;

public interface IService {
    String getVersion();
    
    Game createGame(String prefix, int numberOfPlayers);
    List<Executing> getChance();
    List<Tile> getTiles();
    List<Executing> getCommunityChest();
    Tile getTile(int position);
    Tile getTile(String name);

    Object getGames();
}
