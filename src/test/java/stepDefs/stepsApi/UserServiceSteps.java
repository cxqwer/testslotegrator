package stepDefs.stepsApi;

import com.google.gson.Gson;
import dao.usersService.token.executors.TokenManagerExecutor;
import dao.usersService.token.models.ResponseToken;
import io.cucumber.java.en.When;
import io.restassured.response.ExtractableResponse;

import java.util.Map;

import static dao.common.HttpClient.getHttpCode;
import static junit.framework.TestCase.assertEquals;
import static runner.RunnerTest.CACHE;

public class UserServiceSteps {

    private final String CACHE_OBJECT_KEY = "token";
    TokenManagerExecutor tokenManagerExecutor = new TokenManagerExecutor();

    @When("POST crate token")
    public void postCrateToken(Map<String, String> map) {
        int httpCode = getHttpCode(map);
        ExtractableResponse response = tokenManagerExecutor.createTokenRequest(map);
        assertEquals(httpCode, response.statusCode());
        if (httpCode == 200){
            ResponseToken token = new Gson().fromJson(response.body().asString(), ResponseToken.class);
            CACHE.addToCache(CACHE_OBJECT_KEY, token);
        }
    }
}
