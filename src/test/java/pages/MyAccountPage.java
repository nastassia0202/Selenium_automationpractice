package pages;

import org.openqa.selenium.By;

public class MyAccountPage extends BasePage {

  private final By welcomeMessage = By.className("info-account");
  private final By errorAuthMessage = By.xpath("//*[@class=\"alert alert-danger\"]//li");
  private final By username = By.xpath("//*[@title='View my customer account']//span");

  public String getVisibleUsername() {
    return driver.findElement(username).getText();
  }

  public String getWelcomeMessage() {
    if (driver.findElement(welcomeMessage).isDisplayed()) {
      return driver.findElement(welcomeMessage).getText();
    } else {
      return null;
    }
  }

  public String getErrorMessage() {
    if (driver.findElement(errorAuthMessage).isDisplayed()) {
      return driver.findElement(errorAuthMessage).getText();
    } else {
      return null;
    }
  }
}
