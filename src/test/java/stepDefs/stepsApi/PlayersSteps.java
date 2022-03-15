package stepDefs.stepsApi;

import com.google.gson.Gson;
import dao.usersService.players.builders.PlayerBuilder;
import dao.usersService.players.executors.PlayersExecutor;
import dao.usersService.players.models.Player;
import dao.usersService.token.models.ResponseToken;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ExtractableResponse;

import java.util.HashMap;
import java.util.Map;

import static dao.common.HttpClient.getHttpCode;
import static junit.framework.TestCase.assertEquals;
import static runner.RunnerTest.CACHE;

public class PlayersSteps {

    private final String CACHE_OBJECT_KEY = "player";

    @When("POST crate player")
    public void postCratePlayer(Map<String, String> map) {
        int httpCode = getHttpCode(map);
        PlayersExecutor playersExecutor = new PlayersExecutor(CACHE.getObjectFromCacheByKey("user_access_token").toString());
        ExtractableResponse response = playersExecutor.postPlayerRequest(new PlayerBuilder(map));
        assertEquals(httpCode, response.statusCode());
        if (httpCode == 200) {
            ResponseToken token = new Gson().fromJson(response.body().asString(), ResponseToken.class);
            CACHE.addToCache(CACHE_OBJECT_KEY, token);
        }
    }

    @Then("check player")
    public void checkPlayer(Map<String, String> map) {
        Player player = (Player) CACHE.getObjectFromCacheByKey(CACHE_OBJECT_KEY);
        HashMap<String, String> hashMap = new HashMap(map);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            switch (key) {
                case "username":
                    assertEquals(player.getUsername(), value);
                    break;
                case "email":
                    assertEquals(player.getEmail(), value);
                    break;
                case "name":
                    assertEquals(player.getName(), value);
                    break;
                case "surname":
                    assertEquals(player.getSurname(), value);
                    break;
                case "currency_code":
                    assertEquals(player.getCurrencyCode(), value);
                    break;
            }
        }
    }

    @And("GET player with id: {string}")
    public void getPlayerWithId(String id, Map<String, String> map) {
        int httpCode = getHttpCode(map);
        Long playerId = (id.equals("auto")) ?
                ((Player) CACHE.getObjectFromCacheByKey(CACHE_OBJECT_KEY)).getId() : Long.parseLong(id);
        PlayersExecutor playersExecutor = new PlayersExecutor(CACHE.getObjectFromCacheByKey("user_access_token").toString());
        ExtractableResponse response = playersExecutor.getPlayerRequest(playerId);
        assertEquals(httpCode, response.statusCode());
        if (httpCode == 200) {
            ResponseToken token = new Gson().fromJson(response.body().asString(), ResponseToken.class);
            CACHE.addToCache(CACHE_OBJECT_KEY, token);
        }
    }
}
