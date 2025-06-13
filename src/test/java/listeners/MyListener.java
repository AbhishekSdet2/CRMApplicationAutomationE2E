package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	public void onStart(ITestContext context) {
    System.out.println("Test Execution is started ...........");
	}

	public void onTestStart(ITestResult result) {
    System.out.println("test started ...............");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("test Passed ...............");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("test Failed ...............");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("test Skipped ...............");
	}

	public void onFinish(ITestContext context) {
		System.out.println("test Execution is completed ...............");
	}

}
