package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;
import be.howest.ti.monopoly.logic.implementation.tiles.*;
import io.vertx.core.json.JsonObject;
import be.howest.ti.monopoly.web.views.GameView;

import java.util.*;


public class MonopolyService extends ServiceAdapter {

    private final List<Game> gameSet = new ArrayList<>();

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public GameView createGame(String prefix, int numberOfPlayers) {
        Game game = new Game(prefix, numberOfPlayers);
        if (getGames().contains(game))
            throw new IllegalArgumentException("A game with the name " + prefix + " already exists");
        gameSet.add(game);
        return new GameView(game);
    }

    @Override
    public List<Tile> getTiles() {
        return new MonopolyBoard().getTiles();
    }

    @Override
    public Object joinGame(String gameId, String playerToken, Player player) {
        for (Game game : getGames()) {
            if (game.getId().equals(gameId)) {
                game.join(player);

                return new JsonObject()
                        .put("token", playerToken);

            }
        }

        return new JsonObject();
    }

    @Override
    public List<Game> getGames() {
        return gameSet;
    }

    public List<GameView> getGamesLessDetailed() {
        List<GameView> gameViewSet = new ArrayList<>() {
        };
        gameSet.forEach(game -> gameViewSet.add(new GameView(game)));
        return gameViewSet;
    }

    @Override
    public Game getGame(String gameId) {
        return gameSet.stream().filter(game -> game.getId().equals(gameId)).findFirst().orElseThrow();
    }

    @Override
    public Object buyTile(String gameId, String playerName, String tileName) {
        Game game = getGame(gameId);
        Player player = game.getPlayer(playerName);

        return game.buyProperty(player, tileName);
    }

    @Override
    public Object dontBuyTile(String gameId, String playerName, String tileName) {

        Game game = getGame(gameId);
        Player player = game.getPlayer(playerName);

        for (Tile tile : new MonopolyBoard().getTiles()) {
            if (tile.getName().equals(tileName)) {
                if (!tile.getName().equals(tileName)) {
                    throw new IllegalMonopolyActionException("Tile not found");
                } else if (getGame(gameId) == null) {
                    throw new IllegalMonopolyActionException("There is no game with this Id");
                } else if (game.getCurrentPlayer().equals(player)) {
                    throw new IllegalMonopolyActionException("You cant deny a property only the current player can");
                } else {
                    return new JsonObject().put("property", tileName).put("purchased", false);
                }

            }
        }
        throw new IllegalMonopolyActionException("Not a buy-able tile");
    }

    @Override
    public List<Executing> getChance() {
        return MonopolyBoard.getChance();
    }

    @Override
    public List<Executing> getCommunityChest() {
        return MonopolyBoard.getCommunityChest();
    }

    @Override
    public Game collectDebt(String gameId, String playerName, String propertyName, String debtorName) {
        Game game = getGame(gameId);
        Player player = game.getPlayer(playerName);
        Player debtor = game.getPlayer(debtorName); // moet betalen
        Tile property = getTile(propertyName);

        // todo: Check if player can pay, otherwise set debt.
        return game.collectDebt(player, debtor, property);

    }


    public Player getPlayer(String gameId, String playerName) {
        Player foundPlayer = getGame(gameId).getPlayers().stream().filter(player -> player.getName().equals(playerName)).findFirst().orElseThrow();
        return foundPlayer;
    }

    @Override
    public Game rollDice(String playerName, String gameId) {
        return getGame(gameId).rollDice();
    }


    public Object declareBankruptcy(String gameId, Player player) {
        return getGame(gameId).declareBankruptcy(gameId, player);
    }

    @Override
    public Tile getTile(int position) {
        List<Tile> tiles = new MonopolyBoard().getTiles();
        Tile foundTile = tiles.stream().filter(tile -> tile.getPosition() == position).findFirst().orElseThrow();
        return foundTile;
    }


    @Override
    public Tile getTile(String name) {
        List<Tile> tiles = new MonopolyBoard().getTiles();
        Tile foundTile = tiles.stream().filter(tile -> tile.getName().equals(name)).findFirst().orElseThrow();
        return foundTile;

    }
}

