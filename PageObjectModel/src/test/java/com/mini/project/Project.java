package com.mini.project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Project {
	
	public static WebDriver driver;
	@BeforeTest
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@Test(priority=1)
	public void linkText() {
		driver.get("https://testpages.herokuapp.com/basic_html_form.html");
	}
	@Test(priority=2)
	public void userName()  {
		WebElement user = driver.findElement(By.xpath("//*[@name='username']"));
		user.sendKeys("Md Arif Hussain");
		
	}
	@Test(priority=3)
	public void password() {
		WebElement pass = driver.findElement(By.xpath("//*[@name='password']"));
		pass.sendKeys("Huss@1n");
	}
	@Test(priority=4)
	public void comments() {
		WebElement comment = driver.findElement(By.xpath("//*[@name='comments']"));
		comment.clear();
		comment.sendKeys("I started TestNG out of frustration for some JUnit deficiencies which "
				+ "I have documented on my weblog here and here Reading these entries might give "
				+ "you a better idea of the goal I am trying to achieve with TestNG.  You can "
				+ "also check out a quick overview of the main features and an article "
				+ "describing a very concrete example where the combined use of several "
				+ "TestNG's features provides for a very intuitive and maintainable testing design.");
	}
	@Test(priority=5)
	public void Checkboxs() {
		List<WebElement> box = driver.findElements(By.xpath("//*[@type='checkbox']"));
		int totalBoxs = box.size();
		System.out.println("The Total Radio Button Size ="+totalBoxs);
		int expect = 3;
		int actual = totalBoxs;
		Assert.assertEquals(actual,expect);
	}
	@Test(priority=6)
	public void Checkbox() {
		WebElement box = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
		box.click();
		boolean expect = true;
		boolean actual = box.isSelected();
		Assert.assertEquals(actual,expect);
	}
	@Test(priority=7)
	public void radioButtons() {
		List<WebElement> buttons = driver.findElements(By.xpath("//*[@type='radio']"));
		int totalButtons = buttons.size();
		System.out.println("The Total Radio Button Size ="+totalButtons);
		int expect = 3;
		int actual = totalButtons;
		Assert.assertEquals(actual,expect);
	}
	@Test(priority=8)
	public void radioButton() throws InterruptedException {
		WebElement button = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
		button.click();
		boolean expect = true;
		boolean actual = button.isSelected();
		Assert.assertEquals(actual,expect);
		Thread.sleep(3000);
	}
	@Test(priority=9)
	public void Submit() {
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		submit.click();
		}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Program is Completed...!");
		driver.quit();
	}
}
