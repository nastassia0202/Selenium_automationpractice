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

  public static void logMakeRequest(RequestSpecification spec, String method) {
    QueryableRequestSpecification query = SpecificationQuerier.query(spec);
    LOGGER.info("\n" + method + " REQUEST:");
    LOGGER.info("[PATH]:\n" + query.getBaseUri() + query.getBasePath());
    LOGGER.info("[HEADERS]:\n" + query.getHeaders().toString());
    try {
      LOGGER.info("[BODY]:\n" + query.getBody());
    } catch (Exception e) {
      LOGGER.info("[BODY]:\nNO BODY");
    }
  }

  public static void logGetRequest(RequestSpecification spec) {
    logMakeRequest(spec, "GET");
  }

  public static void logPostRequest(RequestSpecification spec) {
    logMakeRequest(spec, "POST");
  }

  public static void logPutRequest(RequestSpecification spec) {
    logMakeRequest(spec, "PUT");
  }

  public static void logPatchRequest(RequestSpecification spec) {
    logMakeRequest(spec, "PATCH");
  }

  public static void logDeleteRequest(RequestSpecification spec) {
    logMakeRequest(spec, "DELETE");
  }

  public static void logResponse(Response response) {
    LOGGER.info("RESPONSE: \n" + response.asPrettyString());
  }

  public static void logDebugMessage(String msg) {
    LOGGER.debug(msg);
  }
}
