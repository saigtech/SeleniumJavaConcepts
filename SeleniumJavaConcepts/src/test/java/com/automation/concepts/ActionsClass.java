package com.automation.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClass {

	WebDriver driver;
	Actions actions;
	
	@BeforeMethod
	public void setUp() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        actions =  new Actions(driver);

	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
	@Test
	public void openInNewTab() {
		driver.get("https://www.selenium.dev/");
        WebElement link = driver.findElement(By.xpath("//a[@href='/documentation']/span")); 
        actions.keyDown(Keys.CONTROL).moveToElement(link).click().keyUp(Keys.CONTROL).perform();	
        }
	
	@Test
	public void upperCaseLowerCaseLetters() {
		driver.get("https://www.selenium.dev/documentation/");
		driver.findElement(By.className("DocSearch-Search-Icon")).click();        	
    	WebElement textBox = driver.findElement(By.id("docsearch-input"));
      	actions.moveToElement(textBox).sendKeys(Keys.SHIFT).sendKeys("Test").keyUp(Keys.SHIFT).sendKeys("down").perform();
	}
	
	@Test
	public void scrollDown() {
		driver.get("https://www.selenium.dev/documentation/");
    	actions.keyDown(Keys.CONTROL).keyDown(Keys.END).perform();
	}
	
	@Test
	public void scrollUp() throws InterruptedException {
		driver.get("https://www.selenium.dev/documentation/");
    	actions.keyDown(Keys.CONTROL).keyDown(Keys.END).perform();
    	Thread.sleep(3000);
    	actions.keyDown(Keys.CONTROL).keyDown(Keys.HOME).perform(); 
	}
	
	@Test
	public void doubleClick() {
     	driver.get("https://artoftesting.com/samplesiteforselenium");        
    	WebElement dblClkBtn = driver.findElement(By.id("dblClkBtn"));
     	actions.moveToElement(dblClkBtn).doubleClick().perform();
	}
	@Test
	public void mouseHover() {
    	driver.get("https://www.browserstack.com/");
    	WebElement menu = driver.findElement(By.id("developers-dd-toggle"));
    	WebElement events = driver.findElement(By.xpath("//a[@href='/events']"));
    	actions.moveToElement(menu).click(events).perform();
	}
	
	@Test
	public void dragAndDrop() {
		driver.get("https://jqueryui.com/droppable/");
    	WebElement iframe = driver.findElement(By.className("demo-frame"));	
    	
        //Switching to the iframe
        
    	driver.switchTo().frame(iframe);
    	WebElement source = driver.findElement(By.id("draggable"));
    	WebElement target = driver.findElement(By.id("droppable"));
    	actions.dragAndDrop(source, target).perform();
    	actions.clickAndHold(source).moveToElement(target).release().perform(); 
	}
	@Test
	public void scrollTo() {
		driver.get("https://www.selenium.dev/");
        WebElement element =  driver.findElement(By.xpath("//h2[@class='selenium text-center']"));
        Point location = element.getLocation();
        actions.scrollByAmount(location.x,location.y).perform();
	}

}
