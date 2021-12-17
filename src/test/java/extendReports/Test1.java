package extendReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends base {
	
	WebDriver driver;
	
	@Test
	public void initGoogle() {
		
		driver = initializeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("hello");
		System.out.println(driver.getTitle());
		//Assert.assertTrue(false);
		Assert.assertEquals("Something", "Google");
		driver.close();
	
		
	}


}
