package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;
import be.howest.ti.monopoly.logic.exceptions.MonopolyResourceNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonopolyServiceTest {

    @Test
    void getVersion() {
        assertEquals("0.0.1", new MonopolyService().getVersion());
    }

    @Test
    void createGame() {
        MonopolyService service = new MonopolyService();
        service.createGame("someprefix", 2);
        assertEquals(1, service.getGames().size());
        assertEquals("someprefix", service.getGame("someprefix").getId());
        assertFalse(service.getGame("someprefix").isStarted());
    }

    @Test
    void getTiles() {
        assertEquals(40, new MonopolyService().getTiles().size());
    }

    @Test
    void joinGame() {
        MonopolyService service = new MonopolyService();
        service.createGame("someprefix", 2);
        service.joinGame("someprefix", "someprefix-Joachim", new Player("Joachim", "someprefix-Joachim"));
        String name = service.getGame("someprefix").getPlayer("Joachim").getName();
        assertEquals("Joachim", name);
    }

    @Test
    void getGames() {
        MonopolyService service = new MonopolyService();
        service.createGame("someprefix", 2);
        service.createGame("someprefix2", 3);
        assertEquals(2, service.getGames().size());
    }

    @Test
    void getGamesLessDetailed() {
        MonopolyService service = new MonopolyService();
        service.createGame("someprefix", 2);
        service.createGame("someprefix2", 3);
        assertEquals(2, service.getGamesLessDetailed().size());
    }

    @Test
    void getGame() {
        MonopolyService service = new MonopolyService();
        service.createGame("someprefix", 2);
        assertNotNull(service.getGame("someprefix"));
    }

    @Test
    void buyTile() {
        MonopolyService service = new MonopolyService();
        service.createGame("someprefix", 2);
        service.joinGame("someprefix", "someprefix-player1", new Player("player1", "someprefix-player1"));
        service.joinGame("someprefix", "someprefix-player2", new Player("player2", "someprefix-player2"));
        assertThrows(MonopolyResourceNotFoundException.class, () -> {
            service.buyTile("someprefix", "player1", "t Zand");
        });
    }

    @Test
    void dontBuyTile() {
    }

    @Test
    void getChance() {
    }

    @Test
    void getCommunityChest() {
    }

    @Test
    void collectDebt() {
    }

    @Test
    void getPlayer() {
    }

    @Test
    void rollDice() {
    }
}