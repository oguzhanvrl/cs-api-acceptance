package api.controller.service.mock;

import api.controller.model.Sample;
import api.controller.utility.SampleReader;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class InstallmentMockApiController {

    public static StubMapping addInstallmentGetMapping(String installmentCount, Integer statusCode, Sample sample) {
        return stubFor(get(urlEqualTo("/test/installment=" + installmentCount))
                .willReturn(aResponse()
                        .withStatus(statusCode)
                        .withHeader("Content-Type", "application/json")
                        .withBody(SampleReader.string(sample))));
    }
}
