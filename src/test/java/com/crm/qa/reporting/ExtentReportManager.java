package com.crm.qa.reporting;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.Desktop;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.qa.base.TestBase;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports reports;     // populate common info on the report
	public ExtentTest test;           //creating test case entries in the report and update status of the test methods
	String repname;
	public void onStart(ITestContext context) {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repname="Test-Report-"+timeStamp+".html";
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repname);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("One Big beautiful Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(sparkReporter);
		
		reports.setSystemInfo("Computer Name", "localhost");
		reports.setSystemInfo("Environment","prod");
		reports.setSystemInfo("SDET Name", System.getProperty("user.name"));
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
		try {
			String imgPath=new TestBase().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.SKIP,"Test case is skipped:"+result.getName());
	}
	
	public void onFinish(ITestContext context) {
		reports.flush();
		String pathofExtentReport=System.getProperty("user.dir")+"\\reports\\"+repname;
		File extentReport=new File(pathofExtentReport);
		try {
			Desktop desktop = Desktop.getDesktop();
			desktop.browse(extentReport.toURI());
		}
		catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
