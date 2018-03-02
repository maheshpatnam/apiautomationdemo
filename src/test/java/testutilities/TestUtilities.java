package testutilities;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.FileInputStream;
import java.util.Properties;

public class TestUtilities {
    private static Properties defaultProps = new Properties();
    static {
        try {
        String currentDir = System.getProperty("user.dir");
        String filepath=currentDir+"/src/test/java/config/config.properties";
        FileInputStream in = new FileInputStream(filepath);
        defaultProps.load(in);
        in.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    /**
     * gets key value from properties file
     * @param key
     * @return values for specific key
     */
    public static String getProperty(String key) {
        return defaultProps.getProperty(key);
    }

    /**
     * Sleeps driver for specific time
     * @param milliSeconds
     */
    public static void sleep(int milliSeconds){
    try {
        Thread.sleep(milliSeconds);
    }
    catch (InterruptedException ie){}
}

    /**
     * returns response tag value by name
     * @param response
     * @param name
     * @return Returns response tag value by name
     */
    public static String getResponseValueByName(Response response, String name){
        JsonPath jsonPathEvaluator = response.jsonPath();
        String values[]= new String[]{jsonPathEvaluator.get(name)};
        return values[0];
    }

    /**
     * generates random first name
     * @return random first name
     */
    public static String getFirstName(){
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    /**
     * generates random last name
     * @return random last name
     */
    public static String getLasttName(){
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    /**
     * generates random user name
     * @return random user name
     */
    public static String getUserName(){
        Faker faker = new Faker();
        return faker.name().username();
    }


    /**
     * generates random user password
     * @return random user password
     */
    public static String getUserpassword(){
        Faker faker = new Faker();
        return faker.name().fullName();
    }

}
