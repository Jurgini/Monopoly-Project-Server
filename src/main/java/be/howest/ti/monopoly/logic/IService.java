package be.howest.ti.monopoly.logic;


<<<<<<< src/main/java/be/howest/ti/monopoly/logic/IService.java
import be.howest.ti.monopoly.logic.implementation.Game;
import be.howest.ti.monopoly.logic.implementation.tiles.Tile;
import java.util.List;

public interface IService {
    String getVersion();
    
    Game createGame(String prefix, int numberOfPlayers);
    List<Tile> getTiles();
    List<String> getCommunityChest();
    Tile getTile(int position);
    Tile getTile(String name);

    Object getGames();
}
