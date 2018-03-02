package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import testutilities.TestUtilities;
import static org.slf4j.LoggerFactory.getLogger;

public class Weather {
    private static final Logger LOGGER = getLogger(Weather.class);
    Response response;

    public Response getWeatherDetails(){
        RestAssured.baseURI = TestUtilities.getProperty("baseurl");
        response = RestAssured.given().header("Content-Type","application/json").when().get("/utilities/weather/city/Hyderabad");
        return  response;
    }

}
