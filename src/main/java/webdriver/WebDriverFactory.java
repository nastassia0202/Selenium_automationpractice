package webdriver;

import static java.lang.String.format;

import core.ReadProperties;
import core.logging.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {

  public WebDriverFactory() {
  }

  public static final int SHORT_TIME_OUT_IN_SECONDS = 5;
  public static final int DEFAULT_TIME_OUT_IN_SECONDS = 20;
  public static final int MIDDLE_TIME_OUT_IN_SECONDS = 15;
  public static final int LONG_TIME_OUT_IN_SECONDS = 30;
  public static final int DEFAULT_TIME_OUT_FOR_PAGE_REFRESH = 31;

  private static String browserName = ReadProperties.getBrowserName();
  private static String BASE_URL = ReadProperties.getUrl();
  public static final String DOWNLOADS_PATH = format("%s%s", System.getProperty("user.dir"),
      "\\src\\test\\downloads");

  public static WebDriver getWebDriver() {
    RemoteWebDriver webDriver = null;
    DesiredCapabilities capabilities;
    switch (browserName.toLowerCase()) {
      case "chrome":
        capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-popup-blocking");
        HashMap<String, Object> chromePref = new HashMap<>();
        chromePref.put("profile.default_content_settings.popups", 0);
        chromePref.put("download.directory_upgrade", true);
        chromePref.put("download.default_directory", DOWNLOADS_PATH);
        options.setExperimentalOption("prefs", chromePref);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        try {
          webDriver = new RemoteWebDriver(new URL(BASE_URL), options);
          webDriver.manage().timeouts().implicitlyWait(SHORT_TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
          webDriver.manage().timeouts()
              .pageLoadTimeout(DEFAULT_TIME_OUT_FOR_PAGE_REFRESH, TimeUnit.SECONDS);
          webDriver.manage().timeouts()
              .setScriptTimeout(DEFAULT_TIME_OUT_FOR_PAGE_REFRESH, TimeUnit.SECONDS);
          webDriver.manage().window().maximize();
          Log.logInfoMessage(
              "Current browser is Chrome. Screen resolution is: " + webDriver.manage().window()
                  .getSize());
        } catch (MalformedURLException e) {
          Log.logInfoMessage("URL is not correct ");
        }
        break;
      case "firefox":
        capabilities = new DesiredCapabilities();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.dir", DOWNLOADS_PATH);
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
            "application/vnd.ms-excel.12");
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("pdfjs.disabled", true);
        profile.setPreference("browser.helperApps.neverAsk.openFile",
            "application/vnd.ms-excel.12");
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        try {
          webDriver = new RemoteWebDriver(new URL(BASE_URL), capabilities);
          webDriver.manage().window().maximize();
          Log.logInfoMessage(
              "Current browser is FireFox. Screen resolution is: " + webDriver.manage().window()
                  .getSize());
        } catch (MalformedURLException e) {
          Log.logInfoMessage("URL is not correct ");
        }
        break;
      default:
        throw new RuntimeException("No support ");
    }
    return webDriver;
  }

}
