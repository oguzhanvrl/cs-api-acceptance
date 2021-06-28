package api.controller.test;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {
        for (ITestNGMethod method : context.getSuite().getAllMethods()) {
            method.setRetryAnalyzerClass(Retry.class);
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(ITestContext iTestContext) {
    }
}
