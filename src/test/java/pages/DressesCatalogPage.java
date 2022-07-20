package pages;

import element.Element;
import model.ItemDress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import untils.Waits;
import webdriver.WebDriverSingleton;

public class DressesCatalogPage extends BasePage{

  Actions actions = new Actions(WebDriverSingleton.getInstance().getDriver());
  private final Element colorWhiteOption = Element.getById("color_8");
  private final Element colorOrangeOption = Element.getById("color_13");
  private final Element colorGreenOption = Element.getById("color_15");
  private final Element colorBlackOption = Element.getById("color_11");
  private final Element colorBlueOption = Element.getById("color_14");
  private final Element colorYellowOption = Element.getById("color_16");
  private final Element colorBeigeOption = Element.getById("color_7");
  private final Element colorPinkOption = Element.getById("color_24");

  private final Element sizeSOption = Element.getByXpath("//*[@class=\"attribute_list\"]//option[@title=\"S\"]");
  private final Element sizeMOption = Element.getByXpath("//*[@class=\"attribute_list\"]//option[@title=\"M\"]");
  private final Element sizeLOption = Element.getByXpath("//*[@class=\"attribute_list\"]//option[@title=\"L\"]");

  private final Element itemImage = Element.getByXpath("//*[@itemprop='image']");
  private final Element itemMoreButton = Element.getByXpath("//*[.='More']");
  private final Element itemForm = Element.getByXpath("//h1[@itemprop='name']");
  private final Element addToCardSuccessPopup = Element.getByClassName("icon-ok");
  private final Element sizeOptionDropdown = Element.getById("group_1");


  public String getValueBySizeOption(){
    return sizeOptionDropdown.getText();
  }

  public void checkDressSize(String size){
    switch (size) {
      case "S":
        actions.moveToElement((WebElement) sizeSOption).click();
        break;
      case "M":
        actions.moveToElement((WebElement) sizeMOption).click();
        break;
      case "L":
        actions.moveToElement((WebElement) sizeLOption).click();
        break;
      default:
        System.out.println("No dress size found!");
        break;
    }
  }

  public void checkDressColor(String color){
    switch (color) {
      case "White":
        actions.moveToElement((WebElement) colorWhiteOption).click();
        break;
      case "Orange":
        actions.moveToElement((WebElement) colorOrangeOption).click();
        break;
      case "Green":
        actions.moveToElement((WebElement) colorGreenOption).click();
        break;
      case "Black":
        actions.moveToElement((WebElement) colorBlackOption).click();
        break;
      case "Blue":
        actions.moveToElement((WebElement) colorBlueOption).click();
        break;
      case "Yellow":
        actions.moveToElement((WebElement) colorYellowOption).click();
        break;
      case "Beige":
        actions.moveToElement((WebElement) colorBeigeOption).click();
      case "Pink":
        actions.moveToElement((WebElement) colorPinkOption).click();
      default:
        System.out.println("No dress color found!");
        break;
    }
  }

  public void addDressToCard(ItemDress itemDress){
    checkDressSize(itemDress.getSize());
    checkDressColor(itemDress.getColor());
    Waits.waitForUrlContains("color");
    actions.moveToElement((WebElement) itemForm);
    itemMoreButton.click();
  }

  public void clickForItem(){
    actions.moveToElement((WebElement)itemImage).click();
    itemForm.isDisplayed();
  }

  public void clickMoreButtonForItem(){
    actions.moveToElement((WebElement)itemImage);
    itemMoreButton.click();
  }

  public boolean itemFormIsDisplayed(){
    return itemForm.isDisplayed();
  }


}
