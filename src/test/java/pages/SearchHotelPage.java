package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage extends Basepage {
	
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	// WebElements

	@FindBy(xpath = "//td[@class='welcome_menu'][1]")
	WebElement welcomeText;
	
	@FindBy(xpath = "//select[@name='location']")
	WebElement Location;

	@FindBy(xpath = "//select[@name='room_nos']")
	WebElement no_of_rooms;

	@FindBy(xpath = "//input[@name='datepick_in']")
	WebElement Check_In_Date;

	@FindBy(xpath = "//input[@name='datepick_out']")
	WebElement Check_Out_Date;

	@FindBy(xpath = "//select[@name='adult_room']")
	WebElement AdultsPerRoom;

	@FindBy(xpath = "//input[@name='Submit']")
	WebElement Submit;

	// Actions on WebElements
	
	public void verifyWelcomeText(String text) {
		verifyText(welcomeText, text);
	}
	public void selectLocation(String text) {
		selectValueFromDropdown(Location, text);
	}

	public void selectNoOfRooms(String text) {
		selectValueFromDropdown(no_of_rooms, text);
	}

	public void EnterChekInDate(String text) {
		clear(Check_In_Date);
		type(Check_In_Date, text);

	}

	public void EnterChekOutDate(String text) {
		clear(Check_Out_Date);
		type(Check_Out_Date, text);

	}

	public void selectNoOfAdultsPerRoom(String text) {
		selectValueFromDropdown(AdultsPerRoom, text);
	}

	public void Search() {
		click(Submit);

	}

}
