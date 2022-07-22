package services;

import pages.LoginPage;

public class LoginService  extends BaseService{

  private LoginPage loginPage = new LoginPage();

  public MyAccountService login(String username, String password) {
    loginPage
        .sendEmailAddress(username)
        .sendPassword(password)
        .clickSignInButton();
    return new MyAccountService();
  }

}
