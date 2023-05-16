package Test_Method;

import org.testng.annotations.Test;

import PageObjectModel.Facebookpage;
import PageObjectModel.GoogleSearchpage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestMethod_GoogleSearch {
	WebDriver driver;
	GoogleSearchpage object;
	Facebookpage  object1;
	
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.get("https://google.com/");
	}
	
	@Test(priority=0)
	public void SearchOperation() throws InterruptedException{
		GoogleSearchpage page = new GoogleSearchpage(driver);
		page.searchgoogle("facebook");
		
	}
	@Test(priority=1)
	public void VerifyAccessFacebook() {
		object = new GoogleSearchpage(driver);
		object.ClickFacebook();
	}
	
	@Test(priority=2)
	public void VerifyLoginFunctionality() throws InterruptedException {
		object1 = new Facebookpage(driver);
		object1.EnterUsername();
		object1.EnterPassword();
		object1.VerifyLogin();
		
	}
	
	@AfterTest
	public void aftertest() {
		driver.quit();
		
	}
}
