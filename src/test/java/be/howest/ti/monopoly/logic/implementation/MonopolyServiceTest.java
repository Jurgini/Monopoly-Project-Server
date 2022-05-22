package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertThrows(IllegalMonopolyActionException.class, () -> {
            service.buyTile("someprefix", "player1", "Marksesteenweg");
        });
    }

    @Test
    void dontBuyTile() {
        MonopolyService service = new MonopolyService();
        service.createGame("someprefix", 2);
        service.joinGame("someprefix", "someprefix-player1", new Player("player1", "someprefix-player1"));
        service.joinGame("someprefix", "someprefix-player2", new Player("player2", "someprefix-player2"));
        assertThrows(IllegalMonopolyActionException.class, () -> {
            service.buyTile("someprefix", "player1", "Marksesteenweg");
        });
    }

    @Test
    void getChance() {
        assertEquals(15, new MonopolyService().getChance().size());
    }

    @Test
    void getCommunityChest() {
        assertEquals(17, new MonopolyService().getCommunityChest().size());
    }

    @Test
    void getPlayer() {
        MonopolyService service = new MonopolyService();
        service.createGame("someprefix", 2);
        service.joinGame("someprefix", "someprefix-player1", new Player("player1", "someprefix-player1"));
        service.joinGame("someprefix", "someprefix-player2", new Player("player2", "someprefix-player2"));
        assertEquals("player1", service.getGame("someprefix").getPlayer("player1").getName());
    }

    @Test
    void rollDice() {
        MonopolyService service = new MonopolyService();
        service.createGame("someprefix", 2);
        Player player1 = new Player("player1", "someprefix-player1");
        Player player2 = new Player("player2", "someprefix-player2");
        service.joinGame("someprefix", "someprefix-player1", player1);
        service.joinGame("someprefix", "someprefix-player2", player2);
        Game game = service.getGame("someprefix");
        game.rollDice();
        if (game.getLastDiceRoll()[0] == game.getLastDiceRoll()[1])
        {
            assertEquals(player1.getName(), game.getCurrentPlayer().getName());
        }
        else
        {
            assertEquals(player2.getName(), game.getCurrentPlayer().getName());
        }
        assertNotEquals(0, player1.getCurrentTileDetailed().getPosition());
    }
  /*  @Test
    void clearGameList()
    {
        MonopolyService service = new MonopolyService();
        service.createGame("someprefix", 2);
        service.createGame("someprefix2", 2);
        service.createGame("someprefix3", 2);
        Game game = service.getGame("someprefix");
        Game game2 = service.getGame("someprefix2");
        Game game3 = service.getGame("someprefix3");
        List<Game> allGames = service.getGames();
        List<Game> testGames = null;
        testGames.add(game2);
        testGames.add(game3);
        Player player1 = new Player("player1", "someprefix-player1");
        Player player2 = new Player("player2", "someprefix-player2");
        game.addPlayer(player1);
        game.addPlayer(player2);
        if(game.isStarted())
        {
            assertEquals(allGames,testGames);
        }
        else
        {
            assertEquals(allGames,allGames);
        }

    }*/
}