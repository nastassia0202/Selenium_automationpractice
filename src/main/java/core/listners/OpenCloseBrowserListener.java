package core.listners;

import core.ReadProperties;
import core.logging.Log;
import org.testng.IClassListener;
import org.testng.ITestClass;
import webdriver.WebDriverSingleton;

public class OpenCloseBrowserListener implements IClassListener {

  @Override
  public void onBeforeClass(ITestClass testClass) {

    WebDriverSingleton
        .getInstance()
        .getDriver()
        .navigate()
        .to(ReadProperties.getUrl());
  }

  @Override
  public void onAfterClass(ITestClass testClass) {
    Log.logInfoMessage("Close browser");
    WebDriverSingleton.getInstance().closeDriver();
  }
}
