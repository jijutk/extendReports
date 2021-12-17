package extendReports;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;  // for this add apache common.io dependencies
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	
	WebDriver driver;

	public WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Jiju/workspace/extendReports/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
}
	
	
	//Taking screentest for the failed test
	public String getScreenshotPath(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir")+ "\\reports\\" +TestCaseName+".png";
		File file = new File(destPath);
		FileUtils.copyFile(source, file);
		return destPath;
	}
	
}
