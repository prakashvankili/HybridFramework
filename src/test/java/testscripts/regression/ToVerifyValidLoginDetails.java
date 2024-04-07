package testscripts.regression;




import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class ToVerifyValidLoginDetails extends BaseTest {

	
	

	@Test
	public void ToVerifyValidLoginDetailsTest() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("prakashvankili");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("0NU16V");
		driver.findElement(By.xpath("//input[@name='login']")).click();
	
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Search Hotel");

	}
	
	
	
	

}
