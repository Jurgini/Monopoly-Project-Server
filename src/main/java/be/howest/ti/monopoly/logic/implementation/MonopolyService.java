package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;
import be.howest.ti.monopoly.logic.implementation.tiles.*;
import io.vertx.core.json.JsonObject;
import be.howest.ti.monopoly.web.views.GameView;

import java.util.*;


public class MonopolyService extends ServiceAdapter {

    private final SortedSet<Game> gameSet = new TreeSet<>();

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public GameView createGame(String prefix, int numberOfPlayers) {
        Game game = new Game(prefix, numberOfPlayers);
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
                if (checkPlayerExistence(game, player))
                    throw new IllegalMonopolyActionException("Cannot join a game with this name");

                if (amountOfPlayersReached(game))
                    throw new IllegalMonopolyActionException("The game is full");

                game.addPlayer(player);

                if (gameCanStart(game))
                    game.startGame();

                return new JsonObject()
                        .put("token", playerToken);
            }
        }

        return new JsonObject();
    }

    private boolean gameCanStart(Game game) {
        return game.getNumberOfPlayers() == game.getPlayers().size();
    }

    private boolean amountOfPlayersReached(Game game) {
        int newAmountOfPlayers = game.getPlayers().size() + 1;
        return newAmountOfPlayers > game.getNumberOfPlayers();
    }

    private boolean checkPlayerExistence(Game game, Player player) {
        return game.getPlayers().contains(player);
    }

    @Override
    public Set<Game> getGames() {
        return gameSet;
    }

    public Set<GameView> getGamesLessDetailed() {
        Set<GameView> gameViewSet = new HashSet<>() {
        };
        gameSet.forEach(game -> gameViewSet.add(new GameView(game)));
        return gameViewSet;
    }

    @Override
    public Game getGame(String gameId) {
        return gameSet.stream().filter(game -> game.getId().equals(gameId)).findFirst().orElseThrow();
    }

    @Override
    public void buyTile(String gameId, String playerName, String tileName) {
        Game game = getGame(gameId);
        Player player = game.getPlayer(playerName);

        game.buyProperty(player, tileName);
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

    public Object collectDebt(String gameId, String playerName, String propertyName, String debtorName) {
        Game game = getGame(gameId);
        Player player = game.getPlayer(playerName);
        Player debtor = game.getPlayer(debtorName); // moet betalen
        Tile property = getTile(propertyName);

        // todo: Check if player can pay, otherwise set debt.
        int rent = player.getRent(property);

        if (debtor.getMoney() - rent >= 0) {
            debtor.payMoney(rent);
        } else {
            debtor.setDebt(rent);
        }
        player.receiveMoney(rent);

        return null;
    }
}
