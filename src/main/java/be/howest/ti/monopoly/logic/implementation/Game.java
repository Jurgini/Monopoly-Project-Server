package be.howest.ti.monopoly.logic.implementation;
import java.util.List;
import java.util.Objects;

public class Game implements Comparable<Game>{
    int numberOfPlayers;
    boolean started;
    List<String> players;
    String id;

    public Game(String prefix, int numberOfPlayers) {
        this.id = prefix; // TODO: Need to be changed with counter.
        this.numberOfPlayers = numberOfPlayers;
    }


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public boolean isStarted() {
        return started;
    }

    public List<String> getPlayers() {
        return players;
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
