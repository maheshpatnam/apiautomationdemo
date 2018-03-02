package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import testutilities.TestUtilities;
import static org.slf4j.LoggerFactory.getLogger;

public class Customer {
    private static final Logger LOGGER = getLogger(Customer.class);
    Response response;

    /**
     * creates customer
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     * @param email
     * @return
     */
    public Response createCustomer(String firstName,String lastName, String userName, String password,String email)
    {
        RestAssured.baseURI = TestUtilities.getProperty("baseurl");
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", firstName);
        requestParams.put("LastName", lastName);
        requestParams.put("UserName", userName);
        requestParams.put("Password", password);
        requestParams.put("Email",  email);
        request.body(requestParams.toJSONString());
        response = request.post("/customer/register");
        return response;

    }

}
