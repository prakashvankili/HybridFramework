package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;

public class ValidateLogin extends BaseTest {

	
	
	@Test(dataProvider = "getData")
	public void validateLogin(HashMap<String, String> finaldata)
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(finaldata.get("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(finaldata.get("password"));
		driver.findElement(By.xpath("//input[@name='login']")).click();
	
		Assert.assertEquals(driver.getTitle(),finaldata.get("Expected Title"));
	}
	@DataProvider
	public Object[][] getData(){
		Object[][]  exceldata = new Object[1][1];
		   exceldata[0][0] = UtilKit.getTestDataFromExcel("Tc-100");
		   
		return exceldata;
		
	}
}
