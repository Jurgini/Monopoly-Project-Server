package be.howest.ti.monopoly.web.views;

import be.howest.ti.monopoly.logic.implementation.Game;
import be.howest.ti.monopoly.logic.implementation.Player;

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
        return game.getPlayers();
    }

    public void addPlayer(Player player)
    {
        this.game.addPlayer(player);
    }

}
