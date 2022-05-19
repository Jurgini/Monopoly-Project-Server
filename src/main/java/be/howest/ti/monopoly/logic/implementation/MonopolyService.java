package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;
import be.howest.ti.monopoly.logic.implementation.tiles.*;
import be.howest.ti.monopoly.logic.exceptions.MonopolyResourceNotFoundException;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import be.howest.ti.monopoly.web.views.GameView;

import java.util.*;
import java.util.stream.Collectors;


public class MonopolyService extends ServiceAdapter {

    private final SortedSet<Game> gameSet = new TreeSet<>();

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public List<Tile> getTiles() {
        return MonopolyBoard.getTiles();
    }

    @Override
    public GameView createGame(String prefix, int numberOfPlayers) {
        Game game = new Game(prefix, numberOfPlayers);
        gameSet.add(game);
        return new GameView(game);
    }

    @Override
    public Object joinGame(String gameId, String playerToken, Player player) {
        for (Game game: getGames())
        {
            if (game.getId().equals(gameId))
            {
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
        int newAmountOfPlayers = game.getPlayers().size()+1;
        return newAmountOfPlayers > game.getNumberOfPlayers();
    }

    private boolean checkPlayerExistence(Game game, Player player) {
        return game.getPlayers().contains(player);
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
    public Set<Game> getGames() {
        Set<Game> filteredGames = gameSet.stream().filter(game -> !game.isStarted()).collect(Collectors.toSet());
        return filteredGames;
    }

    public Set<GameView> getGamesLessDetailed()
    {
        Set<GameView> gameViewSet = new HashSet<>() {};
        gameSet.forEach(game -> gameViewSet.add(new GameView(game)));
        return gameViewSet;
    }

    @Override
    public Game getGame(String gameId) {
        Game filteredGame = gameSet.stream().filter(game -> game.getId().equals(gameId)).findFirst().orElseThrow();
        return filteredGame;
    }

    @Override
    public Object buyProperty(String gameId, String playerName, String propertyName) {

        Game game = getGame(gameId);
        Player player = game.getPlayer(playerName);
        for (Tile tile : getTiles()) {
            if (tile.getName().equals(propertyName) && getGame(gameId) != null) {

                player.payMoney(((Property) getTile(propertyName)).getCost());
                player.addProperty(((Property) getTile(propertyName)));
            }
        }
        return null;
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
    public Object collectDebt(String gameId, String playerName, String propertyName, String debtorName) {
        Game game = getGame(gameId);
        Player player = game.getPlayer(playerName);
        Player debtor = game.getPlayer(debtorName); // moet betalen
        Tile property = getTile(propertyName);

        // todo: Check if player can pay, otherwise set debt.
        int rent = player.getRent(property);

        if (debtor.getMoney()-rent >= 0){
            debtor.payMoney(rent);
        }
        else {
            debtor.setDebt(rent);
        }
        player.receiveMoney(rent);

        return null;
    }


    public Player getPlayer(String gameId, String playerName){
        Player foundPlayer = getGame(gameId).getPlayers().stream().filter(player -> player.getName().equals(playerName)).findFirst().orElseThrow();
        return foundPlayer;
    }

    @Override
    public Game rollDice(String playerName, String gameId) {
        return getGame(gameId).rollDice();
    }
}
