package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;

import java.util.*;

public class Game implements Comparable<Game> {
    private int numberOfPlayers;
    private boolean started;
    private List<Player> players;
    private final String id;

    public Game(String prefix, int numberOfPlayers) {
        this.id = prefix; // TODO: Need to be changed with counter.
        setNumberOfplayers(numberOfPlayers);
        this.players = new ArrayList<>();
    }

    public void setNumberOfplayers(int numberOfPlayers) {
        if (numberOfPlayers >= 2 && numberOfPlayers <= 10)
            this.numberOfPlayers = numberOfPlayers;
        else {
            throw new IllegalMonopolyActionException("You can only create a game when you have between 2 and 10 players");
        }
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;

    }

    public boolean isStarted() {
        return started;
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
}
