package be.howest.ti.monopoly.web;

import be.howest.ti.monopoly.logic.IService;
import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.implementation.Dice;
import be.howest.ti.monopoly.logic.implementation.Game;

import java.util.*;

import be.howest.ti.monopoly.logic.implementation.Player;
import be.howest.ti.monopoly.logic.implementation.tiles.Executing;
import be.howest.ti.monopoly.logic.implementation.tiles.Tile;
import be.howest.ti.monopoly.web.views.GameView;


public class TestService implements IService {

    IService delegate = new ServiceAdapter();

    void setDelegate(IService delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getVersion() {
        return delegate.getVersion();
    }

    @Override
    public List<Executing> getChance() {
        return delegate.getChance();
    }

    @Override
    public List<Tile> getTiles() {
        return delegate.getTiles();
    }

    @Override
    public List<Executing> getCommunityChest() {
        return delegate.getCommunityChest();
    }

    @Override
    public GameView createGame(String prefix, int numberOfPlayers) {
        return delegate.createGame(prefix, numberOfPlayers);
    }

    @Override
    public Tile getTile(int position) {
        return delegate.getTile(position);
    }

    @Override
    public Tile getTile(String name) {
        return delegate.getTile(name);
    }

    @Override
    public Object buyTile(String gameId, String playerName, String propertyName) {
        return delegate.buyTile(gameId, playerName, propertyName);
    }

    @Override
    public Object dontBuyTile(String gameId, String playerName, String propertyName) {
        return delegate.dontBuyTile(gameId, playerName, propertyName);
    }

    @Override
    public List<Game> getGames() {
        return delegate.getGames();
    }

    @Override
    public Game rollDice(String playerName, String gameId) {
        return delegate.rollDice(playerName, gameId);
    }

    @Override
    public Object declareBankruptcy(String gameId, String playerName) {
        return delegate.declareBankruptcy(gameId, playerName);
    }

    @Override
    public Game getGame(String gameId) {
        return delegate.getGame(gameId);
    }

    @Override
    public Game collectDebt(String gameId, String playerName, String propertyName, String debtorName) {
        return delegate.collectDebt(gameId, playerName, propertyName, debtorName);
    }
    
    @Override
    public Object joinGame(String gameId, String playerToken, Player player) {
        return delegate.joinGame(gameId, playerToken, player);
    }

    @Override
    public Object getGamesLessDetailed() {
        return delegate.getGamesLessDetailed();
    }

    @Override
    public Object clearGameList() {return delegate.clearGameList();}
}
