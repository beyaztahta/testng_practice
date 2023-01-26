package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
    Driver daki temel mantik extends yontemiyle degil yani testbase classına extends etmek yerine Driver classından
    static methodlar kullanarak driver olustururuz.
    1-İlk olarak public static WebDriver getDriver()methodu olusturmak;bu method bize bir Driver getirecek.
    2-Driver ı kapatacagımız zaman public static void closeDriver() methodu olusturmak.İstedigimiz zaman bu methodla driveri kapatabiliriz.
     */

    static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {// EGER DRIVeR'A DEGER ATANMAMIS ISE DEGER ATA, EGER DEGER ATANMIS ISE DRIVER'I AYNI SAYFADA RETURN ET
            switch (ConfigReader.getProperties("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

            }

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        return driver;
    }


    public static void closeDriver() {
        if (driver != null) {//Driver a deger atanmıssa kapat.
            driver.quit();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {//Driver a deger atanmıssa kapat.
            driver.close();
            driver = null;
        }
    }
}