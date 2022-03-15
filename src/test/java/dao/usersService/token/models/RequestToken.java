package dao.usersService.token.models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestToken {

    @SerializedName(value = "grant_type")
    private String grantType;
    private String scope;
    private String username;
    private String password;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
