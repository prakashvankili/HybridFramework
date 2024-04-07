package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseTest;

public class Basepage extends BaseTest {

public void ValidateTitle(String expTitle) {
		
		Assert.assertEquals(driver.getTitle(), expTitle);
	}


public void type(WebElement element , String text) {
	element.sendKeys(text);
	
}
public void click(WebElement element) {
	element.click();
	
}
public void selectValueFromDropdown(WebElement element , String text) {
	new Select(element).selectByVisibleText(text);
}
public String verifyText(WebElement element,String text) {
	String ele =element.getText();
	Assert.assertEquals(ele, text);
	return text;
}
public void clear(WebElement element) {
	element.clear();
}
}