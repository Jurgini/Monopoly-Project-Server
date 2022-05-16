package be.howest.ti.monopoly.web.views;

import be.howest.ti.monopoly.logic.implementation.Game;
import be.howest.ti.monopoly.logic.implementation.Player;
import be.howest.ti.monopoly.logic.implementation.Turn;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GameView {
    Game game;
    String playerName;

    public GameView(Game game) {
        this.game = game;
        this.playerName = playerName;
    }

    public int getNumberOfPlayers() {
        return game.getNumberOfPlayers();
    }

    public List<Player> getPlayers() {
        return game.getPlayers();
    }

    public String getProperty() {
        if (game.getDirectSale() == null) {
            return null;
        }
        return game.getDirectSale().getName();
    }

    public int getAvailableHouses() {
        return game.getAvailableHouses();
    }

    public int getAvailableHotels() {
        return game.getAvailableHotels();
    }

    public List<Turn> getTurns() {
        return game.getTurns();
    }

    public int[] getLastDiceRoll() {
        return game.getLastDiceRoll();
    }

    @JsonProperty("canRoll")
    public boolean canRoll() {
        return game.canRoll();
    }

    public boolean isEnded() {
        return game.isEnded();
    }

    public String getCurrentPlayer() {
        if (game.getCurrentPlayer() == null) {
            return null;
        }
        return game.getCurrentPlayer().getName();
    }


}
