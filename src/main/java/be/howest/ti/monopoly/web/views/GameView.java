package be.howest.ti.monopoly.web.views;

import be.howest.ti.monopoly.logic.implementation.Game;
import be.howest.ti.monopoly.logic.implementation.Player;
import be.howest.ti.monopoly.logic.implementation.Turn;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class GameView {
    Game game;

    public GameView(Game game) {
        this.game = game;
    }

    public String getId() {
        return game.getId();
    }

    public int getNumberOfPlayers() {
        return game.getNumberOfPlayers();
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < game.getPlayers().size(); i++) {
            players.add(game.getPlayers().get(i));
        }
        return players;
    }

    public boolean isStarted() {
        return game.isStarted();
    }

    @JsonIgnore
    public List<Turn> getTurns()
    {
        return game.getTurns();
    }




}
