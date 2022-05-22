package be.howest.ti.monopoly.web;

import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.implementation.Game;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Test;


class OpenApiInteractionWithOtherPlayerTests extends OpenApiTestsBase {

    @Test
    void collectDebt(final VertxTestContext testContext) {
        service.setDelegate(new ServiceAdapter() {
            @Override
            public Game collectDebt(String gameId, String playerName, String propertyName, String debtorName) {
                return null;
            }
        });
        delete(
                testContext,
                "/games/game-id/players/Alice/properties/some-property/visitors/Bob/rent",
                "some-token",
                response -> assertOkResponse(response)
        );
    }

    @Test
    void collectDebtUnauthorized(final VertxTestContext testContext) {
        delete(
                testContext,
                "/games/game-id/players/Alice/properties/some-property/visitors/Bob/rent",
                null,
                response -> assertErrorResponse(response, 401)
        );
    }


}
