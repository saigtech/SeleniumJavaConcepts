package com.automation.concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FluentWaitDemo {
	
	WebDriver driver;
	Actions actions;
	FluentWait<WebDriver> wait;
	
	@BeforeMethod
	public void setUp() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/dynamic_controls");
		wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1));
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
	@Test
	public void testFluentWait() {
		
		By text =  By.xpath("//form[@id='input-example']//input");
		driver.findElement(By.xpath("//form[@id='input-example']//button")).click();
		
		//Waiting for the text box is clickable
		wait.until(ExpectedConditions.elementToBeClickable(text)).sendKeys("Testing");
	
	}

}
