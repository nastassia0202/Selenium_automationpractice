package tests;

import model.ItemDress;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CartPage;
import pages.DressesCatalogPage;

public class AddDressToCardTest extends BaseTest{

  public ItemDress validDress;

  @Test
  public void entityAdditionTest(){
    BasePage basePage = new BasePage();
    DressesCatalogPage dressesCatalogPage = new DressesCatalogPage();
    dressesCatalogPage.addDressToCard(validDress);
    basePage.checkoutButtonClick();
    CartPage cartPage = new CartPage();
    Assert.assertTrue(!cartPage.alertIsDisplayed());
  }
}
