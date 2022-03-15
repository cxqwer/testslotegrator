package dao.usersService.token.executors;

import dao.usersService.token.builders.RequestTokenBuilder;
import dao.usersService.token.models.RequestToken;
import io.restassured.response.ExtractableResponse;

import java.util.Map;

import static dao.common.HttpClient.executePostRequest;
import static utill.properties.TestProperties.HOST;

public class TokenManagerExecutor {

    private final String SERVICE_URI = HOST + "/v2/oauth2/token";

    public ExtractableResponse createTokenRequest(Map<String, String> map) {
        RequestToken requestToken = new RequestTokenBuilder(map);
        return executePostRequest(SERVICE_URI, requestToken.toString());
    }
}
