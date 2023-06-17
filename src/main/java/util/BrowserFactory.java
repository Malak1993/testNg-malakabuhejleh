package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BrowserFactory {
static	WebDriver driver;
	@BeforeTest
	public  static WebDriver init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/test/107/index.php");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	@AfterTest
public static WebDriver tearDown() {
	driver.close();
	driver.quit();
	
	return driver;
}
}
