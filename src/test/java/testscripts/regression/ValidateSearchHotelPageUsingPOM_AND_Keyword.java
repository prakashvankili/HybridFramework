package testscripts.regression;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class ValidateSearchHotelPageUsingPOM_AND_Keyword extends BaseTest{
	
	@Test(dataProvider = "getData")
	public void validateLogin1(HashMap<String, String> realData) {
		
		LoginPage lp = new LoginPage();
		lp.username_textbox(realData.get("username"));
		lp.password_textbox(realData.get("password"));
		lp.login_button();
		
		SearchHotelPage SearchHotelPage= new SearchHotelPage();
		
		SearchHotelPage.ValidateTitle(realData.get("Expected Title1"));
		SearchHotelPage.selectLocation(realData.get("Location"));
		SearchHotelPage.selectNoOfRooms(realData.get("Number of Rooms"));
		SearchHotelPage.EnterChekInDate(realData.get("Check In Date"));
		SearchHotelPage.EnterChekOutDate(realData.get("Check Out Date")); 
		SearchHotelPage.selectNoOfAdultsPerRoom(realData.get("Adults per Room"));
		SearchHotelPage.Search();
		
	}

	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[1][1] ;
		data[0][0] = UtilKit.getTestDataFromExcel("TC-102");
		return data;
		
	}
	}

