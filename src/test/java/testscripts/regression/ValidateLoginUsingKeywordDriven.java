package testscripts.regression;

import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;


public class ValidateLoginUsingKeywordDriven extends BaseTest {

	@Test
	public void vaidateLogin() {
		ApplicationKeywords login = new ApplicationKeywords();
		login.openBrowser();
		login.launchApp();
        login.type("username_testbox", "prakashvankili");
        login.type("password_textbox", "0NU16V");
        login.click("login_button");
        login.validateTitle("Adactin.com - Search Hotel");
        login.close();
	}
	
}
