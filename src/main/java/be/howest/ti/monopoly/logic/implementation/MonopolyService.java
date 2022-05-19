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
    public List<Tile> getTiles() {
        return MonopolyBoard.getTiles();
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
    public Tile getTile(int position) {
        return MonopolyBoard.getTile(position);
    }

    @Override
    public Tile getTile(String name) {
        return MonopolyBoard.getTile(name);
    }

    @Override
    public List<Game> getGames() {
        return gameSet;
    }

    public List<GameView> getGamesLessDetailed()
    {
        List<GameView> gameViewSet = new ArrayList<>() {};
        gameSet.forEach(game -> gameViewSet.add(new GameView(game)));
        return gameViewSet;
    }

    @Override
    public Game getGame(String gameId) {
        Game filteredGame = gameSet.stream().filter(game -> game.getId().equals(gameId)).findFirst().orElseThrow();
        return filteredGame;
    }

    @Override
    public Object buyTile(String gameId, String playerName, String tileName) {

        Game game = getGame(gameId);
        Player player = game.getPlayer(playerName);

        for (Tile tile : MonopolyBoard.getTiles()) {
            if (tile.getName().equals(tileName) && player.getMoney() >= ((Property) getTile(tileName)).getCost()) {
                if (!tile.getName().equals(tileName)) {
                    throw new IllegalMonopolyActionException("Property not found");
                } else if (getGame(gameId) == null) {
                    throw new IllegalMonopolyActionException("There is no game with this Id");
                } else if (game.getCurrentPlayer().equals(player)) {
                    throw new IllegalMonopolyActionException("You cant buy a property only the current player can");
                }

                if (!player.getCurrentTile().equals(tile.getName())) {
                    throw new IllegalMonopolyActionException("You are not on this tile");
                }
                if (tile instanceof Street) {
                    player.payMoney(((Property) getTile(tileName)).getCost());
                    player.addProperty(((Property) getTile(tileName)));
                } else if (tile instanceof Railroad) {
                    player.payMoney(((Railroad) getTile(tileName)).getCost());
                    player.addProperty(((Railroad) getTile(tileName)));
                } else if (tile instanceof Utility) {
                    player.payMoney(((Utility) getTile(tileName)).getCost());
                    player.addProperty(((Utility) getTile(tileName)));
                }
                dontBuyTile(gameId, playerName, tileName);
                throw new IllegalMonopolyActionException("You dont have enough money");
            }
        }
        throw new IllegalMonopolyActionException("Not a buy-able tile");
    }

    @Override
    public Object dontBuyTile(String gameId, String playerName, String tileName) {

        Game game = getGame(gameId);
        Player player = game.getPlayer(playerName);

        for (Tile tile : MonopolyBoard.getTiles()) {
            if (tile.getName().equals(tileName)) {
                if (!tile.getName().equals(tileName)) {
                    throw new IllegalMonopolyActionException("Tile not found");
                } else if (getGame(gameId) == null) {
                    throw new IllegalMonopolyActionException("There is no game with this Id");
                } else if (game.getCurrentPlayer().equals(player)) {
                    throw new IllegalMonopolyActionException("You cant deny a property only the current player can");
                }
                else
                {
                    return new JsonObject().put("property",tileName).put("purchased",false);
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
    public GameView rollDice(String playerName, String gameId) {
        return getGame(gameId).rollDice();
    }
}
