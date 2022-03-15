package dao.usersService.players.executors;

import dao.usersService.players.models.Player;
import io.restassured.response.ExtractableResponse;
import lombok.AllArgsConstructor;

import static dao.common.HttpClient.executeGetRequest;
import static dao.common.HttpClient.executePostRequest;
import static utill.properties.TestProperties.HOST;

@AllArgsConstructor
public class PlayersExecutor {
    private String token;
    private final String SERVICE_URI = HOST + "/v2/players";

    public ExtractableResponse getPlayerRequest(Long id) {
        return executeGetRequest(String.format("%s/%s", SERVICE_URI , id), token);
    }

    public ExtractableResponse postPlayerRequest(Player player) {
        return executePostRequest(SERVICE_URI, player.toString());
    }
}
