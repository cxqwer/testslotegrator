package dao.common;

import com.google.gson.Gson;
import io.restassured.response.ExtractableResponse;

public class Helper {

    public static <T> T getObjectFromResponse(ExtractableResponse response, Class<T> classOfT) {
        return new Gson().fromJson(response.body().asString(), classOfT);
    }
}
