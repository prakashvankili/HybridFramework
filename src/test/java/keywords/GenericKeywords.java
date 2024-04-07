package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import base.BaseTest;

public class GenericKeywords extends BaseTest{
	
	
	public void openBrowser() {
		
		String browser =prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("edge")) 
			driver = 	new EdgeDriver();
	}
	 public void launchApp() {
		 driver.get(prop.getProperty("url"));
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("implicitWait"))));
	 }
	 
	 public void type(String locaterkey , String text) {
		 
		 getElement(locaterkey).sendKeys(text);;
	
	 }
	 public void click(String locaterkey) {
		 getElement(locaterkey).click();
		 
	 }
	 public void selectOptionsFromDropDown(String locaterkey,String option) {
		 new Select(getElement( locaterkey)).selectByVisibleText("option");
		 
	 }
	 
	 public WebElement getElement(String locaterkey) {
		 WebElement  element = null ;
		 element= driver.findElement(getLocater(locaterkey));
		 
		return element;
		 
	 }
	public By getLocater(String locaterkey) {
		 By  by = null ;
		 if(locaterkey.endsWith("_id"))
		 {
			 by=By.id(prop1.getProperty(locaterkey)) ;
		 }
		 if(locaterkey.endsWith("_name"))
		 {
			 by=By.name(prop1.getProperty(locaterkey)) ;
		 }
		 if(locaterkey.endsWith("_linktext"))
		 {
			 by=By.linkText(prop1.getProperty(locaterkey)) ;
			 
		 }
		 else {
			 by=By.xpath(prop1.getProperty(locaterkey)) ;
		 }
		return by;
		 
	 }
	public void close() {
		driver.close();
	}
	 
	 
	 
	 
	 
}
