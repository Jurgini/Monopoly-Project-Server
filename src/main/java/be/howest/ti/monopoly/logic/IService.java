package be.howest.ti.monopoly.logic;


import be.howest.ti.monopoly.logic.implementation.Game;
import be.howest.ti.monopoly.logic.implementation.Tile;
import java.util.List;

public interface IService {
    String getVersion();
    
    Game createGame(String prefix, int numberOfPlayers);
    List<Tile> getTiles();
    List<String> getCommunityChest();
    Tile getTile(int position);
    Tile getTile(String name);
    Object clearGameList();
}
