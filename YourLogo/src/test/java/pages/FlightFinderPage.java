package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage {

WebDriver driver;
Select sel;
	
	
	@FindBy(xpath = "//body//b//input[1]") WebElement RoundTrip;
	@FindBy(xpath = "//body//b//input[2]") WebElement OneTrip;
	@FindBy(xpath = "//select[@name='passCount']") WebElement PassengerCount;
	@FindBy(xpath = "//select[@name='fromPort']") WebElement DepatureFrom;
	@FindBy(xpath = "//select[@name='fromMonth']") WebElement DepatureOn;
	@FindBy(xpath = "//select[@name='fromDay']") WebElement DepatureDay;
	@FindBy(xpath = "//select[@name='toPort']") WebElement ArrivalTo;
	@FindBy(xpath = "//select[@name='toMonth']") WebElement ArrivalOn;
	@FindBy(xpath = "//select[@name='toDay']") WebElement ArrivalDay;
	@FindBy(xpath = "//font[contains(text(),'Economy class')]") WebElement ServiceClass;
	@FindBy(xpath = "//select[@name='airline']") WebElement Airline;
	@FindBy(xpath = "//input[@name='findFlights']") WebElement FindFightbtn;
	
	public FlightFinderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setTripType(String TripType) {
		if(TripType.equalsIgnoreCase(" Round Trip")){
			RoundTrip.click();
		}else if(TripType.equalsIgnoreCase("One Way")){
			OneTrip.click();
		}else{
			System.out.println("Invalid Entry");
		}
	}
	
	public void setNoofPassenger(int count) {
		sel = new Select(PassengerCount);
		if(count<=1 && count<=4){
			sel.selectByIndex(count+1);
		}
	}
	
	public void setDepaturefrom(String DepatureFromstr) {
		sel = new Select(DepatureFrom);
		sel.selectByVisibleText(DepatureFromstr);
	}	
	public void setDepatureon(String DepatureOnstr) {
		sel = new Select(DepatureOn);
		sel.selectByVisibleText(DepatureOnstr);
	}
	public void setDepatureday(String Depaturedaystr) {
		sel = new Select(DepatureDay);
		sel.selectByVisibleText(Depaturedaystr);
	}
	public void setAriivalTo(String ArrivalTOstr) {
		sel = new Select(ArrivalTo);
		sel.selectByVisibleText(ArrivalTOstr);
	}
	public void setArrivalon(String ArrivalOnstr) {
		sel = new Select(ArrivalOn);
		sel.selectByVisibleText(ArrivalOnstr);
	}
	public void setArrivalday(String ArrivalDaystr) {
		sel = new Select(ArrivalDay);
		sel.selectByVisibleText(ArrivalDaystr);
	}

	

}
