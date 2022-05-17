package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;
import be.howest.ti.monopoly.logic.implementation.tiles.*;
import be.howest.ti.monopoly.logic.exceptions.MonopolyResourceNotFoundException;
import io.vertx.core.json.Json;
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
    public Game createGame(String prefix, int numberOfPlayers) {
        Game game = new Game(prefix, numberOfPlayers);
        gameSet.add(game);
        return game;
    }

    @Override
    public Object joinGame(String gameId, String playerToken, Player player) {
        SortedSet<Game> createdGames = getGames();

        for (Game game: createdGames)
        {
            if (game.getId().equals(gameId))
            {
                if (checkPlayerExistence(game, player))
                    throw new IllegalMonopolyActionException("Cannot join a game with this name");

                game.addPlayer(player);

                return new JsonObject()
                        .put("token", playerToken);
            }
        }

        return new JsonObject();
    }

    private boolean checkPlayerExistence(Game game, Player player) {
        return game.getPlayers().contains(player);
    }

    @Override
    public Tile getTile(int position) {
        for (Tile tile : getTiles()) {
            if (tile.getPosition() == position) {
                return tile;
            }
        }
        throw new MonopolyResourceNotFoundException("Tile not found");
    }

    @Override
    public Tile getTile(String name) {
        for (Tile tile : getTiles()) {
            if (tile.getName().equals(name)) {
                return tile;
            }
        }
        throw new MonopolyResourceNotFoundException("Tile not found");
    }

    @Override
    public Set<GameView> getGames() {
        Set<GameView> gameViewSet = new HashSet<>() {
        };
        gameSet.forEach(game -> gameViewSet.add(new GameView(game)));
        return gameViewSet;
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
        return List.of(
                new Executing("Advance to Go (Collect 2000)", 2000, Action.ADVANCE_AND_COLLECT),
                new Executing("Go to Boulevard d'Avroy—If you pass Go, collect 2000", 2000, Action.ADVANCE_AND_COLLECT),
                new Executing("Go to Rijsselstraat—If you pass Go, collect 2000", 2000, Action.ADVANCE_AND_COLLECT),
                new Executing("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.", 0, Action.BUY_OR_IF_OWNED_THROW_AND_PAY),
                new Executing("Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.", 0, Action.PAY_OR_BUY_IF_UNOWNED),
                new Executing("Your studentloan got deposited, Collect 4000", 4000, Action.COLLECT),
                new Executing("Your friends owe you a favour to dig you out of jail with a spoon when needed", 0, Action.OUT_OF_JAIL_CARD),
                new Executing("You got drunk and could'nt stop stumbling–Go Back 2 Spaces", 0, Action.ADVANCE),
                new Executing("You were off da perc and gave a cop a wedgie–Go to jail now!–Do not pass Go, do not collect 2000", 0, Action.TO_JAIL),
                new Executing("Make general repairs on all your property–For each dorm pay 250–For each complex €1000", 250, Action.PAY_BANK),
                new Executing("You got mugged at a party–You lost 150", 150, Action.PAY_BANK),
                new Executing("Take a walk on the Oude Markt–Advance token to Oude Markt", 0, Action.ADVANCE),
                new Executing("CONGRATULATIONS, you lost a bet–Pay everyone 500", 500, Action.PAY_EVERYONE),
                new Executing("You've worked in a bar during the holidays–Collect 1500", 1500, Action.COLLECT),
                new Executing("You bought a lottery ticket and got some cash in return–You won 1000", 1000, Action.COLLECT)

        );
    }

    @Override
    public List<Executing> getCommunityChest() {
        return List.of(
                new Executing("Advance to Go—Collect 2000", 2000, Action.ADVANCE_AND_COLLECT),
                new Executing("You are BLESSED, the holy angels of god came to give you cash!—Collect 2000", 2000, Action.COLLECT),
                new Executing("You've lost a parlay—Pay 500", 500, Action.PAY_BANK),
                new Executing("You've won a parlay—Collect 500", 500, Action.COLLECT),
                new Executing("Your friends owe you a favour to dig you out of jail with a spoon when needed", 0, Action.OUT_OF_JAIL),
                new Executing("You were off da perc and gave a cop a wedgie—Go to jail now!—Do not pass Go, do not collect 2000", 2000, Action.ADVANCE),
                new Executing("You want to organize a house party with friends—Collect 500 from every player for the booze and snacks", 500, Action.COLLECT),
                new Executing("Student association funds—Receive 1000", 1000, Action.COLLECT),
                new Executing("You begged your parents for some extra allowance. - Collect 2000", 2000, Action.COLLECT),
                new Executing("It's your birthday—Collect 100", 100, Action.COLLECT),
                new Executing("You walked into a street light and broke your nose—Pay 1000 in hospital fees", 1000, Action.PAY_BANK),
                new Executing("You took a STD-test—Pay 1000", 1000, Action.PAY_BANK),
                new Executing("You pay back some of your student loan—Pay 1500", 1500, Action.PAY_BANK),
                new Executing("Someone asked you to tutor them in maths—Receive 250", 250, Action.COLLECT),
                new Executing("The police is raiding your house.—Repair the doors: 400 per house-1200 per hotel", 400, Action.PAY_BANK),
                new Executing("You asked someone to lend money and never payed it back —Receive 100", 100, Action.COLLECT),
                new Executing("You ask your parents for money to buy a new school laptop and receive 1000", 1000, Action.COLLECT)
        );
    }

    public Game getGame(String gameId) {
        Game filteredGame = gameSet.stream().filter(game -> game.getId().equals(gameId)).findFirst().orElseThrow();
        return filteredGame;
    }
}
