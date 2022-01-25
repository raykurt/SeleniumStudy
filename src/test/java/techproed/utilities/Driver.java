package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    What is Driver ? = Create and initialize the driver instance
    Why ? => Reusability. Avaid duplication
    Faster development
     */
    private static WebDriver driver;
    private Driver(){
    }
    //Create getDriver method to Create and initialize the driver instance
    public static WebDriver getDriver(){

        if (driver==null){
//           check the browser type
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver= new SafariDriver();
                    break;
            }

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    //    closeDriver is used for closing teh driver
    public static void closeDriver(){
        if (driver!=null){//if driver id POINTING SOMEWHHERE such as chromedriver
            driver.quit();
            driver=null;
        }
    }
}
