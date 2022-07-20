package pages;

import element.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webdriver.WebDriverSingleton;

public class BasePage {

  private WebDriverSingleton driver;
  private final Element addToCartSuccessPopup = Element.getByClassName("icon-ok");
  private final Element logOutLink = Element.getByClassName("logout");
  private final Element accountLink = Element.getByClassName("account");
  private final Element searchInput = Element.getById("search_query_top");
  private final Element searchButton = Element.getByXpath("//*[@name='submit_search']");
  private final Element proceedToCheckoutButton = Element.getByXpath(
      "//*[@title='Proceed to checkout']");


  public void searchItem(String string) {
    searchInput.type(string);
    searchButton.click();
  }

  public String getValueBySearchField() {
    return searchInput.getValue();
  }

  public void logoutLinkClick() {
    logOutLink.click();
  }

  public void checkoutButtonClick() {
    new Actions((WebDriver) driver)
        .moveToElement((WebElement)proceedToCheckoutButton)
        .click()
        .build();
  }

  public boolean accountLinkIsDisplayed() {
    return accountLink.isDisplayed();
  }
}