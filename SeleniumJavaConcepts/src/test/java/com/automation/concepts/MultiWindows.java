package com.automation.concepts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiWindows {
	
	WebDriver driver;
	Actions actions;
	
	@BeforeMethod
	public void setUp() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		actions = new Actions(driver);
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	@Test
	public void testMultipleWindows() throws InterruptedException {

		System.out.println("Main Window Title:"+driver.getTitle());
		
		//Main Window Handle
	    String mainWindow = driver.getWindowHandle();
	    WebElement newTab = driver.findElement(By.id("tabButton"));
	    actions.moveToElement(newTab).click().perform();
	    //newTab.click();
		Thread.sleep(2000);
		
		//getWindowHandles()
		Set<String> windowHandles = driver.getWindowHandles();
		
		//size of windowHandles
		System.out.println("Number of Windows open:"+windowHandles.size());
		
		
		for(String str:windowHandles) {
			if(!(str.equals(mainWindow))) {
				driver.switchTo().window(str);
				
			}
		}
		
		Thread.sleep(1000);
		System.out.println("New Window Title"+ driver.getTitle());
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		driver.close();
		driver.switchTo().window(mainWindow);
		
		driver.findElement(By.id("windowButton")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		for(String str:windowHandles2) {
			if(!(str.equals(mainWindow))) {
				driver.switchTo().window(str);
				
			}
			
		}

		System.out.println(driver.findElement(By.tagName("body")).getText());
		driver.close();
		driver.switchTo().window(mainWindow);
		WebElement newWindow = driver.findElement(By.id("messageWindowButton"));
		actions.moveToElement(newWindow).click().perform();
		Set<String> windowHandles3 = driver.getWindowHandles();
		
		for(String str:windowHandles3) {
			if(!(str.equals(mainWindow))) {
				driver.switchTo().window(str);
				
			}
			
		}

	}

}
