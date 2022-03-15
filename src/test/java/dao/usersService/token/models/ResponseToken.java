package dao.usersService.token.models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseToken {

    @SerializedName(value = "token_type")
    private String tokenType;

    @SerializedName(value = "expires_in")
    private Long expiresIn;

    @SerializedName(value = "access_token")
    private String accessToken;

    @SerializedName(value = "refresh_token")
    private String refreshToken;


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
