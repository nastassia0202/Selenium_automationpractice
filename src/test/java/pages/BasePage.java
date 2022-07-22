package pages;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

  protected WebDriver driver;
  private By logoutBtn = By.className("logout");

  public BasePage() {
    this.driver = Driver.getDriverInstance();
  }

  public LoginPage logout() {
    driver.findElement(logoutBtn).click();
    return new LoginPage();
  }
}
