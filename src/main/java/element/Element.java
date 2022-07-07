package element;

import static core.logging.Log.logInfoMessage;
import static webdriver.WebDriverFactory.DEFAULT_TIME_OUT_IN_SECONDS;

import core.logging.Log;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.WebDriverSingleton;

public class Element {

  private By by;
  private Strategy strategy;
  private WebDriver webDriver = WebDriverSingleton.getInstance().getDriver();
  private static WebDriverWait wait;

  private Element(Strategy strategy, By by) {
    this.by = by;
    this.strategy = strategy;
    wait = new WebDriverWait(webDriver, 10);
  }

  public static Element getById(String value) {
    return new Element(Strategy.ID, By.id(value));
  }

  public static Element getByClassName(String value) {
    return new Element(Strategy.CLASS_NAME, By.className(value));
  }

  public static Element getByXpath(String value) {
    return new Element(Strategy.XPATH, By.xpath(value));
  }

  public static Element getByCss(String value) {
    return new Element(Strategy.CSS, By.cssSelector(value));
  }


  /* Actions */

  public void click() {
    logInfoMessage("Native click element located by " + by.toString());
    getWebElement().click();
  }

  public void type(String value) {
    logInfoMessage("Type [%s] to element located by " + by.toString(), value);
    getWebElement().sendKeys(value);
  }

  public void clearAndType(String value) {
    logInfoMessage("Clear element located by " + by.toString());
    getWebElement().clear();
    type(value);
  }

  /* Getters */

  public WebElement getWebElement() {
    logInfoMessage("Search fo element located " + by.toString());
    return waitForPresence();
  }

  public List<WebElement> getAllWebElements() {
    logInfoMessage("Search fo element all located by " + by.toString());
    return webDriver.findElements(by);
  }

  public String getText() {
    logInfoMessage("Getting text from element located by " + by.toString());
    return getWebElement().getText();
  }

  public boolean isDisplayed() {
    logInfoMessage("Check visibility of element located by " + by.toString());
    boolean isDisplayed;
    try {
      isDisplayed = waitForVisibility() != null;
    } catch (TimeoutException e) {
      isDisplayed = false;
    }
    logInfoMessage("Element visibility: " + isDisplayed);
    return isDisplayed;
  }

  public String getValue() {
    logInfoMessage("Getting 'value' from element located by " + by.toString());
    return getWebElement().getAttribute("value");
  }

  /*Waits*/

  public WebElement waitForPresence() {
    return waitForPresence(DEFAULT_TIME_OUT_IN_SECONDS);
  }

  public WebElement waitForPresence(int timeout) {
    Log.logInfoMessage("Wait for presence of element located by " + by.toString());
    return new WebDriverWait(webDriver, DEFAULT_TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.presenceOfElementLocated(by));
  }

  public WebElement waitForVisibility() {
    logInfoMessage("Wait element will be visibility");
    return new WebDriverWait(webDriver, DEFAULT_TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public boolean waitForInvisibility(WebElement element) {
    return wait.until(ExpectedConditions.invisibilityOf(element));
  }

  public void waitForClickable(By locator) {
    Wait<WebDriver> wait = new FluentWait<>(webDriver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofSeconds(5))
        .ignoring(NoSuchElementException.class);
    wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  public static WebElement waitForVisibility(By by) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public enum Strategy {
    ID,
    CLASS_NAME,
    XPATH,
    CSS
  }

}
