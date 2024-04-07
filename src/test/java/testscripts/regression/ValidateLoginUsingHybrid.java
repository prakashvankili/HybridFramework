package testscripts.regression;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;


public class ValidateLoginUsingHybrid extends BaseTest {

	@Test(dataProvider = "getData")
	public void vaidateLogin(HashMap<String, String> actdata) {
		ApplicationKeywords login = new ApplicationKeywords();
		login.openBrowser();
		login.launchApp();
        login.type("username_testbox", actdata.get("username"));
        login.type("password_textbox", actdata.get("password"))	;
        login.click("login_button");
        login.validateTitle(actdata.get("Expected Title"));
        login.close();
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[1][1] ;
		data[0][0] = UtilKit.getTestDataFromExcel("Tc-100");
		return data;
		
	}
	
}
