package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;


 public class HomePage {
	 WebDriver driver;
		
		@FindBy(xpath ="//a[@class='d-block']" )
		WebElement userProfileElement;
		@FindBy(xpath="//p[text()='Push Notifications']")
		private WebElement pushbutton;
		
		public HomePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public String getProfileName() {
			return userProfileElement.getText();
		}
		public void pushNotificationClick()
		{
			 pushbutton.click();		}
	}
	
