package core.listners;

import core.logging.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

  @Override
  public void onStart(ITestContext context) {
    Log.logInfoMessage("----------Start ALL----------------\n\n");
  }

  @Override
  public void onFinish(ITestContext context) {
    Log.logInfoMessage("----------Finish ALL----------------\n\n");
  }

  @Override
  public void onTestStart(ITestResult res) {
    Log.logInfoMessage("Start test " + res.getMethod().getMethodName());
  }

  @Override
  public void onTestSuccess(ITestResult res) {
    Log.logInfoMessage(res.getMethod().getMethodName() + " PASSED !!!  \n\n");
  }

  @Override
  public void onTestSkipped(ITestResult res) {
    Log.logInfoMessage(res.getMethod().getMethodName() + " SKIPPED !!! \n\n");
  }

  @Override
  public void onTestFailure(ITestResult res) {
    Throwable throwable = res.getThrowable();
    Log.logInfoMessage(res.getMethod().getMethodName() + " FAILURE !!! \n"
        + throwable.toString() + "\n\n");
  }
}
