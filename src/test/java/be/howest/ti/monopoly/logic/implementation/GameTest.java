package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.IService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void declareBankruptcy() {
        Game g = new Game("test", 2);
        Dice d = new Dice();
        Player p1 = new Player("Alice", "test-Alice");
        Player p2 = new Player("Bob", "test-Bob");

        g.addPlayer(p1);
        g.addPlayer(p2);
        g.setCurrentPlayer(p1);
        g.rollDice();


        g.declareBankruptcy("Alice", "test-Alice");
        System.out.println(g.getPlayers());
    }

    void collectDebt() {
        Game game = new Game("server", 2);
        Player tom = new Player("Tom", "server-Tom");
        Player tap = new Player("Tap", "server-Tap");
        game.setCurrentPlayer(tap);
        game.addPlayer(tom);
        game.addPlayer(tap);
        tap.payMoney(15000);
        game.rollDice();
        tom.setCurrentTile(new MonopolyBoard().getTile(1));
        tom.buyProperty(tom.getCurrentTileDetailed());
        tap.setCurrentTile(new MonopolyBoard().getTile(1));
        game.collectDebt(tom, tap, new MonopolyBoard().getTile(1));
        assertEquals(tap.getDebt(), 20);

    }
}