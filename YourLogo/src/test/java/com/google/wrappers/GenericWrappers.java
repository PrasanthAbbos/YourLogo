package com.google.wrappers;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


public class GenericWrappers extends TestDataProvider {

	public RemoteWebDriver driver;
	public void invokeApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.geckodriver.driver", "./Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./Drivers/IE.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
			System.out.println("The given URL '" + url + "' is launched in '" + browser + "' browser successfully.");
		} catch (WebDriverException e) {
			System.out.println(e.toString());
			System.err.println("The given URL '" + url + "' is not launched in '" + browser + "' browser successfully.");
		}
	}

	public void enterById(String idValue, String data) {
		try {
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The webelement with an ID: '" + idValue + "' is identified and entered with the data '"
					+ data + "' successfully.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		} 
	}

	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("The webelement with the XPATH: '" + xpathValue+ "' is identified and entered with the data '" + data + "' successfully.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		} 
	}

	public void verifyTextById(String id, String text) {
		String strTextAct = null;
		try {
			strTextAct = driver.findElementById(id).getText();
			if (strTextAct.equals(text)) {
				System.out.println("The Actual Text '" + strTextAct + "' from the ID: '" + id
						+ "' matches with the Expected Text '" + text + "'.");
			} else {
				System.err.println("The Actual Text '" + strTextAct + "' from the ID: '" + id
						+ "' doesn't matches with the Expected Text '" + text + "'.");
			}
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		}
	}

	public void verifyTextByXpath(String xpath, String text) {
		String strTextAct = null;
		try {
			strTextAct = driver.findElementByXPath(xpath).getText();
			if (strTextAct.equals(text)) {
				System.out.println("The Actual Text '" + strTextAct + "' from the XPATH: '" + xpath
						+ "' exactly matches with the Expected Text '" + text + "'.");
			} else {
				System.err.println("The Actual Text '" + strTextAct + "' from the XPATH: '" + xpath
						+ "' doesn't exactly matches with the Expected Text '" + text + "'.");
			}
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		}
	}

	public void clickById(String id) {
		try {
			driver.findElementById(id).click();
			System.out.println("The webelement with an ID: '" + id + "' is identified and clicked successfully.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		}
	}

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The webelement with the XPATH: '" + xpathVal + "' is identified and clicked successfully.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		} 
	}

	public void clickByLink(String name) {
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The webelement with the LINK: '" + name + "' is identified and clicked successfully.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		} 
	}

	public String getTextById(String idVal) {
		String strText = null;
		try {
			strText = driver.findElementById(idVal).getText();
			System.out.println("The webelement with an ID: '" + idVal + "' is identified and the available text is '"
					+ strText + "'.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		}
		return strText;
	}

	public void selectVisibileTextById(String id, String value) {
		try {
			Select sel = new Select(driver.findElementById(id));
			sel.selectByVisibleText(value);
			System.out.println("The webelement with an ID: '" + id + "' is identified and selected the text '" + value
					+ "' successfully.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		}
	}

	public void selectIndexById(String id, int value) {
		try {
			Select sel = new Select(driver.findElementById(id));
			sel.selectByIndex(value);
			System.out.println("The webelement with an ID: '" + id + "' is identifed and selected the index '" + value
					+ "' successfully.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		}
	}

	public void switchToParentWindow() {
		String strWinsName = null;
		boolean blnFound = false;
		try {
			Set<String> allWins = driver.getWindowHandles();
			for (String eachWins : allWins) {
				driver.switchTo().window(eachWins);
				blnFound = true;
				break;
			}
			if (blnFound) {
				System.out.println("The latest window (" + strWinsName + ") is focused successfully.");
			} else {
				System.err.println("The parent window is not found.");
			}
		} catch (NoSuchWindowException e) {
			System.err.println("the 	target window is unavailable so the window switch is unsuccessful.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		}
	}

	public void switchToLastWindow() {
		String strWinsName = null;
		boolean blnFound = false;
		try {
			Set<String> allWins = driver.getWindowHandles();
			for (String eachWins : allWins) {
				driver.switchTo().window(eachWins);
				strWinsName = eachWins;
				blnFound = true;
			}
			if (blnFound) {
				System.out.println("The latest window (" + strWinsName + ") is focused successfully.");
			} else {
				System.err.println("The lastest window is not found.");
			}
		} catch (NoSuchWindowException e) {
			System.err.println("The window switch is unsuccessful as the 	target window is unavailable.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		}
	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			System.out.println("The alert has been accepted successfully.");
		} catch (NoAlertPresentException e) {
			System.err.println("There is not alert displayed to handle.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		}
	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("The alert has been dismissed successfully.");
		} catch (NoAlertPresentException e) {
			System.err.println("There is not alert displayed to handle.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		}
	}

	public String getAlertText() {
		String strAlertText = null;
		try {
			strAlertText = driver.switchTo().alert().getText();
			System.out.println("The text in the displayed alert is '" + strAlertText + "'.");
		} catch (NoAlertPresentException e) {
			System.err.println("There is not alert displayed to handle.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		}
		return strAlertText;
	}

	public void closeBrowser() {
		try {
			driver.close();
			System.out.println("The active browser is closed successully.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		} 
	}

	public void closeAllBrowsers() {
		try {
			if (driver != null) {
				driver.quit();
				System.out.println("All the browsers are closed successully.");
			}
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		} 
	}


	public String getAttributeById(String idVal, String strAttribute) {
		String strText = null;
		try {
			strText = driver.findElementById(idVal).getAttribute(strAttribute);
			System.out.println("The webelement with the ID: '" + idVal + "' and having attribute '" + strAttribute
					+ "' is identified successfully and the available text is '" + strText + "'.");
		} catch (NoSuchElementException e) {
			System.err.println("The webelement with the ID: '" + idVal + "' is not found.");
		} catch (ElementNotVisibleException e) {
			System.err.println("The webelement with the ID: '" + idVal + "' is not visible.");
		} catch (ElementNotInteractableException e) {
			System.err.println("The webelement with the ID: '" + idVal + "' is not enabled.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		}
		return strText;
	}

	public String getAttValByXpath(String xpathVal, String strAttribute) {
		String strText = null;
		try {
			strText = driver.findElementByXPath(xpathVal).getAttribute(strAttribute);
			System.out.println("The webelement with the XPATH: '" + xpathVal + "' and having attribute '" + strAttribute+ "' is identified successfully and the available text is '" + strText + "'.");
		} catch (WebDriverException e) {
			System.err.println("The application got crashed for unknown error.");
		}
		return strText;
	}
	
	public void threadSleep(long miliSecs) {
		try {
			Thread.sleep(miliSecs);
		} catch (Exception e) {
			System.err.println();
		} 
	}
}
