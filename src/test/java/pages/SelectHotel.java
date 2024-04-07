package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends Basepage {
	
	
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='radiobutton_3']")
	WebElement RadioButton3 ;
	
	@FindBy(xpath="//input[@name='continue']")
	WebElement Continue ;

	
	@FindBy(xpath="//td[text()='Select Hotel ']")
	WebElement ValidateText ;
	
	public void SelectRadioButton3()
	{
		click(RadioButton3);
	}
	public void ClickContinue()
	{
		click(Continue);
	}
	public void validateTextOnSelectHotelPage(String ExpText)
	{
		verifyText(ValidateText, ExpText);
	}
}
