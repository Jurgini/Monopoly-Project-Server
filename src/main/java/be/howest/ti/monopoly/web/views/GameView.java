package be.howest.ti.monopoly.web.views;

import be.howest.ti.monopoly.logic.implementation.Game;
import be.howest.ti.monopoly.logic.implementation.Player;

import java.util.List;

public class GameView {
    Game game;
    String playerName;

    public GameView(Game game, String playerName) {
        this.game = game;
        this.playerName = playerName;
    }

    public int getNumberOfPlayers(){
        return game.getNumberOfPlayers();
    }

    public List<Player> getPlayers(){
        return game.getPlayers();
    }

    public String getProperty() {
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

    public boolean canRoll() {
        return game.playerCanRoll(playerName);
    }

    public boolean isEnded() {
        return game.isEnded();
    }

    public String getCurrentPlayer() {
        return game.getCurrentPlayer().getName();
    }


}
