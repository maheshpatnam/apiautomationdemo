package testcases;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.Weather;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Twitter Authentication service test cases
 *
 */
public class getWeatherDetailsTest {
    private static final Logger LOGGER = getLogger(getWeatherDetailsTest.class);
    Response response;


    @Test
    public  void test01_getWeatherDetails(){
        Weather weather = new Weather();
        response = weather.getWeatherDetails();
        LOGGER.info(response.getBody().asString());
        LOGGER.info("status code: "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
    }

}
