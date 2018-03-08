package weather;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class WeatherDetails {
    @Test
    public void getWeatherDetails(){
        RestAssured.baseURI ="http://samples.openweathermap.org";
      Response response= RestAssured.given().when().get("/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
      System.out.print(response.statusCode());
        System.out.print(response.getBody().asString());
    }
}
