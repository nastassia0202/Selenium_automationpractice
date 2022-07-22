package core;



public class Logger {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Logger.class);
    private Logger() {
    }

    public static void info(String message) {
        log.info(message);
    }

    public static void error(String message) {
        log.error(message);
    }
}
