package api.controller.test;

import org.testng.ITestListener;
import org.testng.ITestResult;

import static api.controller.utility.LogUtils.*;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        try {
            logInfo("TEST STARTED: " + iTestResult.getName());
        } catch (ArrayIndexOutOfBoundsException oobe) {
            logError("Cannot log test name!");
        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logInfo("Test Finished Successfully: " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logError("Test Failed: " + iTestResult.getName() + " Exception is: " + iTestResult.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        if (iTestResult.getParameters().length == 0) {
            logWarn("Test Has Been Skipped: " + iTestResult.getName());
        } else {
            iTestResult.setStatus(2);
            iTestResult.setParameters(new String[]{});
        }
    }
}