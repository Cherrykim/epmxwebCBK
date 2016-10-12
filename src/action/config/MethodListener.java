package config;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import common.Common;
import common.Constant;

public class MethodListener implements IInvokedMethodListener {
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult result) {
		log.debug("Before invocation of " + method.getTestMethod().getMethodName());
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult result) {
 		log.debug("After invocation of " + method.getTestMethod().getMethodName());
		
		if (method.isTestMethod() || method.isConfigurationMethod()) {
			VerificationFailures allFailures = VerificationFailures.getFailures();

			// Add an existing failure for the result to the failure list.
			if (result.getThrowable() != null) {
				
				allFailures.addFailureForTest(result, result.getThrowable());
			}
			List<Throwable> failures = allFailures.getFailuresForTest(result);
			int size = failures.size();

			if (size > 0) {
				if (failures.get(size - 1).toString().contains("Exception") && !failures.get(size - 1).getMessage().contains("AssertionError")) {
					String script = Common.getCommon().captureAndConvertImageToURI(getClass().toString().replace("class ", ""), Constant.PathConfig.CAPTURE_SCREENSHOT);
					Reporter.log(script);
				}
				result.setStatus(ITestResult.FAILURE);
			}
		}
	}

	private static final Log log = LogFactory.getLog(MethodListener.class);

}
