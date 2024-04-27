package com.automation.concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutorScrollDemo {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	
	@BeforeMethod
	public void setUp() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("https://practice.automationtesting.in/my-account/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;

	}
	
	@AfterMethod
	public void quit() {
		//driver.quit();
	}
	@Test
	public void testJSExecutor() {
			
			WebElement txtUsername = driver.findElement(By.id("username"));
			WebElement txtPassword = driver.findElement(By.id("password"));
			WebElement btnLogin = driver.findElement(By.name("login"));
		
			js.executeScript("arguments[0].value='bhargav@gmail.com';", txtUsername);
			js.executeScript("arguments[0].value='bhargav@123';", txtPassword);
			js.executeScript("arguments[0].click()", btnLogin);
			
			driver.findElement(By.linkText("Test Cases")).click();
			WebElement headerShop = driver.findElement(By.xpath("//h3[text()='SHOP']"));
			//Scroll
			js.executeScript("arguments[0].scrollIntoView(true);", headerShop);
			
	}

}
