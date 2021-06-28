package api.controller.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class WaitUtils {

    private static final Logger LOGGER = LogManager.getLogger(WaitUtils.class);

    public static void threadWaiter(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            LOGGER.error(e.toString());
            Thread.currentThread().interrupt();
        }

    }

}

