package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDataProvider {
	
	WebDriver driver;
	
	@BeforeClass
	void setUpClass() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/patri/Downloads/chromedriver.exe");

	}
	
	@AfterClass
	void tearDownClass() {
		System.clearProperty("webdriver.chrome.driver");
	}

	@BeforeMethod
	void setUpMethod() {
		// Opening Google Browser in Google Chrome using Selenium
		driver = new ChromeDriver();
		driver.get("http://www.google.com");			
	}
	
	@AfterMethod
	void tearDown() {
		driver.quit();
	}
	
	
		
	@Test(dataProvider = "calc-data", dataProviderClass = TestData.class)
	void calcTest(String input, String expected) {			
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys(input);
		element.submit();
		
		WebElement result = driver.findElement(By.id("cwos"));
		Assert.assertEquals(result.getText(), expected);
	}
}
