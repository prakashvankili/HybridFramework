package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.UtilKit;

public class ValidateLoginUsingPOM  extends BaseTest{

	
	@Test(dataProvider = "getData")
	public void validateLogin(HashMap<String, String> actData) {
		
		  LoginPage lp = new LoginPage();
		 lp.username_textbox(actData.get("username"));
		 lp.password_textbox(actData.get("password"));
		 lp.login_button();
		lp.ValidateTitle(actData.get("Expected Title"));
	}
	
	@DataProvider
	public Object[][] getData(){
		 Object[][] data=new  Object[1][1];
		 data[0][0] = UtilKit.getTestDataFromExcel("Tc-100");
		return data;
		
	}
	
}
