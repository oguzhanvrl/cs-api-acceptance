package api.controller.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LogUtils {
    private static final Logger LOGGER = LogManager.getLogger(LogUtils.class);
    private static final StringBuilder sb = new StringBuilder();

    private LogUtils() {
    }

    public static void logInfo(final String message) {
        sb.append(message);
        LOGGER.info(message);
    }

    public static void logError(final String message) {
        sb.append(message);
        LOGGER.error(message);
    }

    public static void logDebug(final String message) {
        sb.append(message);
        LOGGER.debug(message);
    }

    public static void logWarn(final String message) {
        sb.append(message);
        LOGGER.warn(message);
    }

    public static void logFatal(final String message) {
        sb.append(message);
        LOGGER.fatal(message);
    }
}
