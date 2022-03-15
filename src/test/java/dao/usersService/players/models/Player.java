package dao.usersService.players.models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private Long id;
    @SerializedName(value = "country_id")
    private Long countryId;
    @SerializedName(value = "password_change")
    private String passwordChange;
    @SerializedName(value = "phone_number")
    private String phoneNumber;
    @SerializedName(value = "timezone_id")
    private String timezoneId;
    @SerializedName(value = "password_repeat")
    private String passwordRepeat;
    @SerializedName(value = "bonuses_allowed")
    private Boolean bonusesAllowed;
    @SerializedName(value = "currency_code")
    private String currencyCode;
    @SerializedName(value = "is_verified")
    private Boolean isVerified;
    private String username;
    private String gender;
    private String birthdate;
    private String surname;
    private String email;
    private String name;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
