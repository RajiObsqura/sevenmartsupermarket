package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.PageUtilities;

public class AdminUserPage {
	WebDriver driver;
	PageUtilities pageutility;

	@FindBy(xpath = "(//a[@class='small-box-footer'])[2]")
	WebElement adminbutton;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[2]")
	WebElement newbutton ;
	//webelements for inputting data
	@FindBy(xpath="//input[@id='un']")
	WebElement username;
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	@FindBy(xpath="//select [@id='user_type']")
	WebElement staff;
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement submitnewuser;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButtton;
	
	@FindBy(xpath="//input[@id='un']")
	WebElement usernamesearch;
	@FindBy(xpath="//select[@id='ut']")
	WebElement usertype;
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement searchuserbutton;
	
	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void adminUserClick() {
		adminbutton.click();
	}

	public void newButtonClick() {
		newbutton.click();
	}
	public void  getUserNameClick()
	{
	     username.sendKeys("kiran");
	}
	public void getpasswordClick()
	{
		password .sendKeys("Kiran");
	}
	public void getStaffType()
	{
		Select select=new Select(staff);
		select.selectByIndex(5);
		select.selectByValue("Delivery Boy");
		
	}
	public void savenewuser()
	{
		submitnewuser.click();
	}
	public void searchUser()
	{
		searchButtton.click();
	}
	public void searchUsername(String username)
	{
		 usernamesearch.sendKeys(username);
	}
	public void searchUserType(String userType)
	{
		usertype.sendKeys(userType);
		
	}
	public void searchClick()
	{
		 searchuserbutton.click();
	}
	}

