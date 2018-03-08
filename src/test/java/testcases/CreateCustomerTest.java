package testcases;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.Customer;
import testutilities.TestUtilities;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * create customer service testcases
 *
 */
public class CreateCustomerTest {
    private static final Logger LOGGER = getLogger(CreateCustomerTest.class);
    Response response;


    @Test
    public  void test01_createCustomer(){
        Customer customer = new Customer();
        String emaild = TestUtilities.getUserName().concat("@gmail.com");
        response = customer.createCustomer(TestUtilities.getFirstName(),TestUtilities.getLasttName(),TestUtilities.getUserName(),TestUtilities.getUserpassword(),emaild);
        LOGGER.info(response.getBody().asString());
        LOGGER.info("status code: "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),201);
       Assert.assertTrue(response.getBody().asString().contains("OPERATION_SUCCESS"));
    }

}
