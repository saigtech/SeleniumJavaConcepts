package com.automation.concepts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadRobot {
	
	WebDriver driver;
	Actions actions;
	Robot robot;
	
	@BeforeMethod
	public void setUp() throws AWTException {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/upload");
        actions =  new Actions(driver);
        robot = new Robot();

	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	@Test
	public void testFileUpload() throws InterruptedException{

		//Thread.sleep(2000);
	   
		WebElement btnUploadFile = driver.findElement(By.id("file-upload"));
		actions.moveToElement(btnUploadFile).click().perform();
		StringSelection Obj = new StringSelection("C:\\Users\\gundu\\eclipse-workspace\\SeleniumJavaConcepts\\src\\main\\resources\\image.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Obj, null);
		 
		 robot.keyPress(KeyEvent.VK_CONTROL); 
		 robot.delay(1000);

		 robot.keyPress(KeyEvent.VK_V); 
		 robot.delay(1000);

		 robot.keyRelease(KeyEvent.VK_V); 
		 robot.delay(1000);

		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.delay(1000);

		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.delay(1000);

		 robot.keyRelease(KeyEvent.VK_ENTER);  
		 robot.delay(1000);
	}

}
