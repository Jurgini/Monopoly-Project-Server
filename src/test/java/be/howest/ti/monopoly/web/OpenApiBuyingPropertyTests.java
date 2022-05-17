package be.howest.ti.monopoly.web;

import be.howest.ti.monopoly.logic.ServiceAdapter;
import io.vertx.core.json.JsonObject;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Test;

import java.util.Collections;


class OpenApiBuyingPropertyTests extends OpenApiTestsBase {

    @Test
    void buyProperty(final VertxTestContext testContext) {
        service.setDelegate(new ServiceAdapter() {
            @Override
            public Object buyProperty(String gameId, String playerName, String propertyName) {
                return new JsonObject(){};
            }
        });
        post(
                testContext,
                "/games/game-id/players/Alice/properties/some-property",
                "some-token",
                response -> assertErrorResponse(response, 409)
        );
    }

    @Test
    void buyPropertyUnauthorized(final VertxTestContext testContext) {
        post(
                testContext,
                "/games/game-id/players/Alice/properties/some-property",
                null,
                response -> assertErrorResponse(response, 401)
        );
    }

    @Test
    void dontBuyProperty(final VertxTestContext testContext) {
        service.setDelegate(new ServiceAdapter() {
            @Override
            public Object buyProperty(String gameId, String playerName, String propertyName) {
                return new JsonObject(){};
            }
        });
        delete(
                testContext,
                "/games/game-id/players/Alice/properties/some-property",
                "some-token",
                response -> assertNotYetImplemented(response, "dontBuyProperty")
        );
    }

    @Test
    void dontBuyPropertyUnauthorized(final VertxTestContext testContext) {
        delete(
                testContext,
                "/games/game-id/players/Alice/properties/some-property",
                null,
                response -> assertErrorResponse(response, 401)
        );
    }
}
