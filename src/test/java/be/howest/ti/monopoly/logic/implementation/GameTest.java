package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.IService;

import be.howest.ti.monopoly.logic.implementation.tiles.Tile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void declareBankruptcy() {
        Game g = new Game("test", 3);
        Player p1 = new Player("Alice", "test-Alice");
        Player p2 = new Player("Bob", "test-Bob");
        Player p3 = new Player("Carol", "test-Carol");
        Tile currentTile = new MonopolyBoard().getTile(6);

        g.addPlayer(p1);
        g.addPlayer(p2);
        g.addPlayer(p3);
        g.setCurrentPlayer(p1);

        p1.setCurrentTile(currentTile);
        g.buyProperty(p1, p1.getCurrentTile().getCurrentTile());
        p1.setCurrentTile(new MonopolyBoard().getTile(1));
        g.buyProperty(p1, p1.getCurrentTile().getCurrentTile());

        System.out.println("bought properties " + p1.getProperties());


        //p1.setDebt(900);
        g.sellFirstBoughtHouse(p1);
        System.out.println("PLAYER DEBT " + p1.getDebt());

        System.out.println("ALL BOUGHT PROPERTIES " + g.getAllBoughtProperties());
        //g.declareBankruptcy("test-Alice", p1);

        System.out.println("LIST IDX : " + g.getPlayers().get(0));
        System.out.println("CURRENT : " + g.getCurrentPlayer().getName());

        g.rollDice();

        System.out.println(g.getPlayers());
        System.out.println("NEXT PLAYER : " + g.getCurrentPlayer().getName());

        System.out.println("winner? " + g.getWinner());
        System.out.println("player list size: " + g.getPlayers().size());


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