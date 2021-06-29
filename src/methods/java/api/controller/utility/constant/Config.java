package api.controller.utility.constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static api.controller.utility.LogUtils.logInfo;
import static org.apache.commons.lang3.StringUtils.isBlank;

public final class Config {
    public static final String ENVIRONMENT;

    static {
        ENVIRONMENT = getEnv();
    }

    public static String getApiUrl() {
        if (ENVIRONMENT.equals("pipeline")) {
            //read url from system.properties
            return System.getProperties().getProperty("api.url");
        } else {
            //read url from resources/stage_config.properties
            return loadProperties(ENVIRONMENT).getProperty("api.url");
        }
    }

    public static String getWireMockHost() {
        return System.getProperties().getProperty("wiremock.host");
    }

    public static Integer getWireMockPort() {
        return Integer.valueOf(System.getProperties().getProperty("wiremock.port"));
    }

    private static Properties loadProperties(String env) {
        String configFileName = env + "_config.properties";
        InputStream in = ClassLoader.getSystemResourceAsStream(configFileName);
        Properties properties = new Properties();

        try {
            properties.load(in);
        } catch (IOException ioe) {
            throw new IllegalStateException("Exception on loading {" + configFileName + "} conf file from classpath", ioe);
        }
        return properties;
    }

    private static String getEnv() {
        String env = System.getProperties().getProperty("env");

        if (isBlank(env)) {
            logInfo("No ENV option is set, please set -Denv in java. Now default environment stage will be set");
            return "pipeline";
        }

        return env;
    }
}
