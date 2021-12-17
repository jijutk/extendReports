package extendReports;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends base implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.extentReportGenerator();
	//when tests needed to be run in parallel use TreadSafe to 
	//to avoid deadlock
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	// use above methods
	
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		//This is all done to get the failed screenshot or simple test is using  
		WebDriver driver=null;
		//when without parallel execution
		//test.fail(arg0.getThrowable());
		extentTest.get().fail(arg0.getThrowable());
		Object testObject = arg0.getInstance();
			
		//Class clazz	= arg0.getTestClass().getRealClass();
		Class<?> clazz = arg0.getTestClass().getRealClass();
			try {
			driver = (WebDriver)clazz.getDeclaredField("driver").get(testObject);
			} catch (Exception e1){
	}
			
			try {
			
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(arg0.getMethod().getMethodName(),driver),
					arg0.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
	 // without thread class
		//test = extent.createTest(arg0.getMethod().getMethodName());
	// with thread class
		test = extent.createTest(arg0.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		//test.log(Status.PASS, "Successful");
		// with thread class change test with extentTest.get() class
		extentTest.get().log(Status.PASS, "Successful");
	}

}
