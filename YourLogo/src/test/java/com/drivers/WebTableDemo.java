package com.drivers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		List<WebElement> stru= driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr"));
		
		for(int i=1;i<=stru.size();i++) {
			WebElement stu = driver.findElement(By.xpath("//table[@class='tsc_table_s13']//tbody//tr["+i+"]//th"));
			System.out.println(stu.getText());
		}
	}

}
