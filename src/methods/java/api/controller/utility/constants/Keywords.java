package api.controller.utility.constants;

import java.time.ZoneId;

public class Keywords {
    public static final int RETRY_COUNT_FOR_FAILED_TEST = 2;

    public static final String CONTENT_TYPE = "Content-Type";
    public static final String APPLICATION_JSON = "application/json;charset=UTF-8";
    public static final String MULTI_PART_FORM_DATA = "multipart/form-data";
    public static final String CREATED_BY = "TestAutomation";

    public static final ZoneId ZONE_ID = ZoneId.of("Europe/Istanbul");

    private Keywords() {
    }
}
