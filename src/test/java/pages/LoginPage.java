package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

  private final By txtEmailAddress = By.id("email");
  private final By txtPassword = By.id("passwd");
  private final By btnSignIn = By.id("SubmitLogin");
  private final By btnForgotPassword = By.xpath(
      "//*[contains(text(), 'Forgot your password')]");

  public LoginPage sendEmailAddress(String value) {
    driver.findElement(txtEmailAddress).sendKeys(value);
    return this;
  }

  public LoginPage sendPassword(String value) {
    driver.findElement(txtPassword).sendKeys(value);
    return this;
  }

  public void clickSignInButton() {
    driver.findElement(btnSignIn).click();
  }
}
