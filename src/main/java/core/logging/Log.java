package core.logging;

import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

  private Log() {
  }

  private static final Logger LOGGER = LogManager.getLogger();

  public static void logInfoMessage(String msg) {
    LOGGER.info(msg);
  }

  public static void logInfoMessage(String msgPattern, Object... params) {
    LOGGER.info(String.format(msgPattern, params));
  }
}
