package tests;

import Data.Urls;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import request.JSONRequestHandler;
import response.JSONResponseHandler;

import java.util.List;

public class APIScenario {

    private static Response response = null;

    @Test(priority = 1)
    public void loginRequest() {
        RestAssured.baseURI = Urls.apiEndpoint;
        RequestSpecification request = RestAssured.given();
        JSONRequestHandler jsonRequestHandler = new JSONRequestHandler(request);
        jsonRequestHandler.loginRequest("validUser");
        jsonRequestHandler.setHeaderValues();
        response = jsonRequestHandler.sendLoginRequest();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void validateResponse() {
        JSONResponseHandler jsonResponseHandler = new JSONResponseHandler(response);
        List<Object> responseAttributes = jsonResponseHandler.getResponseAttributes("loansInReview.productType");
        Assert.assertEquals(responseAttributes.get(0), "PERSONAL_LOAN");
    }

    @Test(priority = 3)
    public void validateLoginCredentials(){
        RequestSpecification request = RestAssured.given();
        JSONRequestHandler jsonRequestHandler = new JSONRequestHandler(request);
        jsonRequestHandler.loginRequest("invalidUser");
        jsonRequestHandler.setHeaderValues();
        response = jsonRequestHandler.sendLoginRequest();
        Assert.assertEquals(response.getStatusCode(), 401);
    }

}
