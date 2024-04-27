package com.automation.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {

	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;
	
	@BeforeMethod
	public void setUp() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        actions =  new Actions(driver);
        driver.get("http://the-internet.herokuapp.com/upload");
		js = (JavascriptExecutor)driver;

	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
	@Test
	public void testFileUpload(){
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\gundu\\eclipse-workspace\\SeleniumJavaConcepts\\src\\main\\resources\\image.png");
		driver.findElement(By.id("file-submit")).click();
		

	}

}
