package dao.usersService.token.builders;

import dao.usersService.token.models.RequestToken;

import java.util.HashMap;
import java.util.Map;

public class RequestTokenBuilder extends RequestToken {

    public RequestTokenBuilder(Map<String, String> map){
        HashMap<String, String> hashMap = new HashMap(map);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            switch (key) {
                case "grant_type":
                    setGrantType(value);
                    break;
                case "scope":
                    setScope(value);
                    break;
                case "username":
                    setUsername(value);
                    break;
                case "password":
                    setPassword(value);
                    break;
            }
        }
    }
}
