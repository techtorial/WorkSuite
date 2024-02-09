package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverHelper {

    private static WebDriver driver;
    private DriverHelper(){}
    //I make my constructor private because I do not want anyone to create an object
    //and manipulate my driver from this class.

    public static WebDriver getDriver(){
        if(driver==null|| ((RemoteWebDriver)driver).getSessionId()==null){
            String browser="chrome";

            switch (browser){

                case "chrome":
                    String hubURL = "http://35.174.174.118:4444";
                    ChromeOptions options = new ChromeOptions();
                    try {
                        driver = new RemoteWebDriver(new URL(hubURL),options);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    ChromeOptions options1 = new ChromeOptions();
                    options1.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options1);
                    break;
            }
            driver.manage().window().maximize();
            //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
}
