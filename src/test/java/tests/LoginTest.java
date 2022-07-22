package tests;

import core.ReadProperties;
import org.testng.annotations.Test;
import services.MyAccountService;

public class LoginTest extends BaseTest {

  protected MyAccountService myAccountService;

  @Test
  public void successAuthorizationTest() {
    String welcomeMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";
    myAccountService = loginService.login(ReadProperties.getUsername(),
        ReadProperties.getPassword());
    myAccountService.verifySuccessMessage(welcomeMessage);
    myAccountService.logout();
  }

  @Test
  public void failedAuthorizationTest() {
    String errorMessage = "Authentication failed.";
    myAccountService = loginService.login(ReadProperties.getUsername(),
        "23545454545");
    myAccountService.verifyErrorMessage(errorMessage);

  }
}
