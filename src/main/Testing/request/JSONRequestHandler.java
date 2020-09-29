package request;

import Data.APIUserProfile;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONRequestHandler {

    private static RequestSpecification request = null;

    public JSONRequestHandler(RequestSpecification request) {
        this.request = request;
    }

    public void loginRequest(String user) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", APIUserProfile.getUser().get(user));
        jsonObject.addProperty("password", APIUserProfile.getUser().get("password"));
        request.body(jsonObject.toString());
    }

    public void setHeaderValues() {
        request.header("x-cf-source-id", "coding-challenge");
        request.header("x-cf-corr-id", "230ea84a-7199-41c9-bf38-fff27e35970d");
        request.header("Content-Type", "application/json");
    }

    public Response sendLoginRequest() {
        Response response = request.post("/login");
        return response;
    }

}
