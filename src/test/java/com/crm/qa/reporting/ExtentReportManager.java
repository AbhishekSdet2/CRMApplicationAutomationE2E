package com.crm.qa.reporting;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports reports;     // populate common info on the report
	public ExtentTest test;           //creating test case entries in the report and update status of the test methods
	
	public void onStart(ITestContext context) {
		sparkReporter=new ExtentSparkReporter("C://Users//abhis//eclipse-workspace//CRMProjectNaveenAutomationLabs//CRMAutomation//reports//myReport.html");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("One Big beautiful Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(sparkReporter);
		
		reports.setSystemInfo("Computer Name", "localhost");
		reports.setSystemInfo("Environment","prod");
		reports.setSystemInfo("SDET Name", "Abhishek");
		reports.setSystemInfo("os", "Windows 10");
		reports.setSystemInfo("Browser Name", "chrome");
	}
	
	public void onTestSuccess(ITestResult result) {
		test=reports.createTest(result.getName()); //Create a new entry in the report
		test.log(Status.PASS, "Test case is passed:"+result.getName()); //Update status pass
	}
	
	public void onTestFailure(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, "Test case is Failed"+result.getName());
		test.log(Status.FAIL, "Test case Failed cause is"+result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.SKIP,"Test case is skipped:"+result.getName());
	}
	
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
