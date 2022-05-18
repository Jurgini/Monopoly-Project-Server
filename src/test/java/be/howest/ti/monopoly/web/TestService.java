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
    public Object buyProperty(String gameId, String playerName, String propertyName) {
        return delegate.buyProperty(gameId, playerName, propertyName);
    }

    @Override
    public Set<Game> getGames() {
        return delegate.getGames();
    }

    @Override
    public int[] rollDice(String playerName, String gameId) {
        return delegate.rollDice(playerName, gameId);
    }

    @Override
    public Game getGame(String gameId) {
        return delegate.getGame(gameId);
    }

    @Override
    public Object collectDebt(String gameId, String playerName, String propertyName, String debtorName) {
        return delegate.collectDebt(gameId, playerName, propertyName, debtorName);
    }
    
    @Override
    public Object joinGame(String gameId, String playerToken, Player player) {
        return delegate.joinGame(gameId, playerToken, player);
    }

<<<<<<< HEAD
=======
    @Override
    public Object getGamesLessDetailed() {
        return delegate.getGamesLessDetailed();
    }
>>>>>>> 9a79f0cda51e5d658413b8e44e7cd01627057c38
}
