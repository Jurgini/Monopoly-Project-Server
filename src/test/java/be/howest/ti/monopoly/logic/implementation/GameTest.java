package be.howest.ti.monopoly.logic.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void declareBankruptcy() {
        Game g = new Game("test", 2);
        Player p1 = new Player("Alice", "test-Alice");
        Player p2 = new Player("Bob", "test-Bob");

        g.addPlayer(p1);
        g.addPlayer(p2);


        g.declareBankruptcy("Alice", "test-Alice");
        System.out.println(g);
    }
}