package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.IService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void collectDebt() {
        Game game = new Game("server",2);
        Player tom = new Player("Tom","server-Tom");
        Player tap = new Player("Tap","server-Tap");
        game.setCurrentPlayer(tap);
        game.addPlayer(tom);
        game.addPlayer(tap);
        game.rollDice();
        tom.setCurrentTile(new MonopolyBoard().getTile(1));
        tom.buyProperty(tom.getCurrentTileDetailed());
        System.out.println(tom.getProperties());
        tap.setCurrentTile(new MonopolyBoard().getTile(1));
        System.out.println(tap.getCurrentTile().getCurrentTile());

        game.collectDebt(tom, tap, new MonopolyBoard().getTile(1));
        System.out.println(tap.getMoney());
        System.out.println(tom.getMoney());
    }
}