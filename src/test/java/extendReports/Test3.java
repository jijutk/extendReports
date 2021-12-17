package extendReports;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test3 extends base {
	
WebDriver driver;
	
	@Test
	public void initOracle() {
		
		
		driver = initializeDriver();
		
		driver.get("https://www.oracle.com");
		System.out.println(driver.getTitle());
		driver.close();
	
		
	}

}
