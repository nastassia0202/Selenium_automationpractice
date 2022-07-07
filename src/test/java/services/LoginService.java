package services;

import pages.LoginPage;

public class LoginService extends BaseService {

  private LoginPage loginPage = new LoginPage();

  public MyAccountService login(String username, String password) {
    loginPage
        .typeEmailAddress(username)
        .typePassword(password)
        .clickSignInButton();
    return new MyAccountService();
  }
}
