package tests;

import core.Driver;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import services.LoginService;

public class BaseTest {
  private static WebDriver driver;
  protected LoginService loginService;

  @BeforeClass
  public void setUp() {
    driver = Driver.getDriverInstance();
    driver.get(ReadProperties.getUrl());
  }

  @BeforeMethod
  public void initLogin(){
    loginService = new LoginService();
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}
