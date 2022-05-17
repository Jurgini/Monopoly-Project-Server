package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;
import be.howest.ti.monopoly.logic.implementation.tiles.Property;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Game implements Comparable<Game> {
    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 10;
    private int numberOfPlayers;
    private boolean started;
    private List<Player> players;
    private String id;

    // DETAILED!!!
    private Property directSale = null;

    private int availableHouses = 32;
    private int availableHotels = 12;

    //private turns
    private int[] lastDiceRoll;
    private Player currentPlayer;
    private boolean canRoll;
    private Player winner;

    private Map<Property, Player> boughtProperty = new HashMap<Property, Player>();
    private List<Turn> turns;

    public Game(String prefix, int numberOfPlayers) {
        this.id = prefix; // TODO: Need to be changed with counter.
        setNumberOfplayers(numberOfPlayers);
        this.players = new ArrayList<>();
    }

    private void setNumberOfPlayers(int numberOfPlayers) {
        if (numberOfPlayers < MIN_PLAYERS || numberOfPlayers > MAX_PLAYERS) {
            throw new IllegalMonopolyActionException("You can only create a game when you have between 2 and 10 players");
        }
        this.numberOfPlayers = numberOfPlayers;

    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;

    }

    public boolean isStarted() {
        return started;
    }

    public Property getDirectSale() {
        return directSale;
    }

    @JsonProperty("directSale")
    public String getDirectSalePropertyName() {
        if (getDirectSale() == null) {
            return null;
        }
        return getDirectSale().getName();
    }

    public int getAvailableHouses() {
        return availableHouses;
    }

    public int getAvailableHotels() {
        return availableHotels;
    }

    public int[] getLastDiceRoll() {
        return lastDiceRoll;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @JsonProperty("CurrentPlayer")
    public String getCurrentPlayerName() {
        if (getCurrentPlayer() == null) {
            return null;
        }
        return getCurrentPlayer().getName();
    }

    public Player getWinner() {
        return winner;
    }

    public Map<Property, Player> getBoughtProperty() {
        return boughtProperty;
    }

    public boolean isEnded() {
        return getWinner() != null;
    }


    @JsonProperty("canRoll")
    public boolean canRoll() {
        return canRoll;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player)
    {
        players.add(player);
    }
    public Player getPlayer(String playerName)
    {
        return getPlayers().stream().filter(player -> player.getName().equals(playerName)).findFirst().orElseThrow();
    }
    public String getId() {
        return id;
    }


    @Override
    public int compareTo(Game o) {
        return this.getId().compareTo(o.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return getNumberOfPlayers() == game.getNumberOfPlayers() && Objects.equals(getId(), game.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfPlayers(), getId());
    }

    public List<Turn> getTurns() {
        return turns;
    }
}
