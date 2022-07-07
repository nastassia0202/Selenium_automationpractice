package pages;

import element.Element;

public class LoginPage extends BasePage {

  private final Element txtEmailAddress = Element.getById("email");
  private final Element txtPassword = Element.getById("passwd");
  private final Element btnSignIn = Element.getById("SubmitLogin");
  private final Element btnForgotPassword = Element.getByXpath(
      "//*[contains(text(), 'Forgot your password')]");

  public LoginPage typeEmailAddress(String value) {
    txtEmailAddress.type(value);
    return this;
  }

  public LoginPage typePassword(String value) {
    txtPassword.type(value);
    return this;
  }

  public void clickSignInButton() {
    btnSignIn.click();
  }
}
