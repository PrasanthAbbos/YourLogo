package com.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		WebElement selEle = driver.findElement(By.id("select-demo"));
		Select sel = new Select(selEle);
		sel.selectByVisibleText("Thursday");
		sel.selectByIndex(2);
		sel.selectByValue("Saturday");
		driver.close();
	}
}
