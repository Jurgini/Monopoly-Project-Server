package be.howest.ti.monopoly.web;

import be.howest.ti.monopoly.logic.IService;
import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.implementation.Dice;
import be.howest.ti.monopoly.logic.implementation.Game;

import java.util.List;
import java.util.SortedSet;

import be.howest.ti.monopoly.logic.implementation.tiles.Tile;


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
    public List<String> getChance() {
        return delegate.getChance();
    }

    @Override
    public List<Tile> getTiles() {
        return delegate.getTiles();
    }

    @Override
    public List<String> getCommunityChest() {
        return delegate.getCommunityChest();
    }

    @Override
    public Game createGame(String prefix, int numberOfPlayers) {
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
    public SortedSet<Game> getGames() {
        return delegate.getGames();
    }

    @Override
    public Dice rollDice(String playerName, String gameId) {
        return delegate.rollDice(playerName, gameId);
    }

    @Override
    public Game getGame(String gameId) {
        return delegate.getGame(gameId);
    }

}
