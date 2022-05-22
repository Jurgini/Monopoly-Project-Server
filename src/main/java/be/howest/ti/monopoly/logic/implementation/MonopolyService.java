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
        for (Game game: getGames())
        {
            if (game.getId().equals(gameId))
            {
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

    @Override
    public List<GameView> getGamesLessDetailed()
    {
        List<GameView> gameViewSet = new ArrayList<>() {};
        gameSet.forEach(game -> {
            if (!game.isStarted())
            {
                gameViewSet.add(new GameView(game));
            }
        });
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

        return game.dontBuyProperty(player, tileName);
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
        Player debtor = game.getPlayer(debtorName);
        Tile property = getTile(propertyName);


        return game.collectDebt(player, debtor, property);

    }


    public Player getPlayer(String gameId, String playerName) {
        Player foundPlayer = getGame(gameId).getPlayers().stream().filter(player -> player.getName().equals(playerName)).findFirst().orElseThrow();
        return foundPlayer;
    }

    @Override
    public Game rollDice(String playerName, String gameId) {
        if(!getGame(gameId).getCurrentPlayer().getName().equals(playerName))
        {
            throw new IllegalMonopolyActionException("You can't roll the dice!");
        }
        return getGame(gameId).rollDice();
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

    @Override
    public Object clearGameList()
    {
        for (Game game : gameSet) {
            if (!game.isStarted() || game.isEnded()) {
                gameSet.remove(game);
            }
        }
        return gameSet;
    }

    @Override
    public Object declareBankruptcy(String gameId, String playerName) {
        return getGame(gameId).declareBankruptcy(gameId, playerName);
    }
}
