package be.howest.ti.monopoly.web.views;

import be.howest.ti.monopoly.logic.implementation.Game;

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

    public List<String> getPlayers() {
        List<String> players = new ArrayList<>();
        for (int i = 0; i < game.getPlayers().size(); i++) {
            players.add(game.getPlayers().get(i).getName());
        }
        return players;
    }

    public boolean isStarted() {
        return game.isStarted();
    }

    public void addPlayer(Player player)
    {
        this.game.addPlayer(player);
    }

}
