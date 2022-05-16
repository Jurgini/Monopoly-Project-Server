package be.howest.ti.monopoly.logic;

import be.howest.ti.monopoly.logic.implementation.Dice;
import be.howest.ti.monopoly.logic.implementation.Game;
import be.howest.ti.monopoly.logic.implementation.tiles.Tile;
import be.howest.ti.monopoly.web.views.GameView;

import java.util.*;

public interface IService {
    String getVersion();
    
    Game createGame(String prefix, int numberOfPlayers);

    List<String> getChance();
    List<Tile> getTiles();
    List<String> getCommunityChest();
    Tile getTile(int position);
    Tile getTile(String name);

    Dice rollDice(String playerName, String gameId);
    Set<GameView> getGames();
    Game getGame(String gameId);

}
