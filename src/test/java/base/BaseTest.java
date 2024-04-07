package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	 public static WebDriver driver;
	 public  static Properties prop;
	 public static  Properties prop1;
	 
	 @BeforeTest
	 public void browserSetup() throws IOException {
		 
		 FileInputStream fis = new FileInputStream("src\\test\\resources\\properties\\config.properties");
		  prop = new Properties();
		 prop.load(fis);
	
		 FileInputStream fis1 = new FileInputStream("src\\test\\resources\\properties\\locators.properties");
		  prop1 = new Properties();
		 prop1.load(fis1);
		 
	 }
	 
	 
	@BeforeMethod
	public void setUp() {
		
		String browsers = prop.getProperty("browser");
		if(browsers.equalsIgnoreCase("chrome"))
		     driver =	new ChromeDriver();
		else if (browsers.equalsIgnoreCase("firefox"))
			driver =	new FirefoxDriver();
		else if(browsers.equalsIgnoreCase("edge"))
		driver =	new EdgeDriver();	
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("implicitWait"))));
		driver.get(prop.getProperty("url"));
		
	}


	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
