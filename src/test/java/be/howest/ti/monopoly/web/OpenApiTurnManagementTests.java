package be.howest.ti.monopoly.web;

import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.implementation.Game;
import be.howest.ti.monopoly.logic.implementation.Player;
import be.howest.ti.monopoly.web.tokens.MonopolyUser;
import be.howest.ti.monopoly.web.tokens.TokenManager;
import be.howest.ti.monopoly.web.views.GameView;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;


class OpenApiTurnManagementTests extends OpenApiTestsBase {

    @Test
    void rollDice(final VertxTestContext testContext) {
        service.setDelegate(new ServiceAdapter() {
            @Override
            public Game rollDice(String playerName, String gameId) {

                Game g = new Game("testgame", 2);
                        g.addPlayer(new Player("Alice", "testgame-Alice"));
                return g;
            }
        });
        post(
                testContext,
                "/games/testgame/players/Alice/dice",
                "testgame-Alice",
                response -> assertOkResponse(response)
        );
    }

    @Test
    void rollDiceUnauthorized(final VertxTestContext testContext) {
        post(
                testContext,
                "/games/game-id/players/Alice/dice",
                null,
                response -> assertErrorResponse(response, 401)
        );
    }

    @Test
    void declareBankruptcy(final VertxTestContext testContext) {
        service.setDelegate(new ServiceAdapter(){
            @Override
            public Object declareBankruptcy(String gameId, String playerName) {
                Game g = new Game("testgame", 2);
                Player p1 = new Player("Alice", "testgame-Alice");
                g.addPlayer(p1);
                g.addPlayer(new Player("Bob", "testgame-Bob"));
                g.start();
                g.declareBankruptcy("testgame","Alice");
                return g;
            }
        });
        post(
                testContext,
                "/games/testgame/players/Alice/bankruptcy",
                "testgame-Alice",
                response -> assertOkResponse(response)
        );
    }

    @Test
    void declareBankruptcyUnauthorized(final VertxTestContext testContext) {
        service.setDelegate(new ServiceAdapter() {
            @Override
            public Object declareBankruptcy(String gameId, String playerName) {
                return new JsonObject();
            }
        });
        post(
                testContext,
                "/games/game-id/players/Alice/bankruptcy",
                null,
                response -> assertErrorResponse(response, 401)
        );
    }
}
