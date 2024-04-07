package testscripts.regression;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class ToVerifyLoginUsingDtaprovider extends BaseTest {
	
@Test(dataProvider = "logindata")
	public void ToVerifyValidLoginDetailsTest(String username ,String password, String title) {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='login']")).click();
	
		Assert.assertEquals(driver.getTitle(),title);

	}
	
	@DataProvider
	public Object[][] logindata(){
		Object[][]  data = new Object[4][3];
		
		data[0][0] = "prakashvankili" ;
		data[0][1] = "0NU16V" ;
		data[0][2] = "Adactin.com - Search Hotel" ;
		
		data[1][0] = "prakashvankili" ;
		data[1][1] = "abc" ;
		data[1][2] = "Adactin.com - Hotel Reservation System" ;
		
		data[2][0] = "prakash" ;
		data[2][1] = "0NU16V" ;
		data[2][2] = "Adactin.com - Hotel Reservation System" ;
		
		data[3][0] = "prakash" ;
		data[3][1] = "abc" ;
		data[3][2] = "Adactin.com - Hotel Reservation System" ;
		
		return data;
		
	}
}
