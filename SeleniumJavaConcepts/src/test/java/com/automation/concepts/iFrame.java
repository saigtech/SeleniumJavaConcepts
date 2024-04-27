package com.automation.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iFrame {
	
	WebDriver driver;
	Actions actions;
	
	@BeforeMethod
	public void setUp() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Frames.html");
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	@Test
	public void testIframe() throws InterruptedException {
		
       //switching to single iframe from default iframe
       driver.switchTo().frame("SingleFrame");
       driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Testing");
       //Thread.sleep(5000);
       
       /*switching to parent frame in this context it is defaultFrame*/
       driver.switchTo().parentFrame();
       driver.findElement(By.linkText("Iframe with in an Iframe")).click();
       //Thread.sleep(5000);
       
       WebElement parentFrame=driver.findElement(By.xpath("//div[@id='Multiple']/child::iframe"));
       driver.switchTo().frame(parentFrame);
       WebElement childFrame = driver.findElement(By.xpath("//div[@class='iframe-container']/child::iframe"));
       
       //Switch to child iframe
       driver.switchTo().frame(childFrame);
       driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Multi Frame Testing");
       //Thread.sleep(2000);
       
       //driver.switchTo().defaultContent();
       System.out.println(driver.findElement(By.xpath("//h5")).getText());
       driver.switchTo().defaultContent();
       driver.findElement(By.partialLinkText("Single"));       
	}

}
