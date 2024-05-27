package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	// driver
	WebDriver driver;

	// aggregations
	Properties properties = new Properties();

	// find by xpath
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;// encapsulation
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement loginelement;
	@FindBy(xpath = "//img[@class='img-circle']")
	WebElement userimage;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	WebElement logoutdropdown;
	
	By homepagewaitElement=By.xpath("//a[@class='d-block']");
	// constructors

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream fs = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fs);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// methods
	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void loginBtn() {
		loginelement.click();
	}

	public void login() {
		WaitUtility waitutility=new WaitUtility(driver);
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		loginBtn();
		waitutility.waitForElementToBeVisible(homepagewaitElement, 1000);
	}

	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		loginBtn();

	}

	public void logoutuser() {
		userimage.click();
		logoutdropdown.click();
	}

}
