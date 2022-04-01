package com.quantum.listeners;







//        import static co.tide.allspark.utility.SystemUtils.createAppBuildNumberReportColumn;
//        import static co.tide.allspark.utility.SystemUtils.webKeepAliveOff;
//        import co.tide.allspark.utility.SystemUtils;
import com.quantum.listeners.QuantumReportiumListener;
import com.quantum.utils.DeviceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;


/**
 * Test execution listener
 */
public class Listener extends QuantumReportiumListener {
    private final Logger log = LoggerFactory.getLogger(Listener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        super.onTestStart(iTestResult);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        DeviceUtils.getQAFDriver().executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Test Passed!\"}}");
        super.onTestSuccess(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        DeviceUtils.getQAFDriver().executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Test Failed!\"}}");
        super.onTestFailure(iTestResult);
    }


}
