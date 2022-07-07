package webdriver;

import core.logging.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {

  public static final File TESTNG_DIRECTORY = new File("target/surefire-reports");
  private List<File> screenshotList = new ArrayList<>();

  private WebDriver wrappedDriver;

  private static ThreadLocal<WebDriverSingleton> instance = new ThreadLocal<>();

  private WebDriverSingleton() {
    wrappedDriver = WebDriverFactory.getWebDriver();
  }

  public static synchronized WebDriverSingleton getInstance() {
    if (instance.get() == null) {
      instance.set(new WebDriverSingleton());
    }
    return instance.get();
  }

  public WebDriver getDriver() {
    return wrappedDriver;
  }

  public void closeDriver() {
    Log.logInfoMessage("Stop browser");
    try {
      wrappedDriver.quit();
    } finally {
      instance.remove();
    }
  }

  public void takeScreenshot() {
    try {
      if (!TESTNG_DIRECTORY.exists()) {
        TESTNG_DIRECTORY.mkdirs();
      }
      File screenshot = File.createTempFile("screenshot", ".png", TESTNG_DIRECTORY);
      try (FileOutputStream stream = new FileOutputStream(screenshot)) {
        stream.write(((TakesScreenshot) wrappedDriver).getScreenshotAs(OutputType.BYTES));
      }
      screenshotList.add(screenshot);
    } catch (Throwable e) {
      Log.logInfoMessage("Unable to save screenshot", e);
    }
  }

}
