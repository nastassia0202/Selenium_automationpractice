package untils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//public class Waits {
//
//  private WebDriver driver;
//  private WebDriverWait wait;
//
//  public Waits(WebDriver driver) {
//    this.driver = driver;
//    wait = new WebDriverWait(driver, 10);
//  }
//
//  public boolean waitForVisibility(WebElement element) {
//    return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
//  }
//
//  public boolean waitForInvisibility(WebElement element) {
//    return wait.until(ExpectedConditions.invisibilityOf(element));
//  }
//
//  public void waitForClickable(By locator) {
//    Wait<WebDriver> wait = new FluentWait<>(driver)
//        .withTimeout(Duration.ofSeconds(30))
//        .pollingEvery(Duration.ofSeconds(5))
//        .ignoring(NoSuchElementException.class);
//    wait.until(ExpectedConditions.elementToBeClickable(locator));
//  }
//
//  public WebElement waitForVisibility(By by) {
//    return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//  }
//}
