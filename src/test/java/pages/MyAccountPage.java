package pages;

import element.Element;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MyAccountPage extends BasePage{

  private final By welcomeMessageLocator = By.className("info-account");
  private final Element welcomeMessage = Element.getByClassName("info-account");

  public String getWelcomeMessage() {
    Assert.assertTrue(Element.waitForVisibility(welcomeMessageLocator).isDisplayed());
    return welcomeMessage.getText();
  }

}
