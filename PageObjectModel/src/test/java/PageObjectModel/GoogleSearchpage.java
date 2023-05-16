package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchpage {
	

	WebDriver driver;
	
	public GoogleSearchpage(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchbox = By.xpath("//textarea[@name='q']");
	By search_btn = By.xpath("(//input[@name='btnk'])[1]");
	By Facebook_link = By.xpath("//a//h3[text()='Facebook - log in or sign up']");
	
	public void searchgoogle(String Searchinput) {
		try {
			driver.findElement(searchbox).sendKeys(Searchinput);
			driver.findElement(search_btn).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Exceptions Caught "+ e.getMessage());
		}
		
	}
	
	public void ClickFacebook() {
		try {
			driver.findElement(Facebook_link).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Exceptions Caught "+ e.getMessage());
		}
	}

	
}
