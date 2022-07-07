package tests;

import core.ReadProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.LoginService;
import services.MyAccountService;

@Test
public class LoginTest {

  MyAccountService myAccountService;
  LoginService loginService;

  @BeforeMethod
  public void start() {
    loginService = new LoginService();
  }

  @Test
  public void successAuthorizationTest() {
    String welcomeMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";
    myAccountService = loginService.login(ReadProperties.getUsername(),
        ReadProperties.getPassword());
    myAccountService.verifyMessage(welcomeMessage);
  }
}
