package api.controller.test;

import api.controller.utility.constants.Keywords;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private static final int maxTry = Keywords.RETRY_COUNT_FOR_FAILED_TEST;
    private int count;

    public Retry() {
        //nothing happens
    }

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (count < maxTry) {
                count++;
                return true;
            } else {
                result.setStatus(ITestResult.FAILURE);
            }
        } else {
            result.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
