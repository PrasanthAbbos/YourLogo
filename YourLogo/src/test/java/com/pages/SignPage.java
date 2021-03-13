package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignPage {

	@FindBy(xpath="//a[contains(text(),'Sign in')]")WebElement signBtn;

	WebDriver driver;

	public SignPage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
}
