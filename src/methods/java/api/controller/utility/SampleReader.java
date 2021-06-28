package api.controller.utility;

import api.controller.model.Sample;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class SampleReader {
    private static final String SAMPLES_PATH = "samples/";

    public static String string(Sample sample) {
        String samplePath = SAMPLES_PATH + sample.getPath();
        InputStream inStream = ClassLoader.getSystemResourceAsStream(samplePath);
        try {
            assert inStream != null;
            return IOUtils.toString(inStream, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static JSONObject json(Sample sample) {
        String samplePath = SAMPLES_PATH + sample.getPath();
        InputStream inStream = ClassLoader.getSystemResourceAsStream(samplePath);

        try {
            return new JSONObject(IOUtils.toString(inStream, StandardCharsets.UTF_8.name()));
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }
}
