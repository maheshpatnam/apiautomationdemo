package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import testutilities.TestUtilities;

public class DemoExamples {
    Response response;
    @Test
    public void getAllUsersDetails(){
        RestAssured.baseURI = "https://reqres.in";
        response= RestAssured.given().when().get("/api/users?page=2");
        System.out.print(response.statusCode());
        System.out.print(response.getBody().asString());
    }

    @Test
    public void createCustomer()
    {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "mahesh");
        requestParams.put("job", "tester");
        request.body(requestParams.toJSONString());
        response = request.post("/api/users");
        System.out.print(response.statusCode());
        System.out.print(response.getBody().asString());

    }

    @Test
    public void deleteUser(){
        RestAssured.baseURI = "https://reqres.in";
        response= RestAssured.given().when().delete("/api/users?page=2");
        System.out.print(response.statusCode());
        System.out.print(response.getBody().asString());
    }
    @Test
    public void updateCustomer()
    {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "mahesh");
        requestParams.put("job", "qa engineer");
        request.body(requestParams.toJSONString());
        response = request.put("/api/users/522");
        System.out.print(response.statusCode());
        System.out.print(response.getBody().asString());
    }
}
