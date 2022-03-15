package dao.usersService.players.builders;

import dao.usersService.players.models.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerBuilder extends Player {

    public PlayerBuilder(Map<String, String> map){
        HashMap<String, String> hashMap = new HashMap(map);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            switch (key) {
                case "username":
                    setUsername(value);
                    break;
                case "password_change":
                    setPasswordChange(value);
                    break;
                case "password_repeat":
                    setPasswordRepeat(value);
                    break;
                case "email":
                    setEmail(value);
                    break;
                case "name":
                    setName(value);
                    break;
                case "surname":
                    setSurname(value);
                    break;
                case "currency_code":
                    setCurrencyCode(value);
                    break;
            }
        }
    }
}
