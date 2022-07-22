package core;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class Driver {
    private static WebDriver driver;
    private static DriverManagerType driverManagerType = null;

    private Driver(){
    }

    public static WebDriver getDriverInstance() {
        if (driver == null) {
            driverManagerType = DriverManagerType.CHROME;
            WebDriverManager.getInstance(driverManagerType).setup();

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-gpu");
            //chromeOptions.addArguments("--window-size=1920,1200");
            chromeOptions.addArguments("--ignore-certificate-errors");
            chromeOptions.addArguments("--silent");
            chromeOptions.addArguments("--start-maximized");

            driver = new ChromeDriver(chromeOptions);
        }
        return driver;
    }
}
