package PageObjectModel;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Facebookpage {

	WebDriver driver;
	
	public Facebookpage(WebDriver driver) {
		this.driver = driver;
	}
	By username_editbox = By.xpath("//input[@id='email']");
	By password_editbox = By.id("pass");
	By login_btn = By.name("login");
	
	public void EnterUsername() {
		driver.findElement(username_editbox).clear();
		driver.findElement(username_editbox).sendKeys("8789752830");
		
	}
	public void EnterPassword() {
		driver.findElement(password_editbox).clear();
		driver.findElement(password_editbox).sendKeys("Hussainarif");
	}
	public void VerifyLogin() {
		driver.findElement(login_btn).click();
		String title = driver.getTitle();
		assertEquals(title, "Facebook - log in or sign up");
	}
}
