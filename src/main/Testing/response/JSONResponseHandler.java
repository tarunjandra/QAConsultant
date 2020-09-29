package response;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONResponseHandler {

    private static Response response = null;

    public JSONResponseHandler(Response response) {
        this.response = response;
    }

    public List<Object> getResponseAttributes(String path) {
        JsonPath jsonPath = response.jsonPath();
        List<Object> arrayAttributes = null;

        Map<Object, Object> map = jsonPath.getMap("$");

        for (Map.Entry<Object, Object> entries : map.entrySet()) {
            if (entries.getValue() instanceof ArrayList) {
                arrayAttributes = jsonPath.getList(path);
            }
        }
        return arrayAttributes;
    }
}
