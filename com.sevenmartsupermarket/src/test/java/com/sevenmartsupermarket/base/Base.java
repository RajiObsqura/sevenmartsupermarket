package com.sevenmartsupermarket.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.sevenmartsupermarket.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	Properties properties = new Properties();

	/** Base Constructor **/
	/* The constructor Base() loads properties from a configuration file specified by Constants.CONFIG_FILE_PATH */
	
	public Base() {
		try {
			FileInputStream fs = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**initializing browser**/
		public void initialize(String browser,String url)
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else 
			if(browser.equals("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			else
				if(browser.equals("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}	
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	
	}

	@BeforeMethod 
	/* The launchBrowser() method annotated with @BeforeMethod initializes the browser before each test method is
	 *  executed by retrieving the browser type and URL from the properties file and passing them to the
	 *   initialize() method.This setup ensures that your tests start with a fresh browser instance, 
	 *   maximizing reusability and maintainability.*/
	
		public void launchBrowser()
		{
		String browzer=properties.getProperty("browser");
		String url=properties.getProperty("url");
		initialize(browzer,url);
		}

}
