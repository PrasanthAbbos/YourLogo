package com.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.google.wrappers.GenericWrappers;

public class GooglePage extends GenericWrappers {

			public GooglePage() {
				
			}
			
			public GooglePage(RemoteWebDriver driver) {
				this.driver = driver;
			}
			public GooglePage enterSearchWord(String strKeyWord) {
				enterByXpath("//*[@id='tsf']/div[2]/div/div[1]/div/div[1]/input", strKeyWord);
				return this;
			}
			public GooglePage clickSearch() {
				clickByXpath("//*[@id='tsf']/div[2]/div/div[3]/center/input[1]");
				return this;
			}
}
