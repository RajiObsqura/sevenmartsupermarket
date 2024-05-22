package com.sevenmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sevenmartsupermarket.utilities.GeneralUtilities;
import com.sevenmartsupermarket.utilities.PageUtilities;

public class ManageLocationPage {
	WebDriver driver;
	PageUtilities pageutility;
	GeneralUtilities generalutilitiy = new GeneralUtilities();
	
	@FindBy(xpath = "(//a[@class='small-box-footer'])[11]")
	private WebElement managelocationbutton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	@FindBy(xpath="//select[@id='country_id']")
	private WebElement countryid;
	@FindBy(xpath="//select[@id='st_id']")
	private WebElement stateid;
	@FindBy(xpath="//input[@id='location']")
	private WebElement locationid;
	@FindBy(xpath="//input[@id='delivery']")
	private WebElement deliverycharge;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement savebutton;
	//alert
	@FindBy(xpath="//button[@class='close']")
	private WebElement alertaddlocation;
	
	
	
	public  ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void manageLocationButtonclick()
	{
		managelocationbutton.click();
	}
	public void newButtonClick()
	{
		newbutton.click();
	}
	public void addNewLocation()
	{
		countryid.sendKeys("United Kingdom");
		stateid.sendKeys("Cambridge");
		locationid.sendKeys("trivandrum");
		deliverycharge.sendKeys("200");
		savebutton.click();
		
	}
	public String  alertCheckForAddLocation()
	{
		/*Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		return alertMessage;*/
		//WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebDriverWait wait=new WebDriverWait(driver, 10);
  //      wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alertaddlocation.getText();
		return alertText;
		
}
	
}

