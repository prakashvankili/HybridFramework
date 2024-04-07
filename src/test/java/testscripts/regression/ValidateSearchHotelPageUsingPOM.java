package testscripts.regression;

import java.util.HashMap;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;

public class ValidateSearchHotelPageUsingPOM extends BaseTest{
 
	
	@Test
	public void SearchingForHotel() {
		LoginPage lpl = new LoginPage();
		lpl.username_textbox("prakashvankili");
		lpl.password_textbox("0NU16V");
		lpl.login_button();
		lpl.ValidateTitle("Adactin.com - Search Hotel");
		
		SearchHotelPage shp = new SearchHotelPage();
		
		shp.selectLocation("Paris");
		shp.selectNoOfRooms("1 - One");
		shp.EnterChekInDate("29/03/2024");
		shp.EnterChekOutDate("29/03/2024");
		shp.selectNoOfAdultsPerRoom("2 - Two");
		shp.Search();
	}
}
