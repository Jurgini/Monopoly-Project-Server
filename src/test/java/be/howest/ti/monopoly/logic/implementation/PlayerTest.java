package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.implementation.tiles.Tile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void payMoney() {
        Game game = new Game("test-game", 3);
        Player p1 = new Player("Alice", "token");
        Player p2 = new Player("Bob", "token");
        MonopolyBoard board = new MonopolyBoard();
        Tile currentTile = board.getTile(39);

        p1.setCurrentTile(currentTile);
        p1.buyProperty(game, currentTile);
        assertEquals(11000, p1.getMoney());

        p1.buyProperty(game, currentTile);
        assertEquals(7000, p1.getMoney());

        p1.buyProperty(game, currentTile);
        assertEquals(3000, p1.getMoney());


        assertEquals(3, p1.getProperties().size());
    }

    @Test
    void removeProperty() {
    }

    @Test
    void removePropertyByIndex() {
    }
}