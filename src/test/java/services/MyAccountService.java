package services;

import org.testng.Assert;
import pages.MyAccountPage;

public class MyAccountService extends BaseService {

  private MyAccountPage myAccountPage = new MyAccountPage();

  public void verifyMessage(String expMessage) {
    Assert.assertEquals(myAccountPage.getWelcomeMessage(), expMessage);
  }
}
