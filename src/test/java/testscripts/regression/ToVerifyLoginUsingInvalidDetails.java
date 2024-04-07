package testscripts.regression;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class ToVerifyLoginUsingInvalidDetails extends BaseTest {

	
	
	@Test
	public void VerifyValidUsernameInvalidPassword() {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("prakashvankili");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@name='login']")).click();
	
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Hotel Reservation System");
	}
	@Test
public void VerifyInValidUsernamevalidPassword() {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("prakash");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("0NU16V");
		driver.findElement(By.xpath("//input[@name='login']")).click();
	
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Hotel Reservation System");
	}
	@Test
public void VerifyInValidUsernameInvalidPassword() {
	
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("prakash");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("0897");
	driver.findElement(By.xpath("//input[@name='login']")).click();

	Assert.assertEquals(driver.getTitle(),"Adactin.com - Hotel Reservation System");
}
}
