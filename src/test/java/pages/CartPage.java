package pages;

import element.Element;
import org.openqa.selenium.By;
import webdriver.WebDriverSingleton;

public class CartPage extends BasePage {

  private final Element deleteItemButton = Element.getByClassName("icon-trash");
  private final Element cartIsEmptyAlert = Element.getByXpath(
      "//*[.='Your shopping cart is empty.']");

  public CartPage() {
    WebDriverSingleton.getInstance().getDriver()
        .get("http://automationpractice.com/index.php?controller=order");
  }

  public void deleteItem() {
    deleteItemButton.click();
    alertIsDisplayed();
  }

  public boolean itemIsDisplayed() {
    return deleteItemButton.isDisplayed();
  }

  public boolean alertIsDisplayed() {
    return cartIsEmptyAlert.isDisplayed();
  }

}
