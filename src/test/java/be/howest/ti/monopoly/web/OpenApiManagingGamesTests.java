package be.howest.ti.monopoly.web;

import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.implementation.Game;
import be.howest.ti.monopoly.logic.implementation.Player;
import be.howest.ti.monopoly.web.views.GameView;
import io.vertx.core.json.JsonObject;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Test;

import java.util.*;


class OpenApiManagingGamesTests extends OpenApiTestsBase {

    @Test
    void getGames(final VertxTestContext testContext) {
        service.setDelegate(new ServiceAdapter() {
            @Override
            public Object getGamesLessDetailed() {
                return Collections.emptyList();
            }
        });
        get(
                testContext,
                "/games",
                null,
                response -> assertOkResponse(response)
        );
    }

//TODO: Fix this test when getgames with params works

    @Test
    void getGamesWithAllParams(final VertxTestContext testContext) {
        service.setDelegate(new ServiceAdapter() {
            @Override
            public Object getGamesLessDetailed() {
                return Collections.emptyList();
            }
        });
        get(
                testContext,
                "/games?started=true&prefix=azerty&numberOfPlayers=3",
                null,
                response -> assertOkResponse(response)
        );
    }

    @Test
    void getGamesWithInvalidStartedType(final VertxTestContext testContext) {
        get(
                testContext,
                "/games?started=not-a-boolean",
                null,
                response -> assertErrorResponse(response, 400)
        );
    }

    @Test
    void getGamesWithInvalidNumberType(final VertxTestContext testContext) {
        get(
                testContext,
                "/games?numberOfPlayers=not-a-number",
                null,
                response -> assertErrorResponse(response, 400)
        );
    }

    @Test
    void createGameWithEmptyBody(final VertxTestContext testContext) {
        service.setDelegate(new ServiceAdapter() {
            @Override
            public GameView createGame(String prefix, int numberOfPlayers) {
                return null;
            }
        });
        post(
                testContext,
                "/games",
                null,
                new JsonObject(),
                response -> assertErrorResponse(response, 409)
        );
    }

    @Test
    void createGame(final VertxTestContext testContext) {
        service.setDelegate(new ServiceAdapter(){
            @Override
            public GameView createGame(String prefix, int numberOfPrefix) {
                return null;
            }
        });

        post(
                testContext,
                "/games",
                null,
                new JsonObject()
                        .put("prefix", "Prefix123")
                        .put("numberOfPlayers", 10),
                response -> assertOkResponse(response)
        );
    }

    @Test
    void createGamePrefixTooLong(final VertxTestContext testContext) {
        post(
                testContext,
                "/games",
                null,
                new JsonObject()
                        .put("prefix", "aaaaaaaaaaa"),
                response -> assertErrorResponse(response, 400)
        );
    }

    @Test
    void createGameInvalidSymbol(final VertxTestContext testContext) {
        post(
                testContext,
                "/games",
                null,
                new JsonObject()
                        .put("prefix", "a-a"), // spaces, ...
                response -> assertErrorResponse(response, 400)
        );
    }

    @Test
    void createGameTooManyPlayers(final VertxTestContext testContext) {
        post(
                testContext,
                "/games",
                null,
                new JsonObject()
                        .put("numberOfPlayers", 11),
                response -> assertErrorResponse(response, 400)
        );
    }

    @Test
    void createGameTooFewPlayers(final VertxTestContext testContext) {
        post(
                testContext,
                "/games",
                null,
                new JsonObject()
                        .put("numberOfPlayers", 1),
                response -> assertErrorResponse(response, 400)
        );
    }

    @Test
    void createGamePlayersNotANumber(final VertxTestContext testContext) {
        post(
                testContext,
                "/games",
                null,
                new JsonObject()
                        .put("numberOfPlayers", "two"),
                response -> assertErrorResponse(response, 400)
        );
    }

    @Test
    void createGameWithoutBody(final VertxTestContext testContext) {
        post(
                testContext,
                "/games",
                null,
                response -> assertErrorResponse(response, 400)
        );
    }

    @Test
    void joinGame(final VertxTestContext testContext) {
        service.setDelegate(new ServiceAdapter() {
            @Override
            public Object joinGame(String gameId, String playerToken, Player player) {
                return Collections.emptyList();
            }
        });
        post(
                testContext,
                "/games/game-id/players",
                null,
                new JsonObject()
                        .put("playerName", "Alice"),
                this::assertOkResponse
        );
    }

    @Test
    void joinGamePlayerNameTooLong(final VertxTestContext testContext) {
        post(
                testContext,
                "/games/game-id/players",
                null,
                new JsonObject()
                        .put("playerName", "aaaaaaaaaaaaaaaa"),
                response -> assertErrorResponse(response, 400)
        );
    }

    @Test
    void joinGamePlayerNameTooShort(final VertxTestContext testContext) {
        post(
                testContext,
                "/games/game-id/players",
                null,
                new JsonObject()
                        .put("playerName", ""),
                response -> assertErrorResponse(response, 400)
        );
    }

    @Test
    void joinGamePlayerNameInvalidPatterns(final VertxTestContext testContext) {
        post(
                testContext,
                "/games/game-id/players",
                null,
                new JsonObject()
                        .put("playerName", "a-a"), // spaces, ...
                response -> assertErrorResponse(response, 400)
        );
    }

    @Test
    void joinGameWithoutBody(final VertxTestContext testContext) {
        post(
                testContext,
                "/games/game-id/players",
                null,
                response -> assertErrorResponse(response, 400)
        );
    }

    @Test
    void joinGameWithEmptyBody(final VertxTestContext testContext) {
        post(
                testContext,
                "/games/game-id/players",
                null,
                new JsonObject(),
                response -> assertErrorResponse(response, 400)
        );
    }

    @Test
    void clearGameList(final VertxTestContext testContext) {
        service.setDelegate(new ServiceAdapter() {
            @Override
            public Object clearGameList() {
                return null;
            }
        });
        delete(
                testContext,
                "/games",
                "some-token",
                response -> assertOkResponse(response)
        );
    }

    @Test
    void clearGameListUnauthorized(final VertxTestContext testContext) {
        delete(
                testContext,
                "/games",
                null,
                response -> assertErrorResponse(response, 401)
        );
    }

}
