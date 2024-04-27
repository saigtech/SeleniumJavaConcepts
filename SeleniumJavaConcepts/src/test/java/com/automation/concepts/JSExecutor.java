package com.automation.concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
	
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
		driver.quit();
	}
	@Test
	public void testJsExecutor() {
		

		WebElement txtUsername = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement txtPassword = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement btnLogin = driver.findElement(By.xpath("//input[@name='login']"));

		js.executeScript("arguments[0].value='bhargav@gmail.com';", txtUsername);
		js.executeScript("arguments[0].value='bhargav@123';", txtPassword);
		js.executeScript("arguments[0].click()", btnLogin);
	
	}

}
