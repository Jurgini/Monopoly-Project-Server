package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Game implements Comparable<Game> {

    // TODO: implement these
    private boolean canRoll;
    private Player currentPlayer;
    private Array turns;
    private boolean ended; //refers to the entire game being ended
    //
    private int numberOfPlayers;
    private boolean started;
    private List<Player> players;
    private final String id;


    public Game(String prefix, int numberOfPlayers) {
        this.id = prefix; // TODO: Need to be changed with counter.
        setNumberOfPlayers(numberOfPlayers);
        this.players = List.of(new Player("tuurkee"));
        this.currentPlayer = players.get(0);
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        if (numberOfPlayers >= 2 && numberOfPlayers <= 10)
            this.numberOfPlayers = numberOfPlayers;
        else {
            throw new IllegalMonopolyActionException("You can only create a game when you have between 2 and 10 players");
        }
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        // TODO
        //when game begins
            // 1st player in players List = currentPlayer
            // if turn ended --> next player in players List = currentPlayer

            //when does the turn end??
                // when dice is rolled?
                // the current card action is over (buying)?

    }

    public boolean isStarted() {
        return started;
    }

    public List<Player> getPlayers() {
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
