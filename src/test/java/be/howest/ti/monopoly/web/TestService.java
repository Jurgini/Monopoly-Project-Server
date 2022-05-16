package be.howest.ti.monopoly.web;

import be.howest.ti.monopoly.logic.IService;
import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.implementation.Game;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.List;

import be.howest.ti.monopoly.logic.implementation.tiles.Executing;
=======
import java.util.*;

>>>>>>> 400b655e73d3c8ff98215f3db9abef6958816b38
=======
import java.util.*;

>>>>>>> 6f6798a1f8a1df414181e329e804d327e95ab536
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
    public Set<GameView> getGames() {
        return delegate.getGames();
    }

    @Override
    public Game getGame(String gameId) {
        return delegate.getGame(gameId);
    }
}
