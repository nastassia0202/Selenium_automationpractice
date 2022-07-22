package services;

import org.testng.Assert;
import pages.MyAccountPage;

public class MyAccountService extends BaseService{

  private MyAccountPage myAccountPage = new MyAccountPage();

  public void verifySuccessMessage(String expMessage) {
    Assert.assertEquals(myAccountPage.getWelcomeMessage(), expMessage);
  }

  public void verifyErrorMessage(String expMessage) {
    Assert.assertEquals(myAccountPage.getErrorMessage(), expMessage);
  }
}
