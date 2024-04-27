package com.automation.concepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {
	
	WebDriver driver;
	Actions actions;
	
	@BeforeMethod
	public void setUp() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
	@Test
	public void testSelect() throws InterruptedException  {

		Thread.sleep(2000);

		WebElement singleSelectDropDown = driver.findElement(By.id("select-demo"));

		Select singleSelect = new Select(singleSelectDropDown);

		singleSelect.selectByIndex(2);

		Thread.sleep(2000) ;
		singleSelect.selectByValue("Thursday");
		Thread.sleep(2000);
		singleSelect.selectByVisibleText ("Saturday");
		List<WebElement> options = singleSelect.getOptions();

		for (WebElement ele : options) {
		System.out.println(ele.getAttribute("value"));

		}

		System.out.println(singleSelect.isMultiple());
		
		System.out.println(singleSelect.getFirstSelectedOption().getText());
		List<WebElement> allSelectedOptions =singleSelect.getAllSelectedOptions();
		System.out.println(allSelectedOptions.size());
		for (WebElement obj:allSelectedOptions) {
			System.out.println(obj.getText());
		}
		

		// Multi select
		WebElement multiDropdown = driver.findElement(By.id("multi-select"));

		Select multiDropBox= new Select(multiDropdown);

		
		multiDropBox.selectByIndex(2);
		multiDropBox.selectByIndex(5);
	    multiDropBox.selectByIndex(7); 
		multiDropBox.selectByValue("Ohio");

		multiDropBox.selectByVisibleText("Washington");

		System.out.println(multiDropBox.getFirstSelectedOption().getText());

		List<WebElement> allSelectedOptions2 = multiDropBox.getAllSelectedOptions();

		for (WebElement ele : allSelectedOptions2) {
		System.out.println(ele.getText());

		}
		Thread. sleep (2000);

		multiDropBox.deselectByVisibleText("Ohio");
		Thread.sleep (2000);
		multiDropBox.deselectAll();

		}
	}
