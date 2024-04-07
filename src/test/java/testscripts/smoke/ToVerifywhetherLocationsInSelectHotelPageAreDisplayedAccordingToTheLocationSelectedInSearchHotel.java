package testscripts.smoke;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;
import pages.SelectHotel;
import utils.UtilKit;

public class ToVerifywhetherLocationsInSelectHotelPageAreDisplayedAccordingToTheLocationSelectedInSearchHotel extends BaseTest{

	@Test(dataProvider = "getData")
	public void validateSelectHotelPage(HashMap<String, String>  realData) {
		
		LoginPage LoginPage= new LoginPage();
		LoginPage.username_textbox(realData.get("username"));
		LoginPage.password_textbox(realData.get("password"));
		LoginPage.login_button();
		
		SearchHotelPage SearchHotelPage= new SearchHotelPage();
		SearchHotelPage.ValidateTitle(realData.get("Expected Title1"));
		SearchHotelPage.selectLocation(realData.get("Location"));
		SearchHotelPage.selectNoOfRooms(realData.get("Number of Rooms"));
		SearchHotelPage.EnterChekInDate(realData.get("Check In Date"));
		SearchHotelPage.EnterChekOutDate(realData.get("Check Out Date")); 
		SearchHotelPage.selectNoOfAdultsPerRoom(realData.get("Adults per Room"));
		SearchHotelPage.Search();
		
		SelectHotel SelectHotel = new SelectHotel();
		SelectHotel.validateTextOnSelectHotelPage(realData.get("Expected Title3"));
		SelectHotel.SelectRadioButton3();
		SelectHotel.ClickContinue();
		
		
		
		
	}
	
	
	
	
	
	@DataProvider
	public Object[][] getData(){
		
		 Object[][] data = new  Object[1][1];
		 data[0][0] = UtilKit.getTestDataFromExcel("TC-103");
		return data;
		
	}
	
}
