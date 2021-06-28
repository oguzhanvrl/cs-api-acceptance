package api.controller.test.matcher;

import api.controller.model.Sample;
import api.controller.service.ReadableResponse;
import api.controller.utility.SampleReader;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;

import static java.lang.String.format;

public class SampleMatchers {
    public static Matcher<ReadableResponse> deepEqual(Sample sample) {
        final String expectedResponse = SampleReader.string(sample);

        return new BaseMatcher<>() {
            @Override
            public boolean matches(final Object item) {
                ReadableResponse response = (ReadableResponse) item;
                try {
                    JSONAssert.assertEquals(expectedResponse, response.getFullBodyMessage(), true);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("Response should have info as, ").appendValue(format("valid sample: %s.", sample.toString()));
            }

            @Override
            public void describeMismatch(Object item, Description description) {
                description.appendText("not found!");
            }
        };
    }

    public static Matcher<ReadableResponse> deepEqual(JSONObject sample) {
        final String expectedResponse = sample.toString();

        return new BaseMatcher<ReadableResponse>() {
            @Override
            public boolean matches(final Object item) {
                ReadableResponse response = (ReadableResponse) item;

                try {
                    JSONAssert.assertEquals(expectedResponse, response.getFullBodyMessage(), true);

                    return true;
                } catch (Exception e) {
                    e.printStackTrace();

                    return false;
                }
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("Response should have info as, ").appendValue(format("valid sample: %s.", sample.toString()));
            }

            @Override
            public void describeMismatch(Object item, Description description) {
                description.appendText("not found!");
            }
        };
    }
}
