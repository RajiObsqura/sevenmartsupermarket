package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.PageUtilities;

public class PushNotification {
WebDriver driver;
PageUtilities pageutility ;
	
	@FindBy(xpath ="//input[@id='title']")
	private WebElement titleField;
	@FindBy(xpath ="//input[@id='description']")
	private WebElement discriptionField;
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement sendbtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement notificationAlert;
	
	public PushNotification(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterTitle(String title) {
		titleField.sendKeys(title);
		}
		public void enterDiscription(String discription) {
			discriptionField.sendKeys(discription);
		}
		public void sendbutton() {
			sendbtn.click();
		}
		
		public void sendNotification(String title,String discription) {
			enterTitle(title);
			enterDiscription(discription);
			sendbutton();
		}
		public String verifyAlertMsg()
		{
			return notificationAlert.getText();
			
		}
		public boolean alert_PushCloseButtonDisplayed()
		{
				pageutility=new PageUtilities (driver); 
				boolean displayed=pageutility.isDisplayed(alertbutton);
				return displayed;

			}
		}
	
	


