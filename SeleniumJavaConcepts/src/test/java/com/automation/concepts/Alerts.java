package com.automation.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alerts {

	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;
	
	@BeforeMethod
	public void setUp() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts"); 
		js = (JavascriptExecutor)driver;

	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
	@Test
	public void acceptAlert() throws InterruptedException {
		
		WebElement button = driver.findElement(By.id("alertButton"));
    	js.executeScript("arguments[0].click()", button);
		Thread.sleep(2000);
		//getText() from the pop up what ever displayed
		System.out.println(driver.switchTo().alert().getText());
		//Accepting the checkbox
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void dismissAlert() throws InterruptedException {

		WebElement button = driver.findElement(By.id("confirmButton"));
		actions.scrollToElement(button);
    	js.executeScript("arguments[0].click()", button);
		//getText from the pop up what ever displayed
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);

		driver.switchTo().alert().dismiss();
	}

	@Test
	public void sendKeys() throws InterruptedException {

		WebElement button = driver.findElement(By.id("promtButton"));
		actions.scrollToElement(button);

    	js.executeScript("arguments[0].click()", button);
		System.out.println(driver.switchTo().alert().getText());
		
		//sendKeys()
		driver.switchTo().alert().sendKeys("Testing");
		Thread.sleep(2000);

		driver.switchTo().alert().accept();			

	}

}
