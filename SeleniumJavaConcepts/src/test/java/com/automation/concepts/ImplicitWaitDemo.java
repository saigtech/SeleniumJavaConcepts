package com.automation.concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWaitDemo {
	
	WebDriver driver;
	Actions actions;
	
	@BeforeMethod
	public void setUp() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("https://www.milkbasket.com/");
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	@Test
	public void testImplicitWait() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@href='#how-it-works']")).click();
		
	}

}
