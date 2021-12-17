package extendReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2 extends base {

WebDriver driver;
	
	@Test
	public void initSauceLabs() {
		
		driver = initializeDriver();
		driver.get("https://www.saucedemo.com/");
		
		System.out.println(driver.getTitle());
		//driver.close();
	}
	
	/* more features suitable for use regression test automation projects
	 * Data Provider is one such feature of TestNG . 
	 * It allows test method to be executed with multiple sets of data
	 * AUT(Application Under Test) */
	@Test(dataProvider = "getData")
	 public void testSaucedemo(String Username, String Password) throws InterruptedException {
	    driver.findElement(By.name("user-name")).sendKeys(Username);
	   	 driver.findElement(By.name("password")).sendKeys(Password);
	   	 //driver.findElement(By.id("login-button")).click();
	   	Thread.sleep(3000);
	   	Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed(), "Login Failed");
	   	System.out.println("Login Successful");
	    }
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "standard_user";
		data[0][1] = "secret_sauce";
		data[1][0] = "problem_user";
		data[1][1] = "secret_sauce";
		data[2][0] = "locked_out_user";
		data[2][1] = "secret_sauce";
		return data;
	}
}
