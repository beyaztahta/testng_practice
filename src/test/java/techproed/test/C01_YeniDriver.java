package test;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_YeniDriver {

    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.properties.getProperty("amazonUrl"));
        Driver.getDriver().get("http://techproeducation.com");
        Driver.getDriver().get("http://facebook.com");
        Driver.quitDriver();
    }
}
