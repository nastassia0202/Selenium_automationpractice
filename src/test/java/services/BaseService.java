package services;

import core.Logger;
import pages.BasePage;
import pages.LoginPage;

public class BaseService {

  protected BasePage basePage;

  public LoginPage logout(){
    Logger.info("Logout");
    return basePage.logout();
  }

}
