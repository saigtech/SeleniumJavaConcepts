package com.automation.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class RunTest {
    public static void main(String[] args) {
    	//System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://selenium.dev");
        driver.findElement(By.xpath("/html/body/header/nav/div/ul/li/a")).click();
        driver.findElement(By.xpath("//a[@href='/history']")).click();

        driver.quit();
    }
}
