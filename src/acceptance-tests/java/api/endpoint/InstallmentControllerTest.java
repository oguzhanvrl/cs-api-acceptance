package api.endpoint;

import api.BaseInstallmentTest;
import api.controller.model.Sample;
import api.controller.service.ReadableResponse;
import api.controller.service.mock.InstallmentMockApiController;
import api.controller.test.matcher.SampleMatchers;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static api.controller.test.matcher.InstallmentMatchers.shouldInstallmentInfoAs;
import static api.controller.test.matcher.Matchers.shouldResponseEqualsMessageAs;
import static api.controller.test.matcher.Matchers.shouldStatusCodeSameAs;
import static com.github.tomakehurst.wiremock.client.WireMock.removeStub;
import static org.apache.http.HttpStatus.SC_INTERNAL_SERVER_ERROR;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;

public class InstallmentControllerTest extends BaseInstallmentTest {

    private StubMapping stubGetInstallment;

    @AfterMethod(alwaysRun = true)
    @Override
    public void afterMethod() {
        if (stubGetInstallment != null) {
            removeStub(stubGetInstallment);
        }
    }

    //Scenario 1
    @Test
    public void shouldGetInstallmentWithInstallmentCount0() {
        int installmentCount = 0;

        stubGetInstallment = InstallmentMockApiController.addInstallmentGetMapping(String.valueOf(installmentCount), SC_OK, Sample.INSTALLMENT_COUNT_0);

        ReadableResponse response = installmentApiController.getInstallment(installmentCount);

        assertThat("When a user tries get installment with installmentCount " + installmentCount + ", status code should be '200' ", response, shouldStatusCodeSameAs(SC_OK));

        //matcher 1 ******
        assertThat("When a user tries get installment with installmentCount " + installmentCount + ", should able installement info ", response, SampleMatchers.deepEqual(Sample.INSTALLMENT_COUNT_0));

        //matcher 1 & 2 tercihe göre ikisi de kullanılabilir, örnek olması açsından iki farklı matcher yapısı ekledim...
    }

    //Scenario 2
    @Test
    public void shouldGetInstallmentWithInstallmentCount1() {
        int installmentCount = 1;

        stubGetInstallment = InstallmentMockApiController.addInstallmentGetMapping(String.valueOf(installmentCount), SC_OK, Sample.INSTALLMENT_COUNT_1);

        ReadableResponse response = installmentApiController.getInstallment(installmentCount);

        //sample matcher 2 ******
        assertThat("When a user tries get installment with installmentCount " + installmentCount + ", should able installement info ", response, shouldInstallmentInfoAs(6,true));

        //matcher 1 & 2 tercihe göre ikisi de kullanılabilir, örnek olması açsından iki farklı matcher yapısı ekledim...
    }

    //Scenario 3
    @Test
    public void shouldNotGetInstallmentWithoutInstallmentCount() {
        stubGetInstallment = InstallmentMockApiController.addInstallmentGetMapping("", SC_OK, Sample.EMPTY_INSTALLMENT_COUNT);

        ReadableResponse response = installmentApiController.getInstallment();

        assertThat("When a user tries get installment without installmentCount, status code should be '500' ", response, shouldStatusCodeSameAs(SC_INTERNAL_SERVER_ERROR));

        //error matcher 3 ******
        assertThat("When a user tries get installment without installmentCount,  should able see expected error message ", response, shouldResponseEqualsMessageAs("message", "INTERNAL_SERVER_ERROR"));
    }
}
