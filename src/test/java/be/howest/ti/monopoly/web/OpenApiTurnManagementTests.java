package be.howest.ti.monopoly.web;

import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.implementation.Game;
import be.howest.ti.monopoly.web.views.GameView;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Test;


class OpenApiTurnManagementTests extends OpenApiTestsBase {

    @Test
    void rollDice(final VertxTestContext testContext) {
        service.setDelegate(new ServiceAdapter() {
            @Override
            public GameView rollDice(String playerName, String gameId) {
                return new GameView(new Game("rollDice-test", 2));
            }
        });
        post(
                testContext,
                "/games/game-id/players/Alice/dice",
                "some-token",
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
        post(
                testContext,
                "/games/game-id/players/Alice/bankruptcy",
                "some-token",
                response -> assertNotYetImplemented(response, "declareBankruptcy")
        );
    }

    @Test
    void declareBankruptcyUnauthorized(final VertxTestContext testContext) {
        post(
                testContext,
                "/games/game-id/players/Alice/bankruptcy",
                null,
                response -> assertErrorResponse(response, 401)
        );
    }
}
