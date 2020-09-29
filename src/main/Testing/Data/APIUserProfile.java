package Data;

import java.util.HashMap;
import java.util.List;

public class APIUserProfile {

    private static final String VALIDUSERNAME = "coding.challenge.login@upgrade.com";
    private static final String INVALIDUSERNAME = "codingg.challenge.login@upgrade.com";
    private static final String PASSWORD = "On$3XcgsW#9q";

    public static HashMap<String, String> getUser() {
        HashMap<String, String> user = new HashMap<>();
        user.put("validUser", VALIDUSERNAME);
        user.put("invalidUser", INVALIDUSERNAME);
        user.put("password", PASSWORD);
        return user;
    }

}
