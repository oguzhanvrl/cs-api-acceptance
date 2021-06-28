package api.controller.test.matcher;

import api.controller.model.Installment;
import api.controller.service.ReadableResponse;
import com.google.gson.Gson;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.skyscreamer.jsonassert.JSONAssert;

import static java.lang.String.format;

public class InstallmentMatchers {

    public static Matcher<ReadableResponse> shouldInstallmentInfoAs(int mounthCount, boolean installmentStatus) {
        return new BaseMatcher<>() {

            @Override
            public boolean matches(final Object item) {
                ReadableResponse response = (ReadableResponse) item;

                Installment actualInstalment = new Gson().fromJson(response.getFullBodyMessage(), Installment.class);

                actualInstalment.getProducts().forEach(eachProduct -> {
                    float expectedInstallementPrice = eachProduct.getPrice().getCurrent() / mounthCount;
                    String expectedInstallementText = String.format("%s x %s TL Taksit Seçeneği", mounthCount, expectedInstallementPrice);

                    if (!installmentStatus) {
                        expectedInstallementText = "";
                    }

                    JSONAssert.assertEquals(eachProduct.getInstallment().toString(), String.valueOf(installmentStatus), true);
                    JSONAssert.assertEquals(eachProduct.getInstallmentText(), expectedInstallementText, true);

                });

                return true;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("Response should have installment info as, ").appendValue(format("expectedInstallment: %s.", ""));
            }

            @Override
            public void describeMismatch(Object item, Description description) {
                description.appendText("installment found!");
            }
        };
    }
}
