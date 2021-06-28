package api;

import api.controller.service.ReadableResponse;
import api.controller.service.request.InstallmentApiController;
import api.controller.test.BaseTest;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.Date;

import static api.controller.utility.constants.Config.getWireMockHost;
import static api.controller.utility.constants.Config.getWireMockPort;
import static api.controller.utility.constants.Keywords.ZONE_ID;
import static api.controller.utility.LogUtils.logInfo;
import static com.github.tomakehurst.wiremock.client.WireMock.removeAllMappings;
import static com.github.tomakehurst.wiremock.client.WireMock.resetAllRequests;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BaseInstallmentTest extends BaseTest {

    protected InstallmentApiController installmentApiController = new InstallmentApiController();

    @BeforeSuite
    public void setUpSuite() {
        logInfo("(*) START TIME OF TESTS: " + new Date().toInstant().atZone(ZONE_ID));

        shouldApiBeHealthy();
    }

    @BeforeClass
    public void setUpClass() {
        mockData();
    }

    public void shouldApiBeHealthy() {
        ReadableResponse response = installmentApiController.getHealthCheck();

        assertThat("When a user tries get health-check, status code should be '200' ", response.getStatusCode(), is(SC_OK));
    }

    public void mockData() {
        WireMock.configureFor(getWireMockHost(), getWireMockPort());
        removeAllMappings();
        resetAllRequests();
        //baseMapping
    }
}
