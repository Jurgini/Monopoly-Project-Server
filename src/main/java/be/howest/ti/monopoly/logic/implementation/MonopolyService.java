package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.implementation.tiles.*;
import be.howest.ti.monopoly.logic.exceptions.MonopolyResourceNotFoundException;
import be.howest.ti.monopoly.web.views.GameView;

import java.util.*;


public class MonopolyService extends ServiceAdapter {

    private final SortedSet<Game> gameSet = new TreeSet<>();

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public Game createGame(String prefix, int numberOfPlayers) {
        Game game = new Game(prefix, numberOfPlayers);
        gameSet.add(game);
        return game;
    }

    @Override
    public List<Tile> getTiles() {
        return MonopolyBoard.getTiles();
    }

    @Override
    public Tile getTile(int position) {
        return MonopolyBoard.getTile(position);
    }

    @Override
    public Tile getTile(String name) {
        return MonopolyBoard.getTile(name);
    }

    @Override
    public Set<GameView> getGames() {
        Set<GameView> gameViewSet = new HashSet<>() {
        };
        gameSet.forEach(game -> gameViewSet.add(new GameView(game)));
        return gameViewSet;
    }

    @Override
    public List<Executing> getChance() {
        return MonopolyBoard.getChance();
    }

    @Override
    public List<Executing> getCommunityChest() {
        return MonopolyBoard.getCommunityChest();
    }

    public Game getGame(String gameId) {
        Game filteredGame = gameSet.stream().filter(game -> game.getId().equals(gameId)).findFirst().orElseThrow();
        return filteredGame;
    }

    public Object collectDebt(String gameId, String playerName, String propertyName, String debtorName) {
        Game game = getGame(gameId);
        Player player = game.getPlayer(playerName);
        Player debtor = game.getPlayer(debtorName);
        Tile property = getTile(propertyName);

        return null;
    }
}
