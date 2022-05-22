package be.howest.ti.monopoly.logic;

import be.howest.ti.monopoly.logic.implementation.Game;
import be.howest.ti.monopoly.logic.implementation.Player;
import be.howest.ti.monopoly.logic.implementation.tiles.Executing;
import be.howest.ti.monopoly.logic.implementation.tiles.Tile;
import be.howest.ti.monopoly.web.views.GameView;

import java.util.*;

public class ServiceAdapter implements IService {

    @Override
    public String getVersion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public GameView createGame(String prefix, int numberOfPlayers) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object dontBuyTile(String gameId, String playerName, String tileName){throw new UnsupportedOperationException();}

    @Override
    public List<Executing> getChance() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Tile> getTiles() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Executing> getCommunityChest() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Tile getTile(int position) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Tile getTile(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object buyTile(String gameId, String playerName, String propertyName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Game> getGames() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Game getGame(String gameId) {
        throw new UnsupportedOperationException();
    }


    @Override
    public Game collectDebt(String gameId, String playerName, String propertyName, String debtorName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object joinGame(String gameId, String playerToken, Player player) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getGamesLessDetailed() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Game rollDice(String playerName, String gameId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object clearGameList() {throw new UnsupportedOperationException();}

    @Override
    public Object declareBankruptcy(String gameId, String player){
        throw new UnsupportedOperationException();
    }
}
